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
    @CrossOrigin
    public String login(@RequestParam("email") String email,@RequestParam("password") String password){
        //
        return "{name:1,state:2}";
    }

    @RequestMapping("/user/getMsg")
    public String getMsg(@Param("id") Integer id){
        TMsg tMsg = tMsgService.findById(id);
        String json = JSON.toJSONString(tMsg);
        return json;
    }
}
