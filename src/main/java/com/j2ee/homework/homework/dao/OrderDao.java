package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-25 14:31
 * @email: 630268696@qq.com
 **/
public interface OrderDao extends JpaRepository<OrderEntity,Integer> {

    List<OrderEntity> findAllByClientUserId(int clientUserId);

    List<OrderEntity> findAllByRestaurantId(int restaurantId);

    List<OrderEntity> findAllByGoodsId(int goodsId);

    List<OrderEntity> findAllByStatus(int status);
    //不确定可否查询
    @Query(value = "select * from orders where status =?1 and order_time <=?2",nativeQuery = true)
    List<OrderEntity> findAllByStatusAndOrderTime(int status,Date date);

}
