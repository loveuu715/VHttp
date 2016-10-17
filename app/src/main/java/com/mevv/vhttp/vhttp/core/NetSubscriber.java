package com.mevv.vhttp.vhttp.core;

import com.mevv.vhttp.util.NetworkUtil;

import rx.functions.Func1;

/**
 * Created by VV on 2016/10/14.
 */

public class NetSubscriber<T> implements Func1<T,T> {

    @Override
    public T call(T t) {
        if (!NetworkUtil.isNetworkEnable())
            new ApiException(-100,"无网络可用");
        return t;
    }
}
