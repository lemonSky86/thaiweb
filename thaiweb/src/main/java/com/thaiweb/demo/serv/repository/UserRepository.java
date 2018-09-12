package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.serv.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
      * @Description //根据名称删除用户
      * @Param
      * @Author oneTi
      * @Date 15:00 2018/8/7
      * @Return
      **/
    @Transactional
    void deleteByUserName(String userName);

    /**
      * @Description //查找所有用户
      * @Param
      * @Author oneTi
      * @Date 15:05 2018/9/12
      * @Return
      **/
    List<UserInfo> findAllByIdNotNull();

    /**
      * @Description //分页查找所有数据
      * @Param
      * @Author oneTi
      * @Date 15:16 2018/9/12
      * @Return
      **/
    @Override
    Page<UserInfo> findAll(Pageable pageable);
}
