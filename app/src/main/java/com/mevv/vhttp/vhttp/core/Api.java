package com.mevv.vhttp.vhttp.core;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by VV on 2016/10/14.
 */

public class Api {
    private static final String TAG = "Api";

    public static <T> Subscription applySchedulersForObject(Observable mObservable, final Object tag, final VCallback<T> vCallback) {
        //TODO 判断是否有网络
        Subscription subscription = mObservable
                .map(new HttpResultSubscriber<T>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(T t) {
                        vCallback.onSuccess(t);
                    }
                });
        if (tag != null)
            ApiTaskStack.getInstance().enqueue(subscription, tag);
        return subscription;
    }

    public static void applySchedulersForString(Call<String> call, final VCallback<String> vCallback){
        //TODO 判断是否有网络
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                vCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }

}
