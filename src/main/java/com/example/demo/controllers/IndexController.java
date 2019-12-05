package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/26
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/v1/index", method = RequestMethod.GET)
    public String index(Map<String, Object> view) {
        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultIndex() {
        return "index";
    }

}
