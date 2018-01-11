package com.example.lin.mvp.model;

import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;


/**
 * Created by lin on 2018/1/10.
 */

public class LoginTasksRepository implements LoginTaskDataSource {
    @Override
    public void saveLoginResponse(LoginResponse loginResponse) {

    }

    @Override
    public void login(LoginReq loginReq, NetTasksCallback callback) {
        //开启网络请求
        /**
         * 网络请求，这边暂时省略
         */

        //成功后，回调到presenter层中
        LoginResponse response = new LoginResponse();
        response.setResultInfo(loginReq.getName() + "====" + loginReq.getPassWord() + "====登录成功");
        response.setResutlCode("0");
        callback.onSuccess(response);
    }
}
