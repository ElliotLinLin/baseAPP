package com.example.lin.mvp.ui.mainui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lin.mvp.R;
import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;
import com.example.lin.mvp.presenter.LoginPresenter;
import com.example.lin.mvp.ui.base.BaseActivity;
import com.example.lin.mvp.util.AppManager;
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
    private Button buttonRegister;
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
        button= (Button) findViewById(R.id.btq);
        buttonRegister=(Button) findViewById(R.id.btregister);
     }

    @Override
    public void initListener() {
        super.initListener();
        button.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
     }

    @Override
    public void initData() {
        super.initData();
      //  mLoginPresenter=new LoginPresenter(this);
        mLoginPresenter=new LoginPresenter();
        mLoginPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btq:
                LoginReq loginReq = new LoginReq();
                loginReq.setName(userName.getText().toString());
                loginReq.setPassWord(passWord.getText().toString());
                mLoginPresenter.login(loginReq);
                break;
            case R.id.btregister:
                startToRegister();
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
        AppManager.getAppManager().startUI(new Intent(this,Main2Activity.class),this);
    }

    @Override
    public void showLoading() {
        showToast("正在登陆。。");
    }

    @Override
    public void hideLoading() {
        showToast("登陆完成");
    }

    @Override
    public void clearEditContent() {
        userName.setText("");
        passWord.setText("");
    }

    @Override
    public void startToRegister() {
        AppManager.getAppManager().startStandardUI(new Intent(this,RegisterActivity.class),this);
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.detachView(this);
        super.onDestroy();
    }
}
