package com.thaiweb.demo.serv.init;

import com.thaiweb.demo.serv.domain.RoleInfo;
import com.thaiweb.demo.serv.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: 角色初始化
 * @Author oneTi
 * @Date 2018/9/1110:20
 */
@Component
@Order(2)
public class RoleInit implements ApplicationRunner {

    @Autowired
    RoleService roleService;
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String dataInit;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(dataInit.equals("create")){
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setName("管理员");
            roleInfo.setRoleNumber(1);
            roleInfo.setCreateTime(new Date());

            roleService.save(roleInfo);
        }
    }
}
