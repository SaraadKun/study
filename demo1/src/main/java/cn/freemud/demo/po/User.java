package cn.freemud.demo.po;

import com.alibaba.fastjson.JSON;

/**
 * Created by chenwenshun on 2018/9/27.
 */

public class User {
    private Long id;

    private String username;

    Integer age;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
