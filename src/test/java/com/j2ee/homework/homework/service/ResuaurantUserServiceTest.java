package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.dao.GoodsDao;
import com.j2ee.homework.homework.dao.RestaurantDao;
import com.j2ee.homework.homework.entity.GoodsEntity;
import com.j2ee.homework.homework.entity.RestaurantEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 09:57
 * @email: 630268696@qq.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResuaurantUserServiceTest {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    RestaurantDao restaurantDao;
    @Test
    public void testLikeResult(){
        List<RestaurantEntity> restaurantEntities = restaurantDao.findAllByRestaurantName("黄焖鸡");
        List<GoodsEntity> goodsEntities = goodsDao.findAllByGoodsName("黄焖");
    }
}