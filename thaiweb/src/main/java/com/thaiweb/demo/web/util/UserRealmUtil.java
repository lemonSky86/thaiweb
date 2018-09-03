package com.thaiweb.demo.web.util;

import com.thaiweb.demo.serv.repository.UserRepository;
import com.thaiweb.demo.web.domain.UserInfo;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 自定义Realm类
 * @Author oneTi
 * @Date 2018/8/3014:07
 */
public class UserRealmUtil extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    /**
     * @Description //用户认证
     * @Param [authenticationToken]
     * @Author oneTi
     * @Date 14:16 2018/8/30
     * @Return org.apache.shiro.authc.AuthenticationInfo
     **/
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken){
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String userName = usernamePasswordToken.getUsername();
        String userName = authenticationToken.getPrincipal().toString();//用户账号
        System.out.println("====username====-1111->>>");
        UserInfo user = userRepository.getUserInfoByUserName(userName);
        if (user != null)
        {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        }
        return null;
    }

    /**
     * @Description //用户授权
     * @Param []
     * @Author oneTi
     * @Date 16:32 2018/8/30
     * @Return org.apache.shiro.authz.AuthorizationInfo
     **/
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo();
        return null;
    }
}
