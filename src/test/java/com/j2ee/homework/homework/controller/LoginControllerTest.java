package com.j2ee.homework.homework.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-27 14:04
 * @email: 630268696@qq.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    LoginController loginController;
    @Test
    public void userRegister() {
        loginController.UserRegister("630268696@qq.com","高翔","男","18805156570","18805156570");
        System.out.println("finished");
    }
}