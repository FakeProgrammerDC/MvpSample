package com.example.mvpsample.ui.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvpsample.R;
import com.example.mvpsample.base.BaseActivity;

import butterknife.BindView;

public class DemoActivity extends BaseActivity<DemoPresenter> implements DemoContract.View {

    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showView() {
        mTextView.setText("加载成功");
    }

    @Override
    public void showErrorView() {
        mTextView.setText("加载异常");
    }

    public static void startDemoActivity(Context context) {
        context.startActivity(new Intent(context, DemoActivity.class));
    }


}