package com.example.demo.libraries;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class FileResponseHelper {

    public static String error(int code, String msg) {
        Map<String, Object> mesMap = new HashMap<>();
        Map<String, Object> response = new HashMap<>();
        mesMap.put("message", msg);
        response.put("uploaded", code);
        response.put("error", mesMap);

        return JsonHelper.toJson(response);
    }

    public static String success(int code, String fileName, String url, String msg) {
        Map<String, Object> response = new HashMap<>();
        if (StringUtils.isEmpty(msg)) {
            Map<String, Object> msgMap = new HashMap<>();
            msgMap.put("message", msg);
            response.put("error", msgMap);
            return JsonHelper.toJson(response);
        }

        response.put("uploaded", code);
        response.put("fileName", fileName);
        response.put("url", url);
        return JsonHelper.toJson(response);
    }

}
