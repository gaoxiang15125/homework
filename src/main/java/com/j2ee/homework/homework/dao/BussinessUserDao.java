package com.j2ee.homework.homework.dao;

import com.j2ee.homework.homework.entity.BussinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 17:12
 * @email: 630268696@qq.com
 **/
public interface BussinessUserDao extends JpaRepository<BussinessEntity,Integer> {

    @Query(value = "select * from t_bussiness where BussinessEntity =?1",nativeQuery = true)
    BussinessEntity getBussinessByBussinessUUID(String bussinessUUID);

}
