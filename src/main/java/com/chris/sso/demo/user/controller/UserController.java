package com.chris.sso.demo.user.controller;




import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getCurrentUser")
    @ResponseBody
    public Object getCurrentUser(Authentication authentication) {

        return authentication;
    }



}
