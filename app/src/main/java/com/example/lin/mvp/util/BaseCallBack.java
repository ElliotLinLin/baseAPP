package com.example.lin.mvp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lin on 2018/1/15.
 */

public abstract class BaseCallBack extends StringCallback{
    protected ProgressDialog progressDialog = null;
    public Context mContext;
    public BaseCallBack(Context context) {
        mContext = context;
    }
    @Override
    public void onError(Call call, Exception e, int i) {
        Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
    }
    protected void closeDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void showProgressDiag() {
        // 进度
        progressDialog = new ProgressDialog(mContext);

        // 是否允许关闭
        progressDialog.setCancelable(true);

        // 点击允许点击外部关闭对话框？
        progressDialog.setCanceledOnTouchOutside(false);

        // 显示对话框
        progressDialog.show();
        progressDialog.setContentView(CreateLoadingView.createView(mContext, ""));

    }


}
