package com.thaiweb.demo.serv.service;

import com.thaiweb.demo.serv.domain.ManagerInfo;
import com.thaiweb.demo.serv.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/9/129:33
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public ManagerInfo save(ManagerInfo managerInfo) {
        return managerRepository.save(managerInfo);
    }

    @Override
    public ManagerInfo findManagerInfoByUsername(String username) {
        if (username != null){
            return managerRepository.findManagerInfoByUsername(username);
        }
        return null;
    }


}
