package com.thaiweb.demo.web.domain;

import com.thaiweb.demo.serv.domain.UserInfo;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 存放图片
 * @Author oneTi
 * @Date 2018/8/1416:20
 */
@Entity
public class PhotoInfo {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String path;
    private Date date;
    @ManyToOne
    private UserInfo toUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }
}
