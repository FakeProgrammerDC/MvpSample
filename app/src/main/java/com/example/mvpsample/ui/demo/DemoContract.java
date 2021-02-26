package com.example.mvpsample.ui.demo;

import com.example.mvpsample.base.BasePresenter;
import com.example.mvpsample.base.BaseView;

public interface DemoContract {

    interface View extends BaseView{
        void showView();

        void showErrorView();
    }

    abstract static class Presenter extends BasePresenter<View> {
        public abstract void loadData();
    }

}
