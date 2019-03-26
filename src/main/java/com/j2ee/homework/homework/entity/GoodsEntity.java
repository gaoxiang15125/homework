package com.j2ee.homework.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-25 08:49
 * @email: 630268696@qq.com
 **/
@Entity(name = "goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsEntity {

    @Id
    @GeneratedValue
    int id;
    String name;
    int restaurantId;
    double price;
    String img;
    String description;
    int sales;

}
