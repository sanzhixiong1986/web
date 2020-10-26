package com.myself.mybatis.mapper;

import com.myself.mybatis.entity.TMsg;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by MySelf on 2019/4/9.
 */
@Mapper
public interface TMsgMapper {
     /**
      * 根据id来查询
      * @param id
      * @return
      */
     public TMsg findById(Integer id);

     /**
      * 根据用户名字去查找存在有对象
      * @param userName
      * @return
      */
     public TMsg findByName(String userName);
}