package com.thaiweb.demo.serv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 后台菜单跳转控制
 * @Author oneTi
 * @Date 2018/9/1214:05
 */
@Controller
public class ServMenuController {

    @RequestMapping("/manager/message")
    public String welcomePage(){
        return "serv/welcome";
    }

    @RequestMapping("/manager/role")
    public String rolePage(){
        return "serv/rolemanage";
    }

    @RequestMapping("/manager/user")
    public String userPage(){
        return "serv/usermanage";
    }
}
