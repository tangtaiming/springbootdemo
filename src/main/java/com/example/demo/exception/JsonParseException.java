package com.example.demo.exception;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public class JsonParseException extends RuntimeException {

    public JsonParseException() {
        super("Json parse error");
    }

}
