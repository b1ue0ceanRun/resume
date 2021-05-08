package com.run.resume.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.run.resume.mapper.UserMapper;

import com.run.resume.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(description = "给每个学长展示对应方向的未审核的学员的信息")
@RestController       //给每个学长选人  展示对应方向的未审核的学员的信息
public class ShowUserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("did -- 方向id 展示某个方向所有未审核的学员的信息  pageNum:展示第几页      pageSize:一页有多少条信息")
    @GetMapping("/admin/findUncheckedUserInfo")
    public PageInfo<User> findUncheckedUserInfo(@RequestParam Integer did,
                                                @RequestParam("pageNum") String pageNum,
                                                @RequestParam("pageSize") String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<Integer> UidList = userMapper.ShowUncheckedUserInfo(did);
        List<User> userList = new ArrayList<>();
        for (Integer uid : UidList
        ) {
            userList.add(userMapper.loadUserByUid(uid));
        }
        return new PageInfo<>(userList);

    }


}
