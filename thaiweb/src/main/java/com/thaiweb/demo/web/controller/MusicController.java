package com.thaiweb.demo.web.controller;

import com.thaiweb.demo.web.domain.MusicInfo;
import com.thaiweb.demo.web.domain.UserInfo;
import com.thaiweb.demo.web.service.MusicService;
import com.thaiweb.demo.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/2115:58
 */
@Controller
public class MusicController extends BaseController {

    @Value("${upload.music.path}")
    private String uploadMusicPath;
    @Autowired
    MusicService musicService;
    @Autowired
    UserService userService;

    /**
     * @Description //TODO
     * @Param [multipartFile]
     * @Author oneTi
     * @Date 9:17 2018/9/11
     * @Return java.lang.String
     **/
    @RequestMapping("/music/upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        if (multipartFile != null)
        {
            MusicInfo musicInfo = new MusicInfo();
            //文件名
            String fileName = multipartFile.getOriginalFilename();
            musicInfo.setName(fileName);
            musicInfo.setDate(new Date());
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
            musicInfo.setToUser(userInfo);
            musicService.uploadMusic(musicInfo);
            //保存文件
            multipartFile.transferTo(new File(fileName));
        }
        return null;
    }

    @RequestMapping("/music/showfive")
    @ResponseBody
    public List<MusicInfo> showTopFive(){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated())
        {
            UserInfo user = userService.findUserInfoByUserName(currentUser.getPrincipal().toString());
            List<MusicInfo> musicList = musicService.findMusicInfoByUserId(user.getId());
            return musicList;
        }
        return null;
    }
}
