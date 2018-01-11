package com.example.lin.mvp.ui.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lin.mvp.presenter.BasePresenter;

/**
 * Created by lin on 2018/1/10.
 */

public class BaseActivity extends Activity implements ICommonCheck,ICreateInit,IPresenterLayerFunc{

    private PresentationLayerFuncHelper presentationLayerFuncHelper;
    public BasePresenter presenter;

    private LinearLayout back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presentationLayerFuncHelper = new PresentationLayerFuncHelper(this);
        initView();
        initData();
        initHeader();
        initListener();
    }

    //start ICommonCheck，后面不会改动了，这里就固定好
    @Override
    public boolean isEmptyString(String src) {
        if (src == null) {
            return true;
        }
        if (src.length() <= 0) {
            return true;
        }
        return false;
    }
    @Override
    public boolean netWorkIsConn(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
    //end ICommonCheck

    //start ICreateInit具体实现在真正的activity李在去完成
    @Override
    public void initView() {

    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
    //end ICreateInit
//start IPresenterLayerFunc
    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showSoftKeyboard(View focusView) {

    }

    @Override
    public void hideSoftKeyboard() {

    }
//end IPresenterLayerFunc


}