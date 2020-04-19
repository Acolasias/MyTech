package com.wd.tech;

import android.app.Application;
import android.content.Context;

/**
 * Time:2020/4/19 0019下午 8:35202004
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class MyApp extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
