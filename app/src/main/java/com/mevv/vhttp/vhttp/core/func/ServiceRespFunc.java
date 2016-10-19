package com.mevv.vhttp.vhttp.core.func;

import com.mevv.vhttp.vhttp.core.exception.ApiException;
import com.mevv.vhttp.vhttp.response.Resp;

import rx.functions.Func1;

/**
 * Created by VV on 2016/10/14.
 * 校验服务器返回数据的状态
 */

public class ServiceRespFunc<T> implements Func1<Resp<T>, T> {

    @Override
    public T call(Resp<T> tResp) {
        if (!tResp.isStatus())
            throw new ApiException(tResp.getErrcode(),tResp.getInfo());
        return tResp.getData();
    }
}
