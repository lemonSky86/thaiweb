package com.thaiweb.demo.serv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author jmaes.feng
 * @Description: TODO
 * @date 2018/8/613:25
 */
@Entity
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
