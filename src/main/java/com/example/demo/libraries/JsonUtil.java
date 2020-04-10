package com.example.demo.libraries;

import com.example.demo.exception.JsonParseException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.io.StringWriter;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public class JsonUtil {

    private static JsonFactory jsonFactory = new JsonFactory();
    private static ObjectMapper defaultObjectMapper = createObjectMapper();

    /**
     * 创建一个自定义的JSON ObjectMapper
     */
    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        objectMapper.registerModule(module);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }

    /**
     * 将对象转换为JSON字符串
     */
    public static <T> String transferToJson(T value) throws JsonParseException {
        StringWriter sw = new StringWriter();
        JsonGenerator gen = null;
        try {
            gen = jsonFactory.createGenerator(sw);
            defaultObjectMapper.writeValue(gen, value);
            return sw.toString();
        } catch (IOException e) {
            throw new JsonParseException();
        } finally {
            if (gen != null) {
                try {
                    gen.close();
                } catch (IOException e) {
                }

            }
        }
    }

    /**
     * 将JSON字符串转换为指定对象
     */
    public static <T> T transferToObj(String jsonString, Class<T> valueType) throws JsonParseException{
        T value = null;
        if(jsonString == null || jsonString.length() == 0) {return value;}
        try {
            value = defaultObjectMapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonParseException();
        }
        return value;
    }

    /**
     * 将JSON字符串转换为指定对象
     */
    public static <T> T transferToObj(String jsonString, TypeReference typeReference) {
        if(jsonString == null || jsonString.length() == 0 || typeReference == null) {
            throw new JsonParseException();
        }

        try {
            return defaultObjectMapper.readValue(jsonString, typeReference);
        } catch (IOException e){
            throw new JsonParseException();
        }

    }

}
