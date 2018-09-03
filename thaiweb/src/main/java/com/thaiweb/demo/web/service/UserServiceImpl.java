package com.thaiweb.demo.web.service;

import com.thaiweb.demo.web.domain.UserInfo;
import com.thaiweb.demo.serv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jmaes.feng
 * @Description: TODO
 * @date 2018/8/614:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserInfo addUser(UserInfo user){
        return userRepository.save(user);
    }

    public UserInfo updateUser(UserInfo user){
        return userRepository.save(user);
    }

    public void deleteUserByName(String userName){
        if(userName != null)
        {
            userRepository.deleteByUserName(userName);
        }
    }

    public UserInfo findUserInfoByUserName(String userName){
        if(userName != null)
        {
            return userRepository.getUserInfoByUserName(userName);
        }
        return null;
    }

    public UserInfo findUserInfoByUserNameAndPassword(String userName, String password)
    {
        return userRepository.getUserInfoByUserNameAndPassword(userName, password);
    }
}
