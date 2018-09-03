package com.thaiweb.demo.web.util;

import com.thaiweb.demo.web.domain.UserInfo;

/**
 * @author oneTi
 * @Description: 保存用户登陆状态
 * @date 2018/8/916:03
 */
public class UserThreadLocalUtil {
    //ThreadLocal, 是线程局部变量，即只能在本线程能被访问，不能在多线程之间共享。

    private static final ThreadLocal<UserInfo> LOCAL_USER = new ThreadLocal<UserInfo>();

    /**
     * @Description //设置当前线程局部变量的值
     * @Param [user]
     * @Author oneTi
     * @Date 16:23 2018/8/9
     * @Return void
     **/
    public static void setUser(UserInfo user)
    {
        LOCAL_USER.set(user);
    }

    /**
     * @Description //获取当前线程局部变量的值
     * @Param [user]
     * @Author oneTi
     * @Date 16:26 2018/8/9
     * @Return void
     **/
    public static UserInfo getUser()
    {
        return LOCAL_USER.get();
    }

    /**
     * @Description //删除线程局部变量的当前值
     * @Param [user]
     * @Author oneTi
     * @Date 16:28 2018/8/9
     * @Return void
     **/
    public static void removeUser()
    {
        LOCAL_USER.remove();
    }
}
