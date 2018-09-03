package com.thaiweb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 由于引入了shiro框架来控制访问权限，所以暂时先屏蔽掉了过滤器，后期如果有需要可以再开启
    //2018/08/31
//    @Bean
//    public FilterRegistrationBean userSessionFilter()
//    {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        UserSessionFilter userSessionFilter = new UserSessionFilter();
//        filterRegistrationBean.setFilter(userSessionFilter);
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
//        filterRegistrationBean.addUrlPatterns("/user/status/"); //指定需要过滤的URL
//        return filterRegistrationBean;
//    }

    /**
     * @Description //初始化User, Role和 Permission对象的基本配置(原生Realm)
     * @Param []
     * @Author oneTi
     * @Date 15:32 2018/8/30
     * @Return org.apache.shiro.realm.Realm
     **/
//    @Bean
//    public Realm realm() {
//        TextConfigurationRealm realm = new TextConfigurationRealm();
////        realm.setUserDefinitions("joe.coder=password,user\n" +
////                "jill.coder=password,admin");
////
////        realm.setRoleDefinitions("admin=read,write\n" +
////                "user=read");
//        realm.setCachingEnabled(true);
//        return realm;
//    }

//    创建自定义的UserRealmUtil之后在这里配置，shiro会提示配置失败
    /**
     * @Description //shiro过滤器
     * @Param []
     * @Author oneTi
     * @Date 17:03 2018/8/29
     * @Return org.apache.shiro.spring.web.config.ShiroFilterChainDefinition
     **/
//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition()
//    {
//        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
//        //anon: 允许匿名访问; authc认证通过才可以访问
//        defaultShiroFilterChainDefinition.addPathDefinition("/**", "anon");
//        return defaultShiroFilterChainDefinition;
//    }

    /**
     * @Description //自定义Realm
     * @Param []
     * @Author oneTi
     * @Date 16:47 2018/8/30
     * @Return UserRealmUtil
     **/
//    @Bean
//    public UserRealmUtil userRealmUtil(){
////        TextConfigurationRealm realm = new TextConfigurationRealm();
////        realm.setCachingEnabled(true);
//        UserRealmUtil userRealmUtil = new UserRealmUtil();
//        userRealmUtil.setCachingEnabled(true);
//        return userRealmUtil;
//    }

    /**
     * @Description //shiro的中心管理组件
     * @Param []
     * @Author oneTi
     * @Date 16:54 2018/8/30
     * @Return org.apache.shiro.mgt.SecurityManager
     **/
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        defaultWebSecurityManager.setRealm(userRealmUtil());//设置自定义Realm对象
//        return defaultWebSecurityManager;
//    }


}
