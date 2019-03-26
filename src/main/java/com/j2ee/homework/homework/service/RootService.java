package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.dao.*;
import com.j2ee.homework.homework.entity.AddressEntity;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 15:18
 * @email: 630268696@qq.com
 **/
@Service
public class RootService {

    @Autowired
    ClientUserDao clientUserDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    SafeDao safeDao;
    @Autowired
    ClientUserService clientUserService;
    @Autowired
    LoginService loginService;
    @Autowired
    RestaurantUserService restaurantUserService;

}
