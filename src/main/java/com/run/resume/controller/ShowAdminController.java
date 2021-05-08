package com.run.resume.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.run.resume.mapper.UserMapper;
import com.run.resume.pojo.Role;
import com.run.resume.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(description = "获取小组管理员的信息的接口")
@RestController
public class ShowAdminController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("分页获取小组管理员的信息 pageNum:展示第几页      pageSize:一页有多少条信息")
    //pagehelper要在配置文件中配置 不要忘了！！！
    @GetMapping("/boss/showAdmin")
    public PageInfo<User> ShowAdminInfo(@RequestParam("pageNum") String pageNum,
                                        @RequestParam("pageSize") String pageSize){


        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<User> userList =  userMapper.ShowAdminInfo();
        List<Role> roleList = new ArrayList<>();
        for (User user:userList
             ) {

            user.setRoles(roleList);

        }
        System.out.println(userList);
        return new PageInfo<>(userList);
    }



}
