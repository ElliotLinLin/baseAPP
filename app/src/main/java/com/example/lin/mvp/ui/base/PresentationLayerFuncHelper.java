package com.example.lin.mvp.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by lin on 2018/1/10.
 */

public class PresentationLayerFuncHelper implements IPresenterLayerFunc{

    private Context context;

    public PresentationLayerFuncHelper(Context context) {
        this.context = context;
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
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
}
