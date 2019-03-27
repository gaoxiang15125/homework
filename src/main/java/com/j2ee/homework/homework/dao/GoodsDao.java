package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.GoodsEntity;
import com.j2ee.homework.homework.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    @Query(value = "select * from goods where name like %?1%",nativeQuery = true)
    List<GoodsEntity> findAllByGoodsName(String goodsName);
    @Modifying
    @Query("delete from goods where restaurant_id =?1 and name =?2")
    boolean deleteByRestaurantIdAndName(int restaurantID,String name);

}
