package com.example.demo.exception;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther ttm
 * @date 2017/8/22
 */
@ControllerAdvice
public class MyException {

    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一异常处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handelDefaultError(HttpServletRequest request, Exception e) {
        ModelAndView pmav = new ModelAndView();
        pmav.addObject("code", 500);
        pmav.addObject("msg", e.toString());
        pmav.setViewName(DEFAULT_ERROR_VIEW);

        return pmav;
    }

}
