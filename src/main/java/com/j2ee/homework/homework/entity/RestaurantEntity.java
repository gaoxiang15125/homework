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
 * @create: 2019-03-22 16:46
 * @email: 630268696@qq.com
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "restaurants")
public class RestaurantEntity {
    @Id
    @GeneratedValue
    int id;
    String restaurantUUID;
    //private String e_mail;
    String restaurantName;
    String telPhone;
    int restaurantType;
    String description;
    String address;

}
