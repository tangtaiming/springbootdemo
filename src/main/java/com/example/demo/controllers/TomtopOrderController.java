package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.number.money.MonetaryAmountFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.orm.TomtopOrderList;
import com.example.demo.service.TomtopOrderListService;

/**
 * @auther ttm
 * @date 2017/11/23
 */
//@Controller
public class TomtopOrderController {

//    @Autowired
//    private TomtopOrderListService tomtopOrderListService;
//
//    @RequestMapping(value = "/checkout/{itemId}/getOrder", method = RequestMethod.GET)
//    @ResponseBody
//    public TomtopOrderList orderSingle(@PathVariable String itemId) {
//        return tomtopOrderListService.tomtopOrderListOne(itemId);
//    }
//
//    @RequestMapping(value = "/order/save", method = RequestMethod.GET)
//    public ModelAndView orderSave() {
//    	ModelAndView view = new ModelAndView();
//    	view.setViewName("/order/add-order");
//        return view;
//    }
//
//    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
//    public String orderSave(@RequestParam(value = "order") String order) {
//        tomtopOrderListService.tomtopOrderListSave(order);
//        return "/order/add-order";
//    }

}
