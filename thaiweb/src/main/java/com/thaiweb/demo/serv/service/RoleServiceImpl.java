package com.thaiweb.demo.serv.service;

import com.thaiweb.demo.serv.domain.RoleInfo;
import com.thaiweb.demo.serv.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/9/129:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleInfo save(RoleInfo roleInfo) {
        return roleRepository.save(roleInfo);
    }
}
