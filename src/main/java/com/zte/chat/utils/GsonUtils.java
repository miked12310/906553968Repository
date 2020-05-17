package com.zte.chat.utils;

import com.google.gson.Gson;
/**
 * @author 刘煦�?
 * Date:2019-06-25 16:03
 * Description:<描述>
 */

public class GsonUtils {

    private static Gson GsonUtilsGson = new Gson();

    /**
     * @fun 根据不同类型进行json到实体间的转�?
     * @param jsonString json字符�?
     * @param cls �?要转化的类型
     * @param <T> �?要转化的类型
     * @return 返回实体对象
     */
    public static  <T> T josnToModule(String jsonString, Class<T> cls) {
        T list ;
        list=GsonUtilsGson.fromJson(jsonString,cls);
        return list;
    }

    /**
     * @fun 根据不同类型进行实体到json间的转化
     * @param cls �?要转化的类型
     * @param <T> �?要转化的类型
     * @return 返回Json字符�?
     */
    public static  <T> String  ModuleTojosn(T cls) {
        return  GsonUtilsGson.toJson(cls);
    }
}
