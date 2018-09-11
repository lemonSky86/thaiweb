package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.TopicInfo;
import com.thaiweb.demo.web.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/3115:05
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<TopicInfo> findTopTenByAgreeDesc(){
        return topicRepository.findTop10ByOrderByAgreeDesc();
    }

    public void save(TopicInfo topicInfo){
        if(topicInfo != null){
            topicRepository.save(topicInfo);
        }
    }
}
