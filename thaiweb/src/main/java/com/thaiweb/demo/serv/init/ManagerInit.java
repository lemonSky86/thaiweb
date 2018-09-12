package com.thaiweb.demo.serv.init;

import com.thaiweb.demo.serv.domain.ManagerInfo;
import com.thaiweb.demo.serv.repository.ManagerRepository;
import com.thaiweb.demo.serv.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: 用户初始化
 * @Author oneTi
 * @Date 2018/9/1110:54
 */
@Component
@Order(3)
public class ManagerInit implements ApplicationRunner {

    @Autowired
    ManagerService managerService;
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String dataInit;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (dataInit.equals("create")){
            ManagerInfo managerInfo = new ManagerInfo();
            managerInfo.setUsername("admin");
            managerInfo.setPassword("admin");
            managerInfo.setLocked(0);
            managerInfo.setRole(null);
            managerInfo.setCreateTime(new Date());

            managerService.save(managerInfo);
        }
    }
}
