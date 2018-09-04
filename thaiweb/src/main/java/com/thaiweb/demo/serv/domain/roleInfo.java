package com.thaiweb.demo.serv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description: 角色实体
 * @Author oneTi
 * @Date 2018/9/417:13
 */
@Entity
public class roleInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer roleNumber;//编号
    private String name;//名称
    private String permission;//权限名
}
