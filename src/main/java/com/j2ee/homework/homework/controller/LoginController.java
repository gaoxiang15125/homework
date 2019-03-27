package com.j2ee.homework.homework.controller;

import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.entity.SecurityEntity;
import com.j2ee.homework.homework.service.ClientUserService;
import com.j2ee.homework.homework.service.EmailService;
import com.j2ee.homework.homework.service.LoginService;
import com.j2ee.homework.homework.tools.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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
    @Autowired
    EmailService emailService;

    @GetMapping("/login")
    public boolean login(String clientId,String password){
        System.out.println("被调用");
        return loginService.isPasswordRight(clientId,password);
    }

    @GetMapping("/login/UserRegister")
    public String UserRegister(String email,String userName,String gender,String telphone,String password){
        String userUUID =UUID.randomUUID().toString();
        ClientUserEntity clientUserEntity =new ClientUserEntity();
        SecurityEntity securityEntity = new SecurityEntity();
        //配置用户基本信息
        clientUserEntity.setEmail(email);
        clientUserEntity.setUserName(userName);
        clientUserEntity.setGender(gender);
        clientUserEntity.setTelphone(telphone);
        clientUserEntity.setBalance(0);
        clientUserEntity.setLevel(0);
        clientUserEntity.setDiscount(0);
        clientUserEntity.setPoint(0);
        clientUserEntity.setPurchase(0);
        Date date = DateTools.changeDateMouth(new Date());
        clientUserEntity.setValidtime(new Timestamp(date.getTime()));
        clientUserEntity.setPayPassword(null);
        clientUserEntity.setUUIDForUser("http://localhost:8080//login/UserRegister/emailValidate?userUUID="+userUUID);
        //clientUserService.changeUserInfo(clientUserEntity);
        //配置账号基本信息
        securityEntity.setUserId(email);
        securityEntity.setPassword(password);
        securityEntity.setStatus(-2);
        securityEntity.setUUID(userUUID);
        securityEntity.setCreatTime(new Timestamp(new Date().getTime()));
        //保存用户信息
        loginService.registerNewVipUser(clientUserEntity,securityEntity);
        //发送验证邮件，等待用户确定
        emailService.sendEmailForRegister("630268696@qq.com",clientUserEntity);
        return "成功";
    }

    @GetMapping("/login/UserRegister/emailValidate")
    public String getVipUserWork(String userUUID){
        if(loginService.makeVipWork(userUUID)){
            return "邮箱验证成功";
        }else{
            return "该账号验证失败，可能已被验证";
        }
    }


}
