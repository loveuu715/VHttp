package com.mevv.vhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mevv.vhttp.util.ActManager;
import com.mevv.vhttp.util.LogUtil;
import com.mevv.vhttp.util.TipUtil;
import com.mevv.vhttp.vhttp.core.api.Api;
import com.mevv.vhttp.vhttp.core.api.ApiFactory;
import com.mevv.vhttp.vhttp.core.api.ApiTaskStack;
import com.mevv.vhttp.vhttp.core.ParamsHelper;
import com.mevv.vhttp.vhttp.core.VCallback;
import com.mevv.vhttp.vhttp.entity.BannerEntity;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActManager.getInstances().add(this);
        setContentView(R.layout.activity_main);
        Map<String, String> params = ParamsHelper.getBasicMap();
        LogUtil.i(params.toString());

        Api.getObject(ApiFactory.INSTANCE.getObjectApi().getBannerList(params), this, true, new VCallback<List<BannerEntity>>() {
            @Override
            public void onSuccess(List<BannerEntity> result) {
                TipUtil.showLongToast(result.get(0).getImg());
            }

            @Override
            public void onFailure(Throwable e) {
                LogUtil.i("hate", e.getMessage());
            }
        });


      /*  Api.getString(ApiFactory.INSTANCE.getStringApi().getStringInfoGet("Index/getCarouselImg", params), this, true, new VCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TipUtil.showLongToast(result);
            }

            @Override
            public void onFailure(Throwable e) {
                LogUtil.i("hate", e.getMessage());
            }
        });*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ApiTaskStack.getInstance().cancelAll();
        ActManager.getInstances().finishAll();
    }
}
