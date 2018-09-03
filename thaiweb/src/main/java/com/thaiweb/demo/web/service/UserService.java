package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.UserInfo;

public interface UserService {

    /**
      * @Description 增加人员
      * @Param
      * @Author oneTi
      * @Date 15:45 2018/8/6
      * @Return
      **/
    UserInfo addUser(UserInfo user);

    /**
      * @Description //更新人员
      * @Param
      * @Author oneTi
      * @Date 15:49 2018/8/6
      * @Return
      **/
    UserInfo updateUser(UserInfo user);

    /**
      * @Description //根据名称删除用户
      * @Param
      * @Author oneTi
      * @Date 15:05 2018/8/7
      * @Return
      **/
    void deleteUserByName(String userName);

    /**
      * @Description //根据姓名查找用户
      * @Param
      * @Author oneTi
      * @Date 17:29 2018/8/7
      * @Return
      **/
    UserInfo findUserInfoByUserName(String userName);

    /**
      * @Description //根据用户名和密码来查找用户
      * @Param
      * @Author oneTi
      * @Date 14:43 2018/8/10
      * @Return
      **/
    UserInfo findUserInfoByUserNameAndPassword(String userName, String password);
}
