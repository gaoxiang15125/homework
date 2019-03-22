package com.j2ee.homework.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 16:10
 * @email: 630268696@qq.com
 **/
@Entity(name = "t_walet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity {
    @Id
    private String email;
    //private UserTaken types;
    private double money;

}
