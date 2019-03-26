package com.j2ee.homework.homework.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 11:13
 * @email: 630268696@qq.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SafeDaoTest {
    @Autowired
    SafeDao safeDao;
    @Test
    public void testOne(){
        System.out.println(safeDao.findAllUnReadyRestaurant());
        System.out.println(safeDao.findPasswordByUserId("1234567"));
        System.out.println(safeDao.findPasswordByUserId("630268699@qq.com"));
    }
}