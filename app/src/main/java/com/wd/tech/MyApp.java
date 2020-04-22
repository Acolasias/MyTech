package com.wd.tech;

import android.app.Application;
import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Time:2020/4/19 0019下午 8:35202004
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class MyApp extends Application {
    public static Context mContext;
    public static IWXAPI sIWXAPI;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        registToWX();
    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        sIWXAPI = WXAPIFactory.createWXAPI(this, "wx4c96b6b8da494224", false);
        // 将该app注册到微信
        sIWXAPI.registerApp("wx4c96b6b8da494224");
    }
}
