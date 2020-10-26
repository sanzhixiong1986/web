package com.myself.mybatis.service;

import com.myself.mybatis.entity.TMsg;

public interface TMsgService {
    /**
     * 通过id进行查找用户
     * @param id
     * @return
     */
    TMsg findById(Integer id);

    /**
     * 通过姓名查找对象
     * @param name
     * @return
     */
    TMsg findByName(String name);
}