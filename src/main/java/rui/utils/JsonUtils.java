package rui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转字符串
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2String(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转对象
     * @param str
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T string2Obj(String str, Class<T> tClass) {
        if (StringUtils.isNullOrEmpty(str) || tClass == null) {
            return null;
        }
        try {
            return tClass.equals(String.class) ? (T) str : objectMapper.readValue(str, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
