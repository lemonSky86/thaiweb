package com.thaiweb.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/1016:09
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;
//    protected HttpServletResponse response;

}
