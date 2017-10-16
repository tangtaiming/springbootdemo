package com.example.demo.controllers;

import com.example.demo.orm.TomtopProductStatus;
import com.example.demo.service.TomtopProductStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@RestController
public class TomtopApiController {

    @Autowired
    private TomtopProductStatusService tomtopProductStatusService;

    /**
     * 请求商品状态
     * @param type
     * @return
     */
    @RequestMapping(value = "/base/parameter/v1/where", method = RequestMethod.GET)
    public Map<String, Object> tomtopProductStatusApi(@RequestParam(value = "type") String type) {
        Map<String, Object> resultMap = null;
        if (type.equals("PRODUCT_STATUS")) {
            resultMap = tomtopProductStatusService.tomtopProductFormatList();
        }
        return resultMap;
    }

}
