package com.example.mvpsample.data.demo;

import androidx.annotation.Nullable;

import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;
import com.example.mvpsample.data.task.TasksLocalDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface DemoDataSource {

    Flowable<BaseResponse<List<AdvertisingData>>> getDemoDataList();

    List<AdvertisingData> getAdvertisingDataList();

}
