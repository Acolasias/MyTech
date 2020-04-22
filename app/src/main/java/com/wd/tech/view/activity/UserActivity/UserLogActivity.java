package com.wd.tech.view.activity.UserActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.wd.tech.MyApp;
import com.wd.tech.MyUrls;
import com.wd.tech.R;
import com.wd.tech.arc.LivenessActivity;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.model.bean.LogBean;
import com.wd.tech.model.bean.RegisterBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.RsaCoder;
import com.wd.tech.view.activity.MainActivity;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLogActivity extends BaseActivity<TechPresenter> {

    @BindView(R.id.log_phone)
    EditText logPhone;
    @BindView(R.id.log_pwd)
    EditText logPwd;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.log_bt)
    Button logBt;
    @BindView(R.id.log_weixin)
    ImageView logWeixin;
    @BindView(R.id.log_face)
    ImageView logFace;
    String PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //隐藏标题
        getSupportActionBar().hide();
    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_user_log;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof LogBean && TextUtils.equals("0000", ((LogBean) o).getStatus())) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(this, MainActivity.class);
            finish();
        } else {
            LogBean logBean = (LogBean) o;
            Toast.makeText(this, "登录失败: "+logBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @OnClick({R.id.login_register, R.id.log_bt, R.id.log_weixin, R.id.log_face})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register:
                Intent intent = new Intent(this,UserRegActivity.class);
                startActivity(intent);
                break;
            case R.id.log_bt:
                String phone = logPhone.getText().toString();
                String pwd = logPwd.getText().toString();
                if (TextUtils.equals("", phone) && TextUtils.equals("", pwd)) {
                    Toast.makeText(this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s = null;
                try {
                    s = RsaCoder.encryptByPublicKey(pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean matches = Pattern.matches(PHONE, phone);
                if (matches){
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("phone", phone);
                    hashMap.put("pwd",s);
                    mPresenter.postDoParams(MyUrls.LOG_URL, LogBean.class, hashMap);
                }else {
                    Toast.makeText(this, "手机号不符合规范", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.log_weixin:
                if (!MyApp.sIWXAPI.isWXAppInstalled()) {
                    Toast.makeText(this, "没有安装微信", Toast.LENGTH_SHORT).show();
                    return;
                }

                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                MyApp.sIWXAPI.sendReq(req);
                break;
            case R.id.log_face:
                LivenessActivity.flag = 1;
                startActivity(new Intent(this, LivenessActivity.class));
                break;
        }
    }
}
