package com.thaiweb.demo.serv.service;

import com.thaiweb.demo.serv.domain.UserInfo;
import com.thaiweb.demo.serv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @Description //TODO
     * @Param []
     * @Author oneTi
     * @Date 15:08 2018/9/12
     * @Return java.util.List<com.thaiweb.demo.serv.domain.UserInfo>
     **/
    @Override
    public List<UserInfo> findAllIdNotNull() {
        return userRepository.findAllByIdNotNull();
    }

    public Page<UserInfo> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
