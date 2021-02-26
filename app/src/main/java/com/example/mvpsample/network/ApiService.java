package com.example.mvpsample.network;

import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/home/bannerList")
    Flowable<BaseResponse<List<AdvertisingData>>> getHomeAdvertisingList();//首页广告
}
