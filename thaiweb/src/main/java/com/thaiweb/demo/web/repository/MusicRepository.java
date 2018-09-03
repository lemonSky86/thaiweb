package com.thaiweb.demo.web.repository;

import com.thaiweb.demo.web.domain.MusicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<MusicInfo, Long> {

    /**
     * @Description //根据用户id查找
     * @Param [userId]
     * @Author oneTi
     * @Date 16:10 2018/8/21
     * @Return MusicInfo
     **/
    List<MusicInfo> findMusicInfoByToUser_Id(Integer userId);

    /**
     * @Description //根据时间查找最新一条数据
     * @Param []
     * @Author oneTi
     * @Date 16:14 2018/8/21
     * @Return MusicInfo
     **/
    MusicInfo findFirstByOrderByDateDesc();

    /**
     * @Description //根据时间查找Top5数据
     * @Param []
     * @Author oneTi
     * @Date 17:19 2018/8/21
     * @Return java.util.List<MusicInfo>
     **/
    List<MusicInfo> findTop5ByDateNotNull();
}
