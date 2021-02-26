package com.example.mvpsample.data.demo;

import androidx.annotation.Nullable;

import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;
import com.example.mvpsample.data.task.TasksLocalDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class DemoLocalDataSource implements DemoDataSource {
    @Nullable
    private static DemoLocalDataSource INSTANCE;

    public static DemoLocalDataSource getInstance(){
        if (INSTANCE==null){
            INSTANCE=new DemoLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Flowable<BaseResponse<List<AdvertisingData>>> getDemoDataList() {
        return null;
    }

    @Override
    public List<AdvertisingData> getAdvertisingDataList() {
        return null;
    }
}
