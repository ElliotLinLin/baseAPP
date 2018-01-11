package com.example.lin.mvp.ui.base;

import android.os.Bundle;

/**
 * Created by lin on 2018/1/10.
 */
//页面挑战
public interface IActivityCallBack {

    //需要打开的class，传递的数据
    void startActivity(Class<?> openClass, Bundle bundle);

    //期待返回
    void openActivityForResult(Class<?> openClass, int requestCode, Bundle bundle);

    //返回到上个page
    void  setResultOK(Bundle bundle);
}
