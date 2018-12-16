package com.myshop.controller.portal;
import io.swagger.annotations.Api;
import com.myshop.common.Const;
import com.myshop.common.ServiceResponse;
import com.myshop.pojo.User;
import com.myshop.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(tags="用户信息")
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //用户登录
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "0 成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model") })
    @ApiOperation(httpMethod = "POST", value = "个人信息")
    public ServiceResponse<User> login(String username, String password, HttpSession session) {
        ServiceResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getDate());
        }
        return response;
    }
}
