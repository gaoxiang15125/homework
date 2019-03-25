package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 17:12
 * @email: 630268696@qq.com
 **/
public interface RestaurantDao extends JpaRepository<RestaurantEntity,Integer> {

    @Query(value = "select * from restaurants where restaurantuuid =?1",nativeQuery = true)
    RestaurantEntity getRestaurantEntitiesByRestaurantUUID(String restaurantUUID);
    @Query(value = "select * from restaurants where restaurant_name like ?1",nativeQuery = true)
    List<RestaurantEntity> findAllByRestaurantName(String restaurantName);
    //判断数据库中是否已经有该账户
    boolean existsByRestaurantUUID(String restaurantUUID);
}
