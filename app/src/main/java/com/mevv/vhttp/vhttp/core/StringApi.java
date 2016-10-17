package com.mevv.vhttp.vhttp.core;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by VV on 2016/10/14.
 * 返回结果为String
 */

public interface StringApi {

    @GET("Index/getCarouselImg")
    Call<String> getBannerForString(@QueryMap Map<String, String> params);
}
