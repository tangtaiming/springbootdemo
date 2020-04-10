package com.example.demo.exception;

import com.example.demo.http.ClientErrorCode;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public class ErpClientException extends RuntimeException {

    public ErpClientException(ClientErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
