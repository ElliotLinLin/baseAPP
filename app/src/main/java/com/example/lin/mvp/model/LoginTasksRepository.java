package com.example.lin.mvp.model;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.lin.mvp.bean.LoginReq;
import com.example.lin.mvp.bean.LoginResponse;
import com.example.lin.mvp.constant.AppConstants;
import com.example.lin.mvp.constant.HttpConstants;
import com.example.lin.mvp.util.BaseCallBack;
import com.example.lin.mvp.util.DesUtil;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by lin on 2018/1/10.
 */

public class LoginTasksRepository implements LoginTaskDataSource {
    @Override
    public void saveLoginResponse(LoginResponse loginResponse) {

    }

    @Override
    public void login(LoginReq loginReq, final NetTasksCallback callback) {
        //开启网络请求
        /**
         * 网络请求，这边暂时省略
         */
      /*  try{
            Thread.sleep(1000);
        }catch (Exception e){

        }*/
        //成功后，回调到presenter层中
        OkHttpUtils.get().addParams("FileName","app.Config").url(HttpConstants.login).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                LoginResponse loginResponse=null;
                if(TextUtils.isEmpty(s)){
                   /* loginResponse=new LoginResponse();
                    loginResponse.setResultInfo("aa");
                    loginResponse.setResutlCode("1");
                    callback.onSuccess(loginResponse);*/
                    return;
                }
                try {
                    String result= DesUtil.DecryptDoNet(s, AppConstants.DESKEY);
                     loginResponse=new Gson().fromJson(result,LoginResponse.class);
                    callback.onSuccess(loginResponse);
                } catch (Exception e) {
                    return;
                }
            }
        });
      /*  LoginResponse response = new LoginResponse();
        response.setResultInfo(loginReq.getName() + "====" + loginReq.getPassWord() + "====登录成功");
        response.setResutlCode("0");
        callback.onSuccess(response);*/
    }
}
