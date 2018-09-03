package com.thaiweb.demo.web.config;

import com.thaiweb.demo.serv.util.UserRealmUtil;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author oneTi
 * @Date 2018/8/3017:13
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm(){
        UserRealmUtil userRealmUtil = new UserRealmUtil();
        userRealmUtil.setCachingEnabled(true);
        return userRealmUtil;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }
}