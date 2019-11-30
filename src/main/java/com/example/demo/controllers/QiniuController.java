package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("qiniu")
public class QiniuController {

    /**
     * 基本上传
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String execute() {
        return "/qiniu/index";
    }

    @RequestMapping(value = "service", method = RequestMethod.GET)
    public String service() {

        return "/qiniu/service";
    }

}
