package com.j2ee.homework.homework.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Entity(name = "clientUsers")
public class ClientUserEntity {
    @Id
    @GeneratedValue
    int id;
    private String email;
    private String userName;
    private String gender;
    private String telphone;
    //-1表示未验证的账号，0标识正常账号
    //决定移动到密码验证表内
    //private int status = -1;
    //private Date birthday;
    //private int vip;
    //用户账号余额
    double balance;
    //用户等级
    int level;
    //用户享有的折扣
    double discount;
    //会员积分
    int point;
    //用户总的消费额
    double purchase;
    //会员有效期(默认是一个月)
    Date validtime;
    //支付密码
    String payPassword;
    //注册使用的UUID
    private String UUIDForUser;
}
