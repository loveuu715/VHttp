package com.mevv.vhttp.vhttp.core.api;

import com.mevv.vhttp.util.NetworkUtil;
import com.mevv.vhttp.util.TipUtil;
import com.mevv.vhttp.vhttp.core.VCallback;

import retrofit2.Call;
import rx.Observable;

/**
 * Created by VV on 2016/10/14.
 */

public class Api {

    private static final String TAG = "Api";

    public static <T> void getObject(Observable observable, final Object tag, final boolean isShowProgress, final VCallback<T> vCallback) {
        if (!NetworkUtil.isNetworkEnable()) {
            TipUtil.showToast("无网络可用.");
            return;
        }
        ApiScheduler.applySchedulersForObject(observable, tag, isShowProgress, vCallback);
    }

    public static void getString(Call<String> call, final Object tag, final boolean isShowProgress, final VCallback<String> vCallback) {
        if (!NetworkUtil.isNetworkEnable()) {
            TipUtil.showToast("无网络可用.");
            return;
        }
        ApiScheduler.applySchedulersForString(call, tag, isShowProgress, vCallback);
    }

}
