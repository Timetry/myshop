package com.myshop.service.impl;

import com.myshop.common.ServiceResponse;
import com.myshop.dao.UserMapper;
import com.myshop.pojo.User;
import com.myshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServiceResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserName(username);
        if (resultCount==0){
            return ServiceResponse.createByErrorMessage("用户名不存在");
        }
        return null;
    }
}
