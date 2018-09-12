package com.thaiweb.demo.serv.service;

import com.thaiweb.demo.serv.domain.ManagerInfo;

public interface ManagerService {

    ManagerInfo save(ManagerInfo managerInfo);

    ManagerInfo findManagerInfoByUsername(String username);
}
