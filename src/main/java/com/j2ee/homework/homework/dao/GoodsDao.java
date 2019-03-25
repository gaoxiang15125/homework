package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-25 14:28
 * @email: 630268696@qq.com
 **/
public interface GoodsDao extends JpaRepository<GoodsEntity,Integer> {

    List<GoodsEntity> findAllByRestaurantId(int restaurantId);

    GoodsEntity findById(int goodId);
}
