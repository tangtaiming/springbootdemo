package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.orm.dto.TomtopcomLanguageResponse;
import com.example.demo.service.TomtopProductStatusService;
import com.example.demo.service.TomtopcomLanguageService;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@RestController
public class TomtopApiController {

    @Autowired
    private TomtopProductStatusService tomtopProductStatusService;

    @Autowired
    private TomtopcomLanguageService tomtopcomLanguageService;

    /**
     *
     * 商品状态
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

    /**
     * 站点语言
     * @param website
     * @return
     */
    @RequestMapping(value = "/base/website/languages", method = RequestMethod.GET)
    public List<TomtopcomLanguageResponse> tomtopProductLanguage(@RequestParam(value = "website") Integer website) {
        return tomtopcomLanguageService.tomtopLanuageListByWebsite(website);
    }

    /**
     * 标签
     * @return
     */
    @RequestMapping(value = "/product/getLabels", method = RequestMethod.GET)
    public List<Map<String, Object>> tomtopProductLabelsApi() {
        return new ArrayList<>();
    }

}
