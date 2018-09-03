package com.thaiweb.demo.web.repository;

import com.thaiweb.demo.web.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
  * @Description //
 * JPA 提供了许多接口，非常方便；不用自己再去写底层封装了~
 * 按照命名规则来定义方法，即可以操作数据库了，如查询：findBy + 实体属性名, get + 实体类名 + By + 实体属性名,...
 * 还可以使用@Query注解，直接语句查询..
 * 只提这两点~
  **/
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    
    /**
      * @Description //按名称查找所有用户
      * @Param 
      * @Author oneTi
      * @Date 15:35 2018/8/6
      * @Return 
      **/
    List<UserInfo> findByUserName(String userName);

    /**
      * @Description //按姓名查找单个用户
      * @Param
      * @Author oneTi
      * @Date 14:22 2018/8/7
      * @Return
      **/
    UserInfo getUserInfoByUserName(String userName);

    /**
      * @Description //根据用户名和密码来查找用户
      * @Param
      * @Author oneTi
      * @Date 14:53 2018/8/10
      * @Return
      **/
    UserInfo getUserInfoByUserNameAndPassword(String userName, String password);

    /**
      * @Description //按姓名查找单个用户 使用Query注解方式
      * @Param
      * @Author oneTi
      * @Date 14:47 2018/8/7
      * @Return
      **/
//    @Query("select u from UserInfo u where u.userName = ?1")
//    UserInfo findUserInfoByName(String userName);

    /**
      * @Description //按姓名查找单个用户 使用原生查询方式
      * @Param
      * @Author oneTi
      * @Date 14:54 2018/8/7
      * @Return
      **/
//    @Query(value = "SELECT * FROM USER_INFO WHERE USER_NAME = ?1", nativeQuery = true)
//    UserInfo findUserInfoByName(String userName);

    /**
      * @Description //根据名称删除用户
      * @Param
      * @Author oneTi
      * @Date 15:00 2018/8/7
      * @Return
      **/
    @Transactional
    void deleteByUserName(String userName);
}
