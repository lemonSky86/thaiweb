package com.thaiweb.demo.serv.init;

import com.thaiweb.demo.serv.domain.PermissionInfo;
import com.thaiweb.demo.serv.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: 初始化权限
 * @Author oneTi
 * @Date 2018/9/1110:54
 */
@Component
@Order(1)
public class PermissionInit implements ApplicationRunner {

    @Autowired
    PermissionRepository permissionRepository;
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String dataInit;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //初始化数据库时才初始化数据
        if (dataInit.equals("create")) {
            PermissionInfo permissionInfo = new PermissionInfo();
            permissionInfo.setName("登陆");
            permissionInfo.setPermissionValue("1");
            permissionInfo.setType(1);
            permissionInfo.setStatus(0);
            permissionInfo.setCreateTime(new Date());
            permissionRepository.save(permissionInfo);
        }
    }
}
