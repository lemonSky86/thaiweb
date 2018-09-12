package com.thaiweb.demo.web.controller;

import com.thaiweb.demo.web.domain.TopicInfo;
import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.web.service.TopicService;
import com.thaiweb.demo.serv.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date 2018/8/3115:12
 */
@Controller
public class TopicController extends BaseController {

    @Autowired
    TopicService topicService;
    @Autowired
    UserService userService;

    /**
     * @Description //保存用户发布的topic
     * @Param [multipartFile]
     * @Author oneTi
     * @Date 15:31 2018/8/31
     * @Return java.lang.String
     **/
    @RequestMapping("/topic/save")
    @ResponseBody
    public String topicPublish(@RequestParam("topicFile")MultipartFile multipartFile) throws IOException{
        if(multipartFile != null){
            TopicInfo topicInfo = new TopicInfo();
            //文件名
            String fileName = multipartFile.getOriginalFilename();
            topicInfo.setFileName(fileName);
            String title = request.getParameter("topicTitle");
            topicInfo.setTitle(title);
            String description = request.getParameter("topicDescription");
            topicInfo.setDescription(description);
            topicInfo.setDate(new Date());
            //当前用户
            Subject currentUser = SecurityUtils.getSubject();
            //shiro验证用户有效性
            if (currentUser.isAuthenticated()) {
                UserInfo userInfo = userService.findUserInfoByUserName(currentUser.getPrincipal().toString());
                topicInfo.setUser(userInfo);
            }
            topicService.save(topicInfo);//保存topic
            multipartFile.transferTo(new File(fileName));//保存文件
        }
        return "redirect:/usercontent";
    }

    /**
      * @Description //向用户展示TopTen
      * @Param
      * @Author oneTi
      * @Date 15:40 2018/8/31
      * @Return
      **/
    @RequestMapping("/topic/showten")
    @ResponseBody
    public List<TopicInfo> showTopTenByAgreeDesc(){
        return topicService.findTopTenByAgreeDesc();
    }
}
