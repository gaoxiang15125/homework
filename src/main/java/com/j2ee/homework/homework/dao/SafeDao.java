package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.SecurityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-25 14:59
 * @email: 630268696@qq.com
 **/
public interface SafeDao extends JpaRepository<SecurityEntity,Integer> {

    @Query("select password from safes where user_id =?1 and status=0")
    String findPasswordByUserId(String userId);
//    @Query("select password from safe where UUID =?1")
//    String findPasswordByUUID(String UUID);
    @Query(value = "select * from safes where uuid =?1",nativeQuery = true)
    SecurityEntity findByUUID(String UUID);
    @Query(value = "select * from safes where user_id =?1",nativeQuery = true)
    SecurityEntity findByUserId(String userId);

    @Query(value = "select * from safes where status !=0 and uuid = '0'",nativeQuery = true)
    List<SecurityEntity> findAllUnReadyRestaurant();

}
