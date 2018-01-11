package com.example.lin.mvp.model;

import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;

/**
 * Created by lin on 2018/1/10.
 */
//模型层进行数据请求
public interface LoginTaskDataSource {

    void saveLoginResponse(LoginResponse loginResponse);

    void login(LoginReq loginReq, NetTasksCallback callback);

    /**
     * 网络请求回调
     */
    interface NetTasksCallback {

        void onSuccess(LoginResponse loginResponse);

        void onFailure(String errorMsg);
    }
}
