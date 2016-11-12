package com.example.a20141022.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity<V extends MainActivity, T extends MainPresenter<V>,M extends SencondPresenter<V>> extends AppCompatActivity implements View.OnClickListener {

    //多个presenter，实现不同的业务逻辑，分别处理，最终决定页面显示风格
    protected MainPresenter mPresenter; //Presenter对象
    protected SencondPresenter mSencondPresenter;

    TextView hello ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = createMainPresenter();
        mSencondPresenter = createSencondPresenter();
    }

    private void initView(){
        hello = (TextView) findViewById(R.id.hello);
        hello.setOnClickListener(this);
    }

    public void setHello(String string){
        hello.setText(string);
    }
    protected  MainPresenter createMainPresenter(){
        MainPresenter basePresenter = new MainPresenter(this);
        basePresenter.attachView(this);
        return basePresenter;
    }

    protected SencondPresenter createSencondPresenter(){
        SencondPresenter sencondPresenter = new SencondPresenter(this);
        sencondPresenter.attachView(this);
        return sencondPresenter;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter.isViewAttached()){
            mPresenter.detachView();

        }
        if(mSencondPresenter.isViewAttached()){
            mSencondPresenter.detachView();
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.hello:
                if(mPresenter.isViewAttached()){
                    //设置到view，由presenter决定怎么绘制界面，由view调用
                    mPresenter.setView();
                }
        }
    }
}
