package com.thaiweb.demo.serv.listener;

import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.serv.util.UserThreadLocalUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @Description: 用户session监听器
 * HttpSessionAttributeListener 是对Session Atribute的监听，需要实现以下三个接口方法
 * @Author oneTi
 * @Date 2018/8/917:04
 */
@WebListener
public class UserSessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * @Description //往session添加对象时触发
     * @Param [var1]
     * @Author oneTi
     * @Date 17:13 2018/8/9
     * @Return void
     **/
    public void attributeAdded(HttpSessionBindingEvent var1)
    {
        System.out.println("UserSessionAttributeListener--->>>attributeAdded()");
        if ("userInfo".equals(var1.getName()))
        {
            UserThreadLocalUtil.setUser((UserInfo) var1.getValue());
        }
    }

    /**
     * @Description //修改、删除session时触发
     * @Param [var1]
     * @Author oneTi
     * @Date 17:14 2018/8/9
     * @Return void
     **/
    public void attributeRemoved(HttpSessionBindingEvent var1)
    {
        System.out.println("UserSessionAttributeListener--->>>attributeRemoved()");
        if ("userInfo".equals(var1.getName()))
        {
            UserThreadLocalUtil.removeUser();
        }
    }

    /**
     * @Description //重置session时触发
     * @Param [var1]
     * @Author oneTi
     * @Date 17:15 2018/8/9
     * @Return void
     **/
    public void attributeReplaced(HttpSessionBindingEvent var1)
    {
        System.out.println("UserSessionAttributeListener--->>>attributeReplaced()");
        if ("userInfo".equals(var1.getName()))
        {
            UserThreadLocalUtil.setUser((UserInfo) var1.getValue());
        }
    }
}
