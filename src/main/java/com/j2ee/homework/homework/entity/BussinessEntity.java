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
 * @create: 2019-03-22 16:46
 * @email: 630268696@qq.com
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_bussiness")
public class BussinessEntity {
    @Id
    private String BussinessUUID;
    //private String e_mail;
    private String bussinessName;
    private String telPhone;
    private int bussinessType;
    private String description;
}
