package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.ClientUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 16:13
 * @email: 630268696@qq.com
 **/
public interface ClientUserDao extends JpaRepository<ClientUserDao,Integer> {

    //获取单个用户所有信息
    @Query(value = "select * from t_clientUser where email = ?1",nativeQuery = true)
    ClientUserEntity getClientUserInfo(String email);

}
