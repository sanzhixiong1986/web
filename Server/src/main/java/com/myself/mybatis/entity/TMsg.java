package com.myself.mybatis.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * 实体类
 */
@Data
public class TMsg implements Serializable {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private Integer id;
    private String userName;
    private String passWord;
}
