package com.example.mvpsample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.mvpsample.R;
import com.example.mvpsample.base.BaseActivity;
import com.example.mvpsample.ui.demo.DemoActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.demo)
    Button button;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        findViewById(R.id.demo).setOnClickListener(__ -> DemoActivity.startDemoActivity(this));
    }
}