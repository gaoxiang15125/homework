package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.dao.AddressDao;
import com.j2ee.homework.homework.dao.ClientUserDao;
import com.j2ee.homework.homework.dao.OrderDao;
import com.j2ee.homework.homework.entity.AddressEntity;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 09:19
 * @email: 630268696@qq.com
 **/
@Service
public class ClientUserService {

    @Autowired
    ClientUserDao clientUserDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    OrderDao orderDao;
    public ClientUserEntity getClientUserInfo(String email){
        return clientUserDao.getClientUserInfo(email);
    }

    public Boolean save(ClientUserEntity clientUserEntity){
        try{
            clientUserDao.save(clientUserEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean changeUserInfo(ClientUserEntity clientUserEntity){
        ClientUserEntity clientUserEntityBuff = clientUserDao.getClientUserInfo(clientUserEntity.getEmail());
        try{
            clientUserEntity.setId(clientUserEntityBuff.getId());
            clientUserDao.save(clientUserEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<AddressEntity> getUsersAllAddress(int clientUserID){
        return addressDao.getAddressEntitiesById(clientUserID);
    }

    public boolean addNewAddress(AddressEntity addressEntity){
        try {
            addressDao.save(addressEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean removeAddress(int clientID,String address){
        try {
            addressDao.deleteAddressEntitiesByAddressAndClientIdAnd(address,clientID);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<OrderEntity> getAllUserOrder(int clientUserID){
        return orderDao.findAllByClientUserId(clientUserID);
    }
}
