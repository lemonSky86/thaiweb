package com.thaiweb.demo.web.repository;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.serv.domain.UserInfo;
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

    List<PhotoInfo> findPhotoInfoByDate(Date date);

    List<PhotoInfo> findPhotoInfoByToUser(UserInfo userInfo);

    List<PhotoInfo> findPhotoInfoByToUser_Id(Integer userId);
}
