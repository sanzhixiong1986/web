## web后台服务器

第一版web阶段

客户端使用AdminLTE进行开发，后端使用springboot2.5 进行开发，使用mysql进行数据库的操作

第二版springboot

- 增加了mybatis基础操作
- 增加了mysql的基础操作

1.mybatis第一步pom增加

```xml
<dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>
```

2.分别在resources文件下增加一个mapper文件夹增加xml进行数据库操作，我创建了一个TMsgMapper.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myself.mybatis.mapper.TMsgMapper">
    <select id="findById" resultType="com.myself.mybatis.entity.TMsg">
        SELECT id,userName,passWord from game_login WHERE id = #{id}
    </select>
</mapper>
```

关键点：

1. namespace="com.myself.mybatis.mapper.TMsgMapper" 其中com.myself.mybatis.mapper.TMsgMapper这个路径下对应了一个类

   ```java
   package com.myself.mybatis.mapper;
   import com.myself.mybatis.entity.TMsg;
   import org.apache.ibatis.annotations.Mapper;
   /**
    * Created by MySelf on 2019/4/9.
    */
   @Mapper
   public interface TMsgMapper {
     		//这里的方法是对应xml下面的方法
        public TMsg findById(Integer id);
   }
   ```

2. 其中select id="findById" resultType="com.myself.mybatis.entity.TMsg, id等于mapper类方法，resultType后面对应返回值。

   

   ```java
   package com.myself.mybatis.service.impl;
   
   import com.myself.mybatis.entity.TMsg;
   import com.myself.mybatis.mapper.TMsgMapper;
   import com.myself.mybatis.service.TMsgService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;
   
   /**
    * ligit
    */
   @Service
   public class TMsgServiceImpl implements TMsgService {
       @Autowired
       private TMsgMapper tMsgMapper;
       @Override
       public TMsg findById(Integer id) {
           return tMsgMapper.findById(id);
       }
   }
   ```

   

   ```java
   package com.myself.mybatis.controller;
   
   import com.alibaba.fastjson.JSON;
   import com.myself.mybatis.entity.TMsg;
   import com.myself.mybatis.service.TMsgService;
   import org.apache.ibatis.annotations.Param;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.*;
   
   /**
    * 登陆操作
    */
   @Controller
   @RestController
   public class LoginController {
   
       @Autowired
       private TMsgService tMsgService;
       /**
        * 显示登陆界面
        * @return
        */
       @RequestMapping("/user/login")
       @ResponseBody
       public String login(){
           return "login";
       }
   
       @RequestMapping("/user/getMsg")
       public String getMsg(@Param("id") Integer id){
           TMsg tMsg = tMsgService.findById(id);
           String json = JSON.toJSONString(tMsg);
           return json;
       }
   }
   ```

   

   ```yml
   mybatis:
     mapper-locations: classpath*:mapper/*Mapper.xml
     type-aliases-package: com.myself.mybatis.entity
   ```

   

   ```yaml
   #数据库相关配置
   spring:
     datasource:
       url: jdbc:mysql://127.0.0.1:3306/gameserver?characterEncoding=utf-8&useSSL=false
       username: root
       password: sanzhixiong
       driver-class-name: com.mysql.cj.jdbc.Driver
   ```

以上都是一些关键类，和一些配置。

增加nginx配置

首先安装brew install nginx mac上安装，等安装完成使用sudo nginx 进行打开

```yaml
/usr/local/etc/nginx/nginx.conf （配置文件路径）
/usr/local/var/www （服务器默认路径）
/usr/local/Cellar/nginx/1.8.0 （安装路径）
```

我们要把html文件放入到服务器默认路径里面