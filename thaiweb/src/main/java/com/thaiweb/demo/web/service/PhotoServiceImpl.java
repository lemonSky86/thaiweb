package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.web.domain.UserInfo;
import com.thaiweb.demo.web.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/1416:40
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public PhotoInfo uploadPhoto(PhotoInfo photoInfo){
        return photoRepository.save(photoInfo);
    }

    public List<PhotoInfo> findPhotoByUserInfo(UserInfo userInfo)
    {
        return photoRepository.findPhotoInfoByToUser(userInfo);
    }

    public List<PhotoInfo> findLatestPhotoByUserId(Integer userId)
    {
        return photoRepository.findPhotoInfoByToUser_Id(userId);
    }

    public void save(PhotoInfo photoInfo)
    {
        if (photoInfo != null)
        {
            photoRepository.save(photoInfo);
        }
    }
}
