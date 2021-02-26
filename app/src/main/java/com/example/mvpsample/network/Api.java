package com.example.mvpsample.network;

import android.util.SparseArray;

import com.example.mvpsample.MainApp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    //读超时长，单位：秒
    public static final int READ_TIME_OUT = 5;
    //连接时长，单位：秒
    public static final int CONNECT_TIME_OUT = 5;

    private static Api mApi;

    private ApiService mApiService;

    private Api() {

        //开启Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        File cacheFile = new File(MainApp.getInstance().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(logInterceptor)
                .addNetworkInterceptor(new BaseInterceptor())
                //.addNetworkInterceptor(new CacheInterceptor())
                .cache(cache);

        OkHttpClient okHttpClient = builder.build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://app-api-test2.e-chong.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);

    }


    public static ApiService getDefault() {
        return getDefault(null);
    }

    public static ApiService getDefault(Map<String, String> headers) {

        if (mApi == null) {
            mApi = new Api();
        }
        return mApi.mApiService;
    }

}
