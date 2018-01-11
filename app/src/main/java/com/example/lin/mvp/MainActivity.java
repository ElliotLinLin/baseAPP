package com.example.lin.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;
import com.example.lin.mvp.presenter.LoginPresenter;
import com.example.lin.mvp.ui.base.BaseActivity;
import com.example.lin.mvp.view.IUserLoginView;

public class MainActivity extends BaseActivity implements View.OnClickListener,IUserLoginView{
    /**
     * 用户名
     */
    private EditText userName;
    /**
     * 密码
     */
    private EditText passWord;
    /**
     * 登录按钮
     */
    private Button button;
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    @Override
    public void initView() {
        super.initView();
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.bt);
    }

    @Override
    public void initListener() {
        super.initListener();
        button.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        mLoginPresenter=new LoginPresenter();
        mLoginPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                LoginReq loginReq = new LoginReq();
                loginReq.setName(userName.getText().toString());
                loginReq.setPassWord(passWord.getText().toString());
                mLoginPresenter.login(loginReq);
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String errorMsg, String code) {

    }

    @Override
    public void onSuccess(LoginResponse loginResponse) {
        showToast(loginResponse.getResultInfo()+loginResponse.getResutlCode());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void clearEditContent() {
    userName.setText("");
        passWord.setText("");
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.detachView(this);
        super.onDestroy();
    }
}
