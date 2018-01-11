package com.example.lin.mvp.view;

import com.example.lin.mvp.bean.LoginResponse;

/**
 * Created by lin on 2018/1/10.
 */

public interface IMvpView {


        void onError(String errorMsg, String code);

        void onSuccess(LoginResponse loginResponse);

        void showLoading();

        void hideLoading();

}
