package com.thaiweb.demo.web.repository;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.web.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoInfo, Long> {

    /**
      * @Description //查找所有图片
      * @Param
      * @Author oneTi
      * @Date 13:44 2018/8/20
      * @Return
      **/
    @Override
    List<PhotoInfo> findAll();

    /**
     * @Description //按时间查找图片
     * @Param [date]
     * @Author oneTi
     * @Date 13:47 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
    List<PhotoInfo> findPhotoInfoByDate(Date date);

    /**
     * @Description //根据用户查找图片
     * @Param [userInfo]
     * @Author oneTi
     * @Date 13:51 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
    List<PhotoInfo> findPhotoInfoByToUser(UserInfo userInfo);

    /**
     * @Description //根据用户名查找最新图片
     * @Param []
     * @Author oneTi
     * @Date 14:00 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
//    List<PhotoInfo> findPhotoInfoByToUserAOrderByDateDesc(UserInfo userInfo);

    /**
     * @Description //根据用户Id查找图片
     * @Param [userId]
     * @Author oneTi
     * @Date 14:32 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
    List<PhotoInfo> findPhotoInfoByToUser_Id(Integer userId);
}
