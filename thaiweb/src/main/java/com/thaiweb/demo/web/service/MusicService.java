package com.thaiweb.demo.web.service;


import com.thaiweb.demo.web.domain.MusicInfo;

import java.util.List;

public interface MusicService {

    MusicInfo uploadMusic(MusicInfo musicInfo);

    MusicInfo findLatestMusicInfo();

    List<MusicInfo> findMusicInfoByUserId(Integer userId);

    List<MusicInfo> findTopFiveMusicInfoByDate();
}
