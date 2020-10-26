package com.myself.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        //-1 用户明不存在，-2密码不正确
        //创建json对象
        JSONObject jsonObject = new JSONObject();
        //1.收到对应的数据
        String userName = email;
        String passWord = password;
        //2.判断传过来的数据是否正确
        if(userName == null || userName == ""){
            jsonObject.put("code",-1);
            return JSON.toJSONString(jsonObject);
        }
        TMsg tMsg = tMsgService.findByName(userName);
        if(null != tMsg){
            if(!tMsg.getPassWord().equals(passWord)){
                jsonObject.put("code",-2);
                return JSON.toJSONString(jsonObject);
            }
        }else{
            jsonObject.put("code",-2);
            return JSON.toJSONString(jsonObject);
        }
        jsonObject.put("code",1);
        return JSON.toJSONString(jsonObject);
    }

    @RequestMapping("/user/getMsg")
    public String getMsg(@Param("id") Integer id){
        TMsg tMsg = tMsgService.findById(id);
        String json = JSON.toJSONString(tMsg);
        return json;
    }
}
