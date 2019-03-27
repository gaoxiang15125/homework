package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.dao.ClientUserDao;
import com.j2ee.homework.homework.dao.SafeDao;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.entity.SecurityEntity;
import com.j2ee.homework.homework.tools.RegExpValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 09:20
 * @email: 630268696@qq.com
 **/
@Service
public class LoginService {

    @Autowired
    SafeDao safeDao;
    @Autowired
    ClientUserDao clientUserDao;
    public boolean isPasswordRight(String userId,String password){
        String passwordBuffer ;
        try{
            passwordBuffer=safeDao.findPasswordByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        if(password.equals(passwordBuffer)){
            return true;
        }else{
            return false;
        }
    }

    public void registerNewVipUser(ClientUserEntity clientUserEntity ,SecurityEntity securityEntity){
        safeDao.save(securityEntity);
        clientUserDao.save(clientUserEntity);
    }

    public boolean makeVipWork(String UUID){
        try{
            SecurityEntity securityEntity = safeDao.findByUUID(UUID);
            securityEntity.setStatus(0);
            safeDao.save(securityEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public List<SecurityEntity> getAllUnReadyRestaurant(){
        return safeDao.findAllUnReadyRestaurant();
    }

    public boolean setRestaurantReady(String user_id){
        try{
            SecurityEntity securityEntity = safeDao.findByUserId(user_id);
            securityEntity.setStatus(0);
            safeDao.save(securityEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void save(SecurityEntity securityEntity){
        safeDao.save(securityEntity);
    }

    public boolean deleteVIPUser(String email){
        try{
            SecurityEntity clientUserEntity = safeDao.findByUserId(email);
            clientUserEntity.setStatus(-1);
            safeDao.save(clientUserEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
