package com.mevv.vhttp.vhttp.core;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by VV on 2016/10/14.
 *
 */

public class ParamsHelper {
    public static final String TAG = "ParamsHelper";
    public static Gson sGson ;
    private static LinkedHashMap<String, String> sMap ;
    static{
        sGson = new Gson();
    }

    public static Map getBasicMap(){
        sMap = new LinkedHashMap<>();
        //TODO 添加自己的必须参数
        sMap.put("token", "5d01321caea90573a25cd075ba440d6a");
        sMap.put("secret_key", "rA21VeE8347bScsuIDNq");
        sMap.put("adcode", "440300");
        sMap.put("user_type", "1");
        return sMap;
    }
}
