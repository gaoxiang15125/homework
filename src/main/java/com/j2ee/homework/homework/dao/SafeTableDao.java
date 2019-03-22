package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.SecurityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 16:22
 * @email: 630268696@qq.com
 **/
public interface SafeTableDao extends JpaRepository<SecurityEntity,Integer> {

    //该邮件是否已经被注册

    /**
     *
     * @param userEmail
     * @return 0标识未被注册，非0标识目标邮件已经被注册
     */
    @Query(value = "select count(*) from t_safeTable where email = ?1",nativeQuery = true)
    int isUserExist(String userEmail);

    @Query(value = "select password from t_safeTable where email =?1",nativeQuery = true)
    String getPasswordByUserIDAnd(String userEmail);

}
