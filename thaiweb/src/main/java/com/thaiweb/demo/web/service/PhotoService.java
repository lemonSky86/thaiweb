package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.serv.domain.UserInfo;

import java.util.List;

public interface PhotoService {

    PhotoInfo uploadPhoto(PhotoInfo photo);

    List<PhotoInfo> findPhotoByUserInfo(UserInfo userInfo);


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
