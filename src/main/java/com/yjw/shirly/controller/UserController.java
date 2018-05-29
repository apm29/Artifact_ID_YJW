package com.yjw.shirly.controller;

import com.yjw.shirly.model.bean.Response;
import com.yjw.shirly.model.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/login")
    public Response login(String username,String pwd) {
        Response response = new Response();
        // 先判断用户名是否存在，给定不同Code用于区分不同错误
        boolean isExist = userService.isExist(username);
        if(!isExist) {
            response.setCode(Response.CODE_USER_NOT_EXIST);
            response.setMsg("用户不存在或密码错误");
        }else {
            // 判断用户名和密码是否匹配
            boolean isMatch = userService.isExist(username,pwd);

            if (!isMatch) {
                response.setCode(Response.CODE_USER_PWD_ERR);
                response.setMsg("用户不存在或密码错误");
            }else {
                response.setCode(Response.CODE_USER_LOGIN_SUCCESS);
                response.setMsg("登陆成功");
            }
        }



        return response;
    }

    @ResponseBody
    @PostMapping("/register")
    public Response register(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
        Response response = new Response();

        // 注册之前，判断用户名是否已存在
        boolean isExist = userService.isExist(username);
        if(isExist) {
            response.setCode(Response.CODE_USER_HAS_EXIST);
            response.setMsg("用户名已存在");
        } else {
            userService.saveUser(username, pwd);
        }

        return response;
    }

}
