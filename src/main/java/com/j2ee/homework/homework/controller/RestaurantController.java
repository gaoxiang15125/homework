package com.j2ee.homework.homework.controller;

import com.j2ee.homework.homework.dao.GoodsDao;
import com.j2ee.homework.homework.entity.GoodsEntity;
import com.j2ee.homework.homework.entity.OrderEntity;
import com.j2ee.homework.homework.entity.RestaurantEntity;
import com.j2ee.homework.homework.service.ClientUserService;
import com.j2ee.homework.homework.service.RestaurantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-27 15:47
 * @email: 630268696@qq.com
 **/
@RestController
public class RestaurantController {

    @Autowired
    RestaurantUserService restaurantUserService;

    @GetMapping("/restaurant/getRestaurantInfo")
    public RestaurantEntity getRestaurantInfoByUUID(String restaurantUUID){
        return restaurantUserService.getRestaurantInfo(restaurantUUID);
    }
    //先一律get，需要的时候在进行修改
    @GetMapping("/restaurant/changeRestaurantInfo")
    public boolean changeRestaurantInfo(RestaurantEntity restaurantEntity){
        RestaurantEntity restaurantEntitybuff = restaurantUserService.getRestaurantInfo(restaurantEntity.getRestaurantUUID());
        try{
            restaurantEntity.setId(restaurantEntitybuff.getId());
            restaurantUserService.changeRestaurantInfo(restaurantEntity);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @GetMapping("/restaurant/getAllGoods")
    public List<GoodsEntity> getAllGoodsByRestaurantID(int restaurantID){
        return restaurantUserService.getAllRestaurantGoods(restaurantID);
    }
    @GetMapping("/restaurant/goods/addGoods")
    public boolean addNewGoods(String name,int restaurantId,double price,String img,String description){
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setName(name);
        goodsEntity.setRestaurantId(restaurantId);
        goodsEntity.setPrice(price);
        goodsEntity.setImg(img);
        goodsEntity.setDescription(description);
        goodsEntity.setSales(0);
        try{
            restaurantUserService.addNewGoods(goodsEntity);
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }
    @GetMapping("/restaurant/goods/deleteGoods")
    public boolean deleteGoods(GoodsEntity goodsEntity){
        try{
            restaurantUserService.removeGoods(goodsEntity);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @GetMapping("/restaurant/orders")
    public List<OrderEntity> getAllOrderByRestaurantID(int restaurantID){
        return restaurantUserService.getAllRestaurantOrder(restaurantID);
    }

}
