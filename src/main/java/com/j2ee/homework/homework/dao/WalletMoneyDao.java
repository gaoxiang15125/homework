package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 17:07
 * @email: 630268696@qq.com
 **/
public interface WalletMoneyDao extends JpaRepository<WalletEntity,Integer> {

    @Query("select money from t_walet where email =?1")
    double findMoneyByEmail(String email);

}
