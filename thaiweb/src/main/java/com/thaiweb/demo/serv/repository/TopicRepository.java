package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.web.domain.TopicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicInfo, Long> {

    List<TopicInfo> findTop10ByOrderByAgreeDesc();
}
