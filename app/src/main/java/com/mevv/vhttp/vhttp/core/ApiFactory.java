package com.mevv.vhttp.vhttp.core;

/**
 * Created by VV on 2016/10/14.
 */

public enum  ApiFactory {
    INSTANCE;
    private final ObjectApi mObjectApi;
    private final StringApi mStringApi;

    ApiFactory() {
        mObjectApi = RetrofitFactory.createRetrofit().create(ObjectApi.class);
        mStringApi = RetrofitFactory.createStringRetrofit().create(StringApi.class);
    }

    public ObjectApi getObjectApi() {
        return mObjectApi;
    }

    public StringApi getStringApi() {
        return mStringApi;
    }
}
