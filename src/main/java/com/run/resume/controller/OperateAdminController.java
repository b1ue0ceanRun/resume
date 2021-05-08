package com.run.resume.controller;

import com.run.resume.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(description = "对小组管理员进行操作")
@RestController
public class OperateAdminController {
    @Autowired
    private UserMapper userMapper;

    //账户冻结
    //boss不能冻结boss 有时间改一下
    @ApiOperation("通过用户名冻结某名用户 //回收账户")
    @GetMapping("/boss/lockUser")
    public Map<String, Object> lockUser(@RequestParam("username") String username) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("status", 200);
        map1.put("msg", "冻结成功");
        map2.put("status", 222);
        map2.put("msg", "冻结失败，未找到该用户");
        if (userMapper.loadUserByUsername(username) != null) {
            userMapper.lockUser(username);
            return map1;
        } else {
            return map2;
        }


    }
    @ApiOperation("通过用户名解冻某名用户")
    @GetMapping("/boss/unlockUser")
    public Map<String, Object> unlockUser(@RequestParam("username") String username) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("status", 200);
        map1.put("msg", "解冻成功");
        map2.put("status", 222);
        map2.put("msg", "解冻失败，未找到该用户");
        if (userMapper.loadUserByUsername(username) != null) {
            userMapper.unlockUser(username);
            return map1;
        } else {
            return map2;

        }


    }

//    @GetMapping("/boss/deleteUser")
//    public Map<String, Object> deleteUser(@RequestParam("username") String username) {
//        Map<String, Object> map1 = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//        map1.put("status", 200);
//        map1.put("msg", "删除成功");
//        map2.put("status", 222);
//        map2.put("msg", "删除失败，未找到该用户");
//        if (userMapper.loadUserByUsername(username) != null) {
//            userMapper.deleteUser(username);
//            return map1;
//        } else {
//            return map2;
//
//        }
//
//    }

}
