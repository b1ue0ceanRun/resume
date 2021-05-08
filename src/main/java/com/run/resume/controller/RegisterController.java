package com.run.resume.controller;

import com.run.resume.mapper.UserMapper;
import com.run.resume.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@Api(description = "注册的接口")
//对用户输入进行过滤
@RestController
public class RegisterController {
    @Autowired
    private UserMapper userMapper;


    //普通用户注册
    @ApiOperation("普通用户注册")
    @GetMapping("/user/Register")
    public Map<String, Object> Register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword);
        user.setPhone(phone);
        user.setEmail(email);

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("status", 200);
        map1.put("msg", "注册成功");
        map2.put("status", 401);
        map2.put("msg", "用户名重复");

        //解决用户名重复问题
        if (userMapper.loadUserByUsername(username) == null) {
            userMapper.addUser(user);
            Integer Uid = userMapper.getUidByUsername(username);
            userMapper.setUserRole(Uid);
            userMapper.insertUploadTime(Uid);
            userMapper.insertUserDirection(Uid);
        } else {
            return map2;
        }


        return map1;
    }

    //小组管理员账号分配
    @ApiOperation("小组管理员账号分配")
    @GetMapping("/boss/register")
    public Map<String, Object> adminRegister(@RequestParam("username") String username,
                                             @RequestParam("password") String password,
                                             @RequestParam("phone") String phone,
                                             @RequestParam("email") String email) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword);
        user.setPhone(phone);
        user.setEmail(email);

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("status", 200);
        map1.put("msg", "注册成功");
        map2.put("status", 401);
        map2.put("msg", "用户名重复");

        //解决用户名重复问题
        if (userMapper.loadUserByUsername(username) == null) {
            userMapper.addUser(user);
            Integer Uid = userMapper.getUidByUsername(authentication.getName());
            userMapper.setAdminRole(Uid);
        } else {
            return map2;
        }


        return map1;


    }

}
