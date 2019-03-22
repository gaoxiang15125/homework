package com.j2ee.homework.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 16:01
 * @email: 630268696@qq.com
 **/
@Entity(name = "t_safeTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityEntity {

    @Id
    private String email;
    private String password;
    //可以映射这种自己定义的枚举类吗
    //private int types;
    //0标识正常账号，-1 标识被注销的账号，1标识未被验证的账号
    private int status;
}
