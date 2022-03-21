package com.bert.spring5.Service;

import com.bert.spring5.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void testAccount(){
//        try{

            //少钱
            userDao.decreaseMoney();
            int i = 10/0;
            //多钱
            userDao.increaseMoney();

//        }catch (Exception e){//事务回滚

//        }



    }


}
