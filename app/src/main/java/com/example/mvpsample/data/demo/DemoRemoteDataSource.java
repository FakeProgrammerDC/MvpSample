package com.example.mvpsample.data.demo;

import androidx.annotation.Nullable;

import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;
import com.example.mvpsample.data.task.TasksLocalDataSource;
import com.example.mvpsample.network.Api;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class DemoRemoteDataSource implements DemoDataSource {
    @Nullable
    private static DemoRemoteDataSource INSTANCE;

    public static DemoRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DemoRemoteDataSource();
        }
        return INSTANCE;
    }


    @Override
    public Flowable<BaseResponse<List<AdvertisingData>>> getDemoDataList() {
        return Api.getDefault().getHomeAdvertisingList();
    }

    @Override
    public List<AdvertisingData> getAdvertisingDataList() {
        return null;
    }
}
