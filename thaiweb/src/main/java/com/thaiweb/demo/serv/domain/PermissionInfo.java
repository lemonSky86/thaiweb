package com.thaiweb.demo.serv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description: 权限实体
 * @Author oneTi
 * @Date 2018/9/1110:09
 */
@Entity
public class PermissionInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;//权限名
    private String permissionValue;//权限值
    private Integer type;//权限类型 1按钮，2菜单，3目录
    private Integer status;//状态 0正常，1禁止
    private Date createTime;//创建时间

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }
}
