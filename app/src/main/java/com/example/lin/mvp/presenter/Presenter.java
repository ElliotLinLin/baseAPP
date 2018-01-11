package com.example.lin.mvp.presenter;

/**
 * Created by lin on 2018/1/10.
 */

public interface Presenter<V> {
    void attachView(V view);

    void detachView(V view);

    String getName();
}
