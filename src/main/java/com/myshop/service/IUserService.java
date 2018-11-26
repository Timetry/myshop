package com.myshop.service;

import com.myshop.common.ServiceResponse;
import com.myshop.pojo.User;

public interface IUserService {
    ServiceResponse<User> login(String username, String password);
}
