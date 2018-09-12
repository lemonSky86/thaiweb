package com.thaiweb.demo.serv.util;

import com.thaiweb.demo.serv.domain.ManagerInfo;
import com.thaiweb.demo.serv.service.ManagerService;
import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.serv.repository.UserRepository;
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
    @Autowired
    private ManagerService managerService;

    /**
     * @Description //用户认证
     * @Param [authenticationToken]
     * @Author oneTi
     * @Date 14:16 2018/8/30
     * @Return org.apache.shiro.authc.AuthenticationInfo
     **/
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken){
        String userName = authenticationToken.getPrincipal().toString();//用户账号
        if (userRepository.getUserInfoByUserName(userName) != null)
        {
            UserInfo user = userRepository.getUserInfoByUserName(userName);
            //接收账户主体及其凭据，这里就会给出验证结果
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        }
        else if(managerService.findManagerInfoByUsername(userName) != null){
            ManagerInfo manager = managerService.findManagerInfoByUsername(userName);
            return new SimpleAuthenticationInfo(manager.getUsername(), manager.getPassword(), getName());
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
