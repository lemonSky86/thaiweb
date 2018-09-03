package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.web.domain.UserInfo;

import java.util.List;

public interface PhotoService {

    /**
     * @Description //保存图片
     * @Param [photo]
     * @Author oneTi
     * @Date 16:53 2018/8/14
     * @Return PhotoInfo
     **/
    PhotoInfo uploadPhoto(PhotoInfo photo);

    /**
     * @Description //根据用户查找图像
     * @Param [userInfo]
     * @Author oneTi
     * @Date 13:54 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
    List<PhotoInfo> findPhotoByUserInfo(UserInfo userInfo);

    /**
     * @Description //查找用户最新图像
     * @Param [userInfo]
     * @Author oneTi
     * @Date 14:04 2018/8/20
     * @Return java.util.List<PhotoInfo>
     **/
//    List<PhotoInfo> findLatestPhotoByUserInfo(UserInfo userInfo);

    List<PhotoInfo> findLatestPhotoByUserId(Integer userId);

    /**
     * @Description //保存图片
     * @Param [photoInfo]
     * @Author oneTi
     * @Date 16:15 2018/8/20
     * @Return void
     **/
    void save(PhotoInfo photoInfo);
}
