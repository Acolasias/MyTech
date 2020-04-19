package com.wd.tech.base;

import java.lang.ref.WeakReference;

/**
 * Time:2020/4/19 0019下午 8:35202004
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public abstract class BasePresenter <V>{
    //弱引用解决内存泄露
    private WeakReference<V> weakReference;

    public void attach(V view){
        weakReference = new WeakReference<>(view);
    }
    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    //获取view
    public V getView(){
        return weakReference.get();
    }
    //获取model对象

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
