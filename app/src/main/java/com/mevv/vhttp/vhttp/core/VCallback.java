package com.mevv.vhttp.vhttp.core;

/**
 * Created by VV on 2016/10/14.
 */

public interface VCallback<T> {
    void onSuccess(T result);

    void onFailure(Throwable e);
}
