package com.mevv.vhttp.vhttp.core;

import com.mevv.vhttp.vhttp.entity.BannerEntity;
import com.mevv.vhttp.vhttp.response.Resp;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by VV on 2016/10/14.
 * 返回结果为指定对象
 */

public interface ObjectApi {

    @GET("Index/getCarouselImg")
    Observable<Resp<List<BannerEntity>>> getBannerList(@QueryMap Map<String, String> params);
}
