package com.j2ee.homework.homework.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-15 09:25
 * @email: 630268696@qq.com
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_clientUser")
public class ClientUserEntity {
    @Id
    private String email;
    private String userName;
    private String gender;
    private String telphone;
    //-1表示未验证的账号，0标识正常账号
    //决定移动到密码验证表内
    //private int status = -1;
    private Date birthday;

    @Transient
    private String UUIDForUser;
}
