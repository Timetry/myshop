package com.myshop.controller.portal;

import io.swagger.annotations.*;
import com.myshop.common.Const;
import com.myshop.common.ServiceResponse;
import com.myshop.pojo.User;
import com.myshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(tags = "用户模块接口")
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //用户登录
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录", httpMethod = "POST")
    public ServiceResponse<User> login(@ApiParam(name = "username", value = "用户名") String username,
                                       @ApiParam(name = "password", value = "用户密码") String password,
                                       @ApiParam(name = "session", value = "session请求") HttpSession session) {
        ServiceResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getDate());
        }
        return response;
    }

    //用户退出
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse<String> logout(HttpSession session){
        //移除session
        session.removeAttribute(Const.CURRENT_USER);
        return ServiceResponse.createBySuccess();
    }

    //用户注册
    

}
