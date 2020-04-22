package com.wd.tech.view.activity.UserActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.base.BasePresenter;
import com.wd.tech.view.activity.MainActivity;

public class GuidePageActivity extends BaseActivity {
    int time = 3;

    //Handler接收数据
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                if (time > 0){
                    time--;
                    mHandler.sendEmptyMessageDelayed(1,1000);
                }else {
                    //时间倒计时结束跳转
                    Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };

    @Override
    protected void initData() {
        //创建子线程,做耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessageDelayed(1,1000);
            }
        }).start();
    }

    @Override
    protected void initView() {
        //隐藏标题
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_guide_page;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void DestroyActivity() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
