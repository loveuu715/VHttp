package com.mevv.vhttp.vhttp.core.exception;

import com.mevv.vhttp.util.TipUtil;

/**
 * Created by VV on 2016/10/14.
 */

public class ApiException extends RuntimeException {


    public ApiException(int resultCode, String errorMsg) {
        this(getApiExceptionMessage(resultCode, errorMsg));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @param errorMsg
     * @return
     */
    private static String getApiExceptionMessage(int code, String errorMsg) {
        //TODO ErrorEngine 待处理
        String message = code+"==>"+errorMsg;
        TipUtil.showToast(message);
        return message;
    }
}
