package com.thaiweb.demo.serv.service;

import com.thaiweb.demo.serv.domain.PermissionInfo;
import com.thaiweb.demo.serv.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/9/129:21
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public PermissionInfo save(PermissionInfo permissionInfo) {
        return permissionRepository.save(permissionInfo);
    }
}
