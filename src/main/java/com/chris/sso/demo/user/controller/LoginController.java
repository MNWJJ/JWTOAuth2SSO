package com.chris.sso.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }

    @RequestMapping("/loginn")
    @ResponseBody
    public String loginn() {
        return "hello";
    }

}
