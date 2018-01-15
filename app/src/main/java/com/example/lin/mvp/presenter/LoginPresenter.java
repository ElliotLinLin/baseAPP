package com.example.lin.mvp.presenter;


import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;
import com.example.lin.mvp.model.LoginTaskDataSource;
import com.example.lin.mvp.model.LoginTasksRepository;
import com.example.lin.mvp.view.IUserLoginView;

/**
 * Created by lin on 2018/1/10.
 */

public class LoginPresenter extends BasePresenter<IUserLoginView> {

    private LoginTasksRepository loginTaskDataSource;

    private IUserLoginView iUserLoginView;

    public LoginPresenter(/*IUserLoginView iUserLoginView*/) {
        loginTaskDataSource = new LoginTasksRepository();
   //     this.iUserLoginView=iUserLoginView;
    }

    public void login(LoginReq loginReq) {
        mvpView.showLoading();
        loginTaskDataSource.login(loginReq, new LoginTaskDataSource.NetTasksCallback() {

            @Override
            public void onSuccess(LoginResponse loginResponse) {
                mvpView.hideLoading();
                mvpView.onSuccess(loginResponse);
            }

            @Override
            public void onFailure(String errorMsg) {

            }
        });
    }


}
