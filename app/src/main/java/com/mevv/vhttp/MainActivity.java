package com.mevv.vhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mevv.vhttp.vhttp.core.ApiFactory;
import com.mevv.vhttp.vhttp.core.ApiHelper;
import com.mevv.vhttp.vhttp.core.Api;
import com.mevv.vhttp.vhttp.core.VCallback;
import com.mevv.vhttp.vhttp.entity.BannerEntity;
import com.mevv.vhttp.util.LogUtil;
import com.mevv.vhttp.util.TipUtil;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> params = ApiHelper.getBasicMap();
        LogUtil.i(params.toString());
        Api.applySchedulersForObject(ApiFactory.INSTANCE.getObjectApi().getBannerList(params), this, new VCallback<List<BannerEntity>>() {
            @Override
            public void onSuccess(List<BannerEntity> result) {
                TipUtil.showLongToast(result.get(0).getImg());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onEmpty() {

            }

            @Override
            public void noNetworkError(String msg) {

            }
        });
//        Api.applySchedulersForString(ApiFactory.INSTANCE.getStringApi().getBannerForString(params), new VCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                TipUtil.showLongToast(result);
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//
//            @Override
//            public void onEmpty() {
//
//            }
//
//            @Override
//            public void noNetworkError(String msg) {
//
//            }
//        });
    }
}
