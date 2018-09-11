package com.thaiweb.demo.web.repository;

import com.thaiweb.demo.web.domain.MusicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<MusicInfo, Long> {


    List<MusicInfo> findMusicInfoByToUser_Id(Integer userId);

    MusicInfo findFirstByOrderByDateDesc();

    List<MusicInfo> findTop5ByDateNotNull();
}
