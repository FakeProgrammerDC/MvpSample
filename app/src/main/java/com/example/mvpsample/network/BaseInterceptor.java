package com.example.mvpsample.network;

import android.os.Build;

import com.example.mvpsample.utils.SHAUtil;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {

    private Map<String, String> headers;

    public BaseInterceptor() {
    }

    public BaseInterceptor(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originRequest = chain.request();
        Request.Builder builder = originRequest.newBuilder();

        builder.addHeader("USER_TOKEN",  "");
        builder.addHeader("USER_DEVICE_ID", UUID.randomUUID().toString());
        builder.addHeader("APP_VER", "3.4.0");
        builder.addHeader("PLAT_TYPE", "android");
        //android.os.Build.MODEL + "|" + android.os.Build.VERSION.RELEASE
        builder.addHeader("PLAT_INFO", Build.MANUFACTURER + "_" + Build.MODEL + "|" + Build.VERSION.RELEASE);
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey)).build();
            }
        }
//        String cookie = BuProcessor.getInstance().getCookie();
//        if (!TextUtils.isEmpty(cookie)){
//            builder.addHeader("cookie", cookie.substring(0,cookie.length()-1)).build();
//        }
        //接口URL
        String requestUrl = originRequest.url().toString();
        long timeStamp = System.currentTimeMillis();
        builder.addHeader("EV_TS", String.valueOf(timeStamp));
        String signString = SHAUtil.getSignString(requestUrl, timeStamp, UUID.randomUUID().toString());
        builder.addHeader("EV_SIGN", SHAUtil.encode(signString));
        //EvLog.e(signString);

        originRequest = builder.build();

        //为个别接口重新设置超时时间
        if (requestUrl.contains("configure/global") ||
                requestUrl.contains("advertise/list")) {
            return chain.withConnectTimeout(3, TimeUnit.SECONDS)
                    .withReadTimeout(2, TimeUnit.SECONDS)
                    .proceed(originRequest);
        } else {
            return chain.proceed(originRequest);
        }
    }
}
