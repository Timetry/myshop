package com.myshop.service.impl;

import com.myshop.common.ServiceResponse;
import com.myshop.dao.UserMapper;
import com.myshop.pojo.User;
import com.myshop.service.IUserService;
import com.myshop.util.MD5Util;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServiceResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserName(username);
        if (resultCount == 0) {
            return ServiceResponse.createByErrorMessage("用户名不存在");
        }
        //将用户输入的密码进行MD5加密后再与数据库对比
        String md5password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5password);
        if (user == null) {
            return ServiceResponse.createByErrorMessage("密码错误");
        }
        return ServiceResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServiceResponse<String> register(User user) {

        //效验（用户名及email）
        //数据库中的密码是MD5加密之后的
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int regisUser = userMapper.insert(user);
        if (regisUser == 0) {
            return ServiceResponse.createByErrorMessage("注册失败");
        }
        return ServiceResponse.createBySuccessMessage("注册成功");

    }

    //效验用户名用户类型，email是否存在
    
}
