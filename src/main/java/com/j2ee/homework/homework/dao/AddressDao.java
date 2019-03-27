package com.j2ee.homework.homework.dao;

        import com.j2ee.homework.homework.entity.AddressEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;

        import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 17:25
 * @email: 630268696@qq.com
 **/
public interface AddressDao extends JpaRepository<AddressEntity,Integer> {

    @Query(value = "select * from address where client_id =?1",nativeQuery = true)
    List<AddressEntity> getAddressEntitiesById(int clientId);
    @Modifying
    @Query(value = "delete from address where address=?1 and client_id=?2",nativeQuery = true)
    boolean deleteAddressEntitiesByAddressAndClientIdAnd(String address,int clientID);
}
