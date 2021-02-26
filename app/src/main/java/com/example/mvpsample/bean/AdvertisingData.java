package com.example.mvpsample.bean;

import java.io.Serializable;

/**
 * Created by chao.dong on 2018/9/13.
 */

public class AdvertisingData implements Serializable {

    private Long bannerItemId;
    private long activityItemId;
    private String imgUrl;//图片地址
    private int imgType;//图片类型 1:静态图片 2:gif ,
    private String effectDate;//生效时间 ,
    private String expireDate;//过期时间
    private int countDown;//倒计时(单位:s)
    private int countDownFlag;//倒计时启用标志 0:不启用 1:启用 ,
    private String imgLocationSD;
    private String title;

    private int status;//活动状态

    public void setBannerItemId(Long bannerItemId) {
        this.bannerItemId = bannerItemId;
    }

    public Long getBannerItemId() {
        return bannerItemId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public int getCountDownFlag() {
        return countDownFlag;
    }

    public void setCountDownFlag(int countDownFlag) {
        this.countDownFlag = countDownFlag;
    }

    public String getImgLocationSD() {
        return imgLocationSD;
    }

    public void setImgLocationSD(String imgLocationSD) {
        this.imgLocationSD = imgLocationSD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(long activityItemId) {
        this.activityItemId = activityItemId;
    }


}

