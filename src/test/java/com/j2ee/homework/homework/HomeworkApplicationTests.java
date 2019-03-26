package com.j2ee.homework.homework;

import com.j2ee.homework.homework.dao.*;
import com.j2ee.homework.homework.entity.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    static SecurityEntity userSecurityEntity;
    static SecurityEntity restaurantSecurity;
    static ClientUserEntity clientUserEntity;
    static List<AddressEntity> addressEntities;
    static RestaurantEntity restaurantEntity;
    static List<RestaurantEntity> restaurantEntities;
    static List<GoodsEntity> goodsEntities;
    static GoodsEntity goodsEntity;
    static List<OrderEntity> orderEntities;
    @Test
    public void asafeDaoTest() {
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
    public void bsetClientUserDao(){
        System.out.println("<----------------用户DAO层测试开始------------->");
        clientUserEntity = clientUserDao.getClientUserInfo(userUUID);
        System.out.println(clientUserEntity.toString());
        System.out.println(clientUserDao.existsByEmail(userUUID));
    }
    @Test
    public void caddressDaoTest(){
        System.out.println("<-----------------地址DAO层测试开始------------->");
        addressEntities = addressDao.getAddressEntitiesById(clientUserEntity.getId());
        for(AddressEntity addressEntity:addressEntities){
            System.out.println(addressEntity.toString());
        }
    }
    @Test
    public void drestaurantDaoTest(){
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
    public void egoodsDaoTest(){
        System.out.println("<-----------------商品DAO层测试开始------------->");
        goodsEntities = goodsDao.findAllByRestaurantId(restaurantEntity.getId());
        for(GoodsEntity goodsEntity:goodsEntities){
            System.out.println(goodsEntity.toString());
        }
        goodsEntity = goodsDao.findById(0);
        System.out.println(goodsEntity.toString());
    }
    @Test
    public void forderDaoTest(){
        orderEntities = orderDao.findAllByRestaurantId(restaurantEntity.getId());
        orderEntities = orderDao.findAllByGoodsId(goodsEntity.getId());
        orderEntities = orderDao.findAllByStatus(0);
        long time = System.currentTimeMillis();
        orderEntities = orderDao.findAllByStatusAndOrderTime(0,new Date(time));
    }

}
