package com.ylf.cache.entity;

import java.io.Serializable;

/**
 * @Author: ylf
 * @Time: 2019/7/25 下午6:51
 * @Description:
 */
public class AcountReq implements Serializable{
    private String id;

    private String name;

    private String pass;

    private String sex;

    private Integer age;

    private String orderByType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }
}
