package com.myself.mybatis.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * 实体类
 */
@Data
public class TMsg implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
}
