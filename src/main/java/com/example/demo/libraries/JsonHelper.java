package com.example.demo.libraries;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @auther ttm
 * @date 2017/8/25
 */
public class JsonHelper {

    public static String toJson(Object object) {
        String result = "";
        if (null == object) {
            return result;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            result = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object fromJson(String requestStr, Class clazz) {
        if (StringUtils.isEmpty(requestStr)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Object object = null;
        try {
            object = objectMapper.readValue(requestStr, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Object fromJson(String requestStr, Class collectionClazz, Class<?>... elementClazzes) {
        if (StringUtils.isEmpty(requestStr)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Object object = null;
        try {
            JavaType javaType = objectMapper.getTypeFactory().
                    constructParametricType(collectionClazz, elementClazzes);

            object = objectMapper.readValue(requestStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

}
