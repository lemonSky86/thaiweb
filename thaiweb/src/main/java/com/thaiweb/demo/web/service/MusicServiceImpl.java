package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.MusicInfo;
import com.thaiweb.demo.serv.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/2116:05
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicRepository musicRepository;

    public MusicInfo uploadMusic(MusicInfo musicInfo){
        if(musicInfo != null)
        {
            musicRepository.save(musicInfo);
        }
        return null;
    }

    @Override
    public MusicInfo findLatestMusicInfo() {
        return musicRepository.findFirstByOrderByDateDesc();
    }

    @Override
    public List<MusicInfo> findMusicInfoByUserId(Integer userId) {
        return musicRepository.findMusicInfoByToUser_Id(userId);
    }

    @Override
    public List<MusicInfo> findTopFiveMusicInfoByDate() {
        return musicRepository.findTop5ByDateNotNull();
    }
}
