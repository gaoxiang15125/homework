package com.j2ee.homework.homework.controller;

import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.entity.SecurityEntity;
import com.j2ee.homework.homework.service.ClientUserService;
import com.j2ee.homework.homework.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 16:13
 * @email: 630268696@qq.com
 **/
//@Component
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    ClientUserService clientUserService;

    @GetMapping("/login")
    public boolean login(String clientId,String password){
        return loginService.isPasswordRight(clientId,password);
    }

    @GetMapping("/login/UserRegister")
    public boolean UserRegister(String email,String userName,String gender,String telphone,String password){
        ClientUserEntity clientUserEntity =new ClientUserEntity();
        SecurityEntity securityEntity = new SecurityEntity();
        //配置用户基本信息
        clientUserEntity.setEmail(email);
        clientUserEntity.setUserName(userName);
        clientUserEntity.setGender(gender);
        clientUserEntity.setTelphone(telphone);

    }
}
