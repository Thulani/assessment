package za.co.investec.thulani.util;

import com.google.gson.Gson;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class JsonUtil {
    public static <T> T readJsonString(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}