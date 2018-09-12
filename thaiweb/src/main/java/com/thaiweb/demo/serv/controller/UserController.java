package com.thaiweb.demo.serv.controller;

import com.thaiweb.demo.web.controller.BaseController;
import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.serv.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author oneTi
 * @Description: TODO
 * @date 2018/8/613:36
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request)
    {
        return "welcome";
    }

    /**
     * @Description //登陆
     * @Param [userName, password]
     * @Author oneTi
     * @Date 9:54 2018/8/10
     * @Return java.lang.String
     **/
    @RequestMapping("/user/login")
    public String login(String userName, String password)
    {

//        shiro改造
        //用户信息收集
        UsernamePasswordToken userToken = new UsernamePasswordToken(userName, password);
        //获取当前正在执行的用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            System.out.println("====login===>>>-->>>验证开始");
            currentUser.login(userToken);
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
            return "usercontent";
        }else{
            return null;
        }
//        return "usercontent";
    }

    @RequestMapping("/user/query/all")
    public String showAll(Pageable pageable){
        request.setAttribute("UserInfos", userService.findAll(pageable));
        return null;
    }

    /**
     * @Description //添加用户
     * @Param [user]
     * @Author oneTi
     * @Date 9:15 2018/8/8
     * @Return java.lang.String
     **/
    @RequestMapping("/user/add")
    public String addUser(UserInfo user)
    {
        userService.addUser(user);
        return "redirect:/welcome"; //redirect :重定向，否者跳转的地址将成为127.0.0.1:8080/user/add
    }

    /**
     * @Description //按姓名删除用户
     * @Param [name]
     * @Author oneTi
     * @Date 9:16 2018/8/8
     * @Return java.lang.String
     **/
    @RequestMapping("/user/delete/{name}")
    public String deleteUser(@PathVariable("name") String name)
    {
        userService.deleteUserByName(name);
        return "welcome";
    }

    /**
     * @Description //按姓名查找用户
     * @Param [name]
     * @Author oneTi
     * @Date 9:17 2018/8/8
     * @Return java.lang.Boolean
     **/
    @RequestMapping("/user/find/")
    @ResponseBody
    public Boolean isExistUser(String userName)
    {
        if(userService.findUserInfoByUserName(userName) != null)
        {
            return false;
        }
        return true;
    }

    /**
     * @Description //根据用户名和密码检查用户是否存在
     * @Param [userName, password]
     * @Author oneTi
     * @Date 15:21 2018/8/10
     * @Return java.lang.Boolean
     **/
    @RequestMapping("/user/check")
    @ResponseBody
    public Boolean checkUserByNameAndPassword(String userName, String password)
    {
        if(userService.findUserInfoByUserNameAndPassword(userName, password) != null)
        {
            return true;
        }
        return false;
    }

    @RequestMapping("/user/status")
    @ResponseBody
    public UserInfo checkUserStatus()
    {
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println("====currentUser.isAuthenticated()===>>>" + currentUser.isAuthenticated());
        if (currentUser.isAuthenticated())
        {
            return userService.findUserInfoByUserName(currentUser.getPrincipal().toString());
        }
        return null;
    }

    /**
      * @Description //登出
      * @Param
      * @Author oneTi
      * @Date 9:54 2018/9/3
      * @Return
      **/
    @RequestMapping("/user/login/out")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser != null && currentUser.isAuthenticated())
        {
            currentUser.logout();
            return "redirect:/welcome";
        }
        return null;
    }
}
