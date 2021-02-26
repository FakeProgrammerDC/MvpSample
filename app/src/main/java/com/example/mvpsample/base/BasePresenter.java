package com.example.mvpsample.base;

import android.content.Context;

public abstract class BasePresenter<T> {

    public Context mContext;
    public T mView;

    public void setV(T v) {
        this.mView = v;
        init();
    }

    public abstract void init();

    public abstract void subscribe();

    public abstract void unSubscribe();

}
