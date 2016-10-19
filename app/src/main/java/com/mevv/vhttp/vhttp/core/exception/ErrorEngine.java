package com.mevv.vhttp.vhttp.core.exception;

import com.mevv.vhttp.vhttp.core.api.ApiTaskStack;

/**
 * Created by VV on 2016/10/19.
 */

public class ErrorEngine {
    private static ErrorEngine sErrorEngine;

    private ErrorEngine() {
    }

    public static ErrorEngine getInstance() {
        if (sErrorEngine == null) {
            synchronized (ApiTaskStack.class) {
                if (sErrorEngine == null)
                    sErrorEngine = new ErrorEngine();
            }
        }
        return sErrorEngine;
    }

    public void processError(int code, String msg){

    }


}
