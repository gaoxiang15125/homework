package com.j2ee.homework.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 16:01
 * @email: 630268696@qq.com
 **/
@Entity(name = "safes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityEntity {

    @Id
    @GeneratedValue
    int id;
    private String userId;
    private String password;
    //可以映射这种自己定义的枚举类吗
    //private int types;
    //0标识正常账号，-1 标识被注销的账号，-2标识未被验证的账号 1标识已登陆用户
    private int status;
    //用户的唯一标识码UUID，之所以不作为key值是因为劳资不想用
    //没错 他跟用户表里存储的UUID是一样
    String UUID;
    Timestamp creatTime;
}
