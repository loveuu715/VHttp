package com.mevv.vhttp.vhttp.core;

import com.mevv.vhttp.vhttp.response.Resp;

import rx.functions.Func1;

/**
 * Created by VV on 2016/10/14.
 */

public class HttpResultSubscriber<T> implements Func1<Resp<T>, T> {

    @Override
    public T call(Resp<T> tResp) {
        if (!tResp.isStatus())
            throw new ApiException(tResp.getErrcode(),tResp.getInfo());
        return tResp.getData();
    }
}
