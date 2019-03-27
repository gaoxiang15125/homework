package com.j2ee.homework.homework.controller;

import com.j2ee.homework.homework.dao.AddressDao;
import com.j2ee.homework.homework.dao.ClientUserDao;
import com.j2ee.homework.homework.entity.AddressEntity;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.entity.OrderEntity;
import com.j2ee.homework.homework.service.ClientUserService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-27 14:29
 * @email: 630268696@qq.com
 **/
@RestController
public class UserController {
    @Autowired
    ClientUserDao clientUserDao;
    @Autowired
    ClientUserService clientUserService;
    @Autowired
    AddressDao addressDao;
    @GetMapping("/vipUser/userInfo")
    public ClientUserEntity getUserInfoByEmail(String email){
        return clientUserService.getClientUserInfo(email);
    }

    @GetMapping("/vipUser/updateUserInfo")
    public String updateUsrInfo(String email,String userName,String gender,String telPhone){
        ClientUserEntity clientUserEntity = clientUserDao.getClientUserInfo(email);
        clientUserEntity.setUserName(userName);
        clientUserEntity.setGender(gender);
        clientUserEntity.setTelphone(telPhone);
        try{
            clientUserDao.save(clientUserEntity);
            return "修改信息成功";
        }catch (Exception e){
            e.printStackTrace();
            return "修改信息失败";
        }
    }

    @GetMapping("/address/getAddressByID")
    public List<AddressEntity> getAllAddressByClientID(int clientID){
        return addressDao.getAddressEntitiesById(clientID);
    }

    @GetMapping("/address/addNewAddress")
    public String addNewAddress(int clientID,String address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setClientId(clientID);
        addressEntity.setAddress(address);
        addressDao.save(addressEntity);
        return "添加地址成功";
    }
    @GetMapping("address/deleteAddress")
    public boolean removeAddress(int clientID,String address){
        try{
            addressDao.deleteAddressEntitiesByAddressAndClientIdAnd(address,clientID);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //简单的查看所有订单快捷键
    @GetMapping("orders/userOrders")
    public List<OrderEntity> getAllOrderEntityByClientID(int clientID){
        return clientUserService.getAllUserOrder(clientID);
    }
    //等待补充修改订单状态，联系商家等控制器功能的实现
}
