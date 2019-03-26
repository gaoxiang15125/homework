package com.j2ee.homework.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-25 08:44
 * @email: 630268696@qq.com
 **/
@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue
    int id;
    int clientUserId;
    int goodsId;
    int restaurantId;
    double price;
    //0标识正常订单 1标识完成订单 -1 标识已经超时的订单
    int status ;
    //下单时间
    Date order_time;
    //用户备注
    String description;
}
