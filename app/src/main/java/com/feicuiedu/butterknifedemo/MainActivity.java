package com.feicuiedu.butterknifedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    // 绑定控件
    @BindView(R.id.tv_show) TextView textView;
    @BindView(R.id.button) Button button;
    @BindView(R.id.tv_hide)TextView tvHide;

    // 绑定资源
    @BindString(R.string.app_name) String appName;
    @BindColor(R.color.colorAccent) int color;
    @BindDimen(R.dimen.activity_horizontal_margin) float magin;

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定
        bind = ButterKnife.bind(this);

        String string = getResources().getString(R.string.app_name);
        getResources().getColor(R.color.colorAccent);

    }

    // 设置监听
    @OnClick(R.id.button)
    public void setData(){
        textView.setText("Android");
        tvHide.setTextColor(color);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 解绑
        bind.unbind();
    }
}
