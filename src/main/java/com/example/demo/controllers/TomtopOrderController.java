package com.example.demo.controllers;

import com.example.demo.libraries.JsonHelper;
import com.example.demo.orm.TomtopOrderList;
import com.example.demo.service.TomtopOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/23
 */
@Controller
public class TomtopOrderController {

    @Autowired
    private TomtopOrderListService tomtopOrderListService;

    @RequestMapping(value = "/checkout/{itemId}/getOrder", method = RequestMethod.GET)
    @ResponseBody
    public TomtopOrderList orderSingle(@PathVariable String itemId) {
        return tomtopOrderListService.tomtopOrderListOne(itemId);
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.GET)
    public String orderSave() {
        return "/order/add-order";
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
    public String orderSave(@RequestParam(value = "order") String order) {
        tomtopOrderListService.tomtopOrderListSave(order);
        return "/order/add-order";
    }

}
