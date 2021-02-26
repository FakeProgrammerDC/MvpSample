package com.example.mvpsample.data.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;


import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public class DemoRepository implements DemoDataSource {
    @Nullable
    private static DemoRepository INSTANCE = null;

    @NonNull
    private final DemoDataSource mDemoRemoteDataSource;

    @NonNull
    private final DemoDataSource mDemoLocalDataSource;

    private DemoRepository(@NonNull DemoDataSource demoRemoteDataSource, @NonNull DemoDataSource demoLocalDataSource) {
        mDemoRemoteDataSource = demoRemoteDataSource;
        mDemoLocalDataSource = demoLocalDataSource;
    }

    public static DemoRepository getInstance(@NonNull DemoDataSource demoRemoteDataSource, @NonNull DemoDataSource demoLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DemoRepository(demoRemoteDataSource, demoLocalDataSource);
        }
        return INSTANCE;
    }


    @Override
    public Flowable<BaseResponse<List<AdvertisingData>>> getDemoDataList() {
//        return mDemoRemoteDataSource.getDemoDataList().toMap(new Function<BaseResponse<List<AdvertisingData>>, List<AdvertisingData>>() {
//            @Override
//            public List<AdvertisingData> apply(BaseResponse<List<AdvertisingData>> listBaseResponse) throws Throwable {
//                return null;
//            }
//        });
        return mDemoRemoteDataSource.getDemoDataList();
    }

    @Override
    public List<AdvertisingData> getAdvertisingDataList() {
//         mDemoRemoteDataSource.getDemoDataList().toMap(new Function<BaseResponse<List<AdvertisingData>>, List<AdvertisingData>>() {
//            @Override
//            public List<AdvertisingData> apply(BaseResponse<List<AdvertisingData>> listBaseResponse) throws Throwable {
//                return listBaseResponse.data;
//            }
//        })
        return null;
    }

    public Single<Map<List<AdvertisingData>, BaseResponse<List<AdvertisingData>>>> getList() {
        return mDemoRemoteDataSource.getDemoDataList().toMap(new Function<BaseResponse<List<AdvertisingData>>, List<AdvertisingData>>() {
            @Override
            public List<AdvertisingData> apply(BaseResponse<List<AdvertisingData>> listBaseResponse) throws Throwable {
                return listBaseResponse.data;
            }
        });
    }
}
