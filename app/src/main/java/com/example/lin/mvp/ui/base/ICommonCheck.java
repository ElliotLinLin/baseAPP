package com.example.lin.mvp.ui.base;

import android.content.Context;

/**
 * Created by lin on 2018/1/10.
 */
//app page 上面常用的检查和判断s
public interface ICommonCheck {

    boolean isEmptyString(String src);
    boolean netWorkIsConn(Context context);
}
