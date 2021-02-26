package com.example.mvpsample.base;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpsample.R;
import com.example.mvpsample.utils.ClassUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;

    protected Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //显示界面布局
        setContentView(getLayoutId() == 0 ? R.layout.activity_base : getLayoutId());

        unBinder = ButterKnife.bind(this);

        mPresenter = ClassUtils.getT(this, 0);

        if (mPresenter != null) {
            mPresenter.mContext = this;
        }

        setStatusBar();

        initPresenter();
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isUseEventBus())
            EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isUseEventBus())
            EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {

        if (unBinder != null) {
            unBinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }

        this.finish();

        super.onDestroy();
    }

    //是否注册EventBus
    private boolean isUseEventBus() {
        return false;
    }

    //设置状态栏
    private void setStatusBar() {

    }

    //布局文件获取
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    private void initPresenter() {
        if (mPresenter != null) {
            mPresenter.setV(this);
        }
    }

}
