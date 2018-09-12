package com.thaiweb.demo.web.controller;

import com.thaiweb.demo.web.domain.PhotoInfo;
import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.web.service.PhotoService;
import com.thaiweb.demo.serv.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/1416:32
 */
@Controller
public class PhotoController extends BaseController {

    @Value("${upload.photo.path}")
    private String uploadPicturePath;
    @javax.annotation.Resource
    private ResourceLoader resourceLoader;
    @Autowired
    PhotoService photoService;
    @Autowired
    UserService userService;

    /**
     * @Description //上传
     * @Param [multipartFile]
     * @Author oneTi
     * @Date 15:10 2018/8/17
     * @Return java.lang.String
     **/
    @RequestMapping("/photo/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        try{
            System.out.println("MultipartFile-->>>" + multipartFile.getOriginalFilename());
            //multipartFile.getOriginalFilename() 获取文件原始名称
            //new File(multipartFile.getOriginalFilename()) 根据获取到的原始文件名创建目标文件
            //multipartFile.transferTo() 将收到的文件传输到目标文件中
            if(multipartFile != null)
            {
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.setName(multipartFile.getOriginalFilename());
                UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                photoInfo.setToUser(userInfo);//这里的UserThreadLocalUtil.getUser()为空
                photoInfo.setDate(new Date());
//                photoService.save(photoInfo);

                multipartFile.transferTo(new File(multipartFile.getOriginalFilename()));
                return "true";
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "false";
    }

    /**
     * @Description //显示
     * @Param [fileName]
     * @Author oneTi
     * @Date 15:11 2018/8/17
     * @Return org.springframework.http.ResponseEntity<org.springframework.core.io.Resource>
     **/
    @RequestMapping("/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> show(@PathVariable String fileName){
        try
        {
            //resourceLoader.getResource("file:" + uploadPicturePath + fileName) 返回指定路径的资源句柄，这里返回的就是URL [file:D:/springboot/upload/test.png]
            //ResponseEntity.ok(T) 返回指定内容主体
            System.out.println("show-->>>" + resourceLoader.getResource("file:" + uploadPicturePath + fileName));
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPicturePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
      * @Description //返回当前用户最新图片
      * @Param
      * @Author oneTi
      * @Date 14:16 2018/8/20
      * @Return
      **/
    @RequestMapping("/photo/latest")
    @ResponseBody
    public List<PhotoInfo> showLatestPhoto()
    {
        Subject currentUser = SecurityUtils.getSubject();//shiro获取当前用户
        UserInfo userInfo = userService.findUserInfoByUserName(currentUser.getPrincipal().toString());
        if(currentUser.isAuthenticated()){
            List<PhotoInfo> photoList = photoService.findLatestPhotoByUserId(userInfo.getId());
            return  photoList;
        }
        return null;
    }
}
