package com.apple.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆操作
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(){
        return "login";
    }
}
