package com.example.demo.libraries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WangEditor 文件上传返回信息
 */
public class WangEditorFileResponseHelper {

    public static String success(List<String> imagePathList) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("data", imagePathList);
        return JsonHelper.toJson(responseMap);
    }

    public static String fail() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("errno", 400);
        return JsonHelper.toJson(responseMap);
    }

}
