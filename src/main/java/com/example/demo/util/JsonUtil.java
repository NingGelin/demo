package com.example.demo.util;

import com.google.gson.Gson;

public class JsonUtil
{
    /**
     * Object序列化为Json字符串
     *
     * @param object
     * @return
     */
    public static String obj2String(Object object)
    {
        return new Gson().toJson(object);
    }

    /**
     * Json字符串转换为Object
     *
     * @param str
     * @param clazz
     * @return
     */
    public static <T> T string2obj(String str, Class<T> clazz)
    {
        return new Gson().fromJson(str, clazz);
    }

}
