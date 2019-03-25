package com.j2ee.homework.homework;

import com.j2ee.homework.homework.dao.*;
import com.j2ee.homework.homework.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
    //测试用数据
    String userUUID ="630268699@qq.com";
    String restaurant = "1234567";
    @Autowired
    AddressDao addressDao;
    @Autowired
    ClientUserDao clientUserDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    SafeDao safeDao;

    //实体对象与存储类型
    SecurityEntity userSecurityEntity;
    SecurityEntity restaurantSecurity;
    ClientUserEntity clientUserEntity;
    List<AddressEntity> addressEntities;
    RestaurantEntity restaurantEntity;
    List<RestaurantEntity> restaurantEntities;
    List<GoodsEntity> goodsEntities;
    GoodsEntity goodsEntity;
    List<OrderEntity> orderEntities;
    @Test
    public void safeDaoTest() {
        System.out.println("<---------------密码DAO层测试开始------------->");
        userSecurityEntity = safeDao.findByUUID(userUUID);
        restaurantSecurity = safeDao.findByUUID(restaurant);
        System.out.println(userSecurityEntity.toString());
        System.out.println(restaurantSecurity.toString());
        System.out.println(safeDao.findByUserId(userSecurityEntity.getUserId()).toString());
        System.out.println(safeDao.findByUserId(restaurantSecurity.getUserId()).toString());
        System.out.println(safeDao.findPasswordByUserId(userUUID));
        System.out.println(safeDao.findPasswordByUserId(restaurant));
    }
    @Test
    public void setClientUserDao(){
        System.out.println("<----------------用户DAO层测试开始------------->");
        clientUserEntity = clientUserDao.getClientUserInfo(userUUID);
        System.out.println(clientUserEntity.toString());
        System.out.println(clientUserDao.existsByEmail(userUUID));
    }
    @Test
    public void addressDaoTest(){
        System.out.println("<-----------------地址DAO层测试开始------------->");
        addressEntities = addressDao.getAddressEntitiesById(clientUserEntity.getId());
        for(AddressEntity addressEntity:addressEntities){
            System.out.println(addressEntity.toString());
        }
    }
    @Test
    public void restaurantDaoTest(){
        System.out.println("<-----------------餐厅DAO层测试开始------------->");
        restaurantEntity = restaurantDao.getRestaurantEntitiesByRestaurantUUID(restaurant);
        System.out.println(restaurant.toString());
        restaurantEntities = restaurantDao.findAllByRestaurantName("黄焖鸡");
        for(RestaurantEntity restaurantEntity:restaurantEntities){
            System.out.println(restaurantEntity.toString());
        }
        System.out.println(restaurantDao.existsByRestaurantUUID("4561237"));
    }
    @Test
    public void goodsDaoTest(){
        System.out.println("<-----------------商品DAO层测试开始------------->");
        goodsEntities = goodsDao.findAllByRestaurantId(restaurantEntity.getId());
        for(GoodsEntity goodsEntity:goodsEntities){
            System.out.println(goodsEntity.toString());
        }
        goodsEntity = goodsDao.findById(0);
        System.out.println(goodsEntity.toString());
    }
    @Test
    public void orderDaoTest(){
        orderEntities = orderDao.findAllByClientUserId(clientUserEntity.getId());
        orderEntities = orderDao.findAllByRestaurantId(restaurantEntity.getId());
        orderEntities = orderDao.findAllByGoodsId(goodsEntity.getId());
        orderEntities = orderDao.findAllByStatus(0);
        long time = System.currentTimeMillis();
        orderEntities = orderDao.findAllByStatusAndOrderTime(0,new Date(time));
    }

}
