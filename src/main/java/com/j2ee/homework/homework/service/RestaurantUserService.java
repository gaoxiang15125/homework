package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.dao.GoodsDao;
import com.j2ee.homework.homework.dao.OrderDao;
import com.j2ee.homework.homework.dao.RestaurantDao;
import com.j2ee.homework.homework.entity.GoodsEntity;
import com.j2ee.homework.homework.entity.OrderEntity;
import com.j2ee.homework.homework.entity.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 09:19
 * @email: 630268696@qq.com
 **/
@Service
public class RestaurantUserService {

    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;
    public RestaurantEntity getRestaurantInfo(String restaurantUUID){
        return restaurantDao.getRestaurantEntitiesByRestaurantUUID(restaurantUUID);
    }

    public List<GoodsEntity> getAllRestaurantGoods(int restaurantID){
        return goodsDao.findAllByRestaurantId(restaurantID);
    }

    public boolean changeRestaurantInfo(RestaurantEntity restaurantEntity){
        RestaurantEntity restaurantEntityBuff = restaurantDao.getRestaurantEntitiesByRestaurantUUID(restaurantEntity.getRestaurantUUID());
        restaurantEntity.setId(restaurantEntityBuff.getId());
        restaurantDao.save(restaurantEntity);
        return true;
    }

    public void addNewGoods(GoodsEntity goodsEntity){
        goodsDao.save(goodsEntity);
    }

    public void removeGoods(GoodsEntity goodsEntity){
        goodsDao.delete(goodsEntity);
    }

    public List<OrderEntity> getAllRestaurantOrder(int restaurantID){
        return orderDao.findAllByRestaurantId(restaurantID);
    }
    //等待补充修改订单状态，对订单进行操作的方法
}
