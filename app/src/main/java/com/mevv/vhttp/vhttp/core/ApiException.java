package com.mevv.vhttp.vhttp.core;

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
        String message = "";
        switch (code) {
            case -100:
                TipUtil.showToast(errorMsg);
                break;
            default:
                message = "未知错误";
                break;
        }
        return message;
    }
}
