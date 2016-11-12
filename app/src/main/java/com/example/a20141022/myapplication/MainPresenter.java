package com.example.a20141022.myapplication;

import android.content.Context;

/**
 * Created by zhangqiang on 2016/11/12.
 */

public class MainPresenter<T extends MainActivity> extends BasePresenter<T> {


    public MainPresenter(Context context) {
        super(context);
    }

    //具体业务实现方式
    public String makeBusinessLogic(){
        return "BusinessLogic";
    }
    //设置到view，由presenter决定怎么绘制界面，由view调用
    public void setView(){
        getView().setHello(makeBusinessLogic());
    }
}
