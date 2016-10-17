package com.mevv.vhttp.vhttp.core;

import rx.Subscriber;

/**
 * Created by VV on 2016/10/17.
 */

public class ProgressSubscriber<T> extends Subscriber<T> {

    private VCallback<T> mVCallback;

    public ProgressSubscriber(VCallback<T> vCallback) {
        this.mVCallback = vCallback;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {
        if (mVCallback != null)
            mVCallback.onSuccess(t);
    }
}
