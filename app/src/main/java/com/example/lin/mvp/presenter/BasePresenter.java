package com.example.lin.mvp.presenter;

import com.example.lin.mvp.view.IMvpView;

/**
 * Created by lin on 2018/1/10.
 */

public class BasePresenter<V extends IMvpView> implements Presenter<V> {

    protected V mvpView;
    @Override
    public void attachView(V view) {
        mvpView=view;
    }

    @Override
    public void detachView(V view) {
        mvpView=view;
    }

    @Override
    public String getName() {
        return mvpView.getClass().getSimpleName();
    }


}
