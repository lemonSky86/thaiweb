package com.thaiweb.demo.serv.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 管理员
 * @Author oneTi
 * @Date 2018/9/315:05
 */
@Controller
public class ManagerController extends BaseController {

    @RequestMapping("/manager/welcome")
    public String welcome(){
        return "/serv/login";
    }

    @RequestMapping("/manager/login")
    public String login(String username, String password){
        //封装在身份验证尝试期间提交的用户名和密码，即前端提交的用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            System.out.println("====login===>>>-->>>验证开始");
            currentUser.login(token);
            System.out.println("====login===>>>-->>>验证成功");
        }catch(UnknownAccountException uae){
            System.out.println("====login===>>>-->>>未知账户");
        }catch (IncorrectCredentialsException ice){
            System.out.println("====login===>>>-->>>密码错误");
        }catch (LockedAccountException lae){
            System.out.println("====login===>>>-->>>账户已锁定");
        }catch (ExcessiveAttemptsException eae){
            System.out.println("====login===>>>-->>>尝试次数过多");
        }catch (AuthenticationException ae){
            System.out.println("====login===>>>-->>>账户或密码错误");
        }
        //如果验证成功
        if (currentUser.isAuthenticated())
        {
            return "/serv/index";
        }else{
            return null;
        }
    }
}
