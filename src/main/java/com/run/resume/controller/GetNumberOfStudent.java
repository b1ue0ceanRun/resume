package com.run.resume.controller;

import com.run.resume.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "获取某方向学生总数")
@RestController
public class GetNumberOfStudent {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/admin/getNumberOfStudent")
    public int getNumberOfStudent(@RequestParam("did") int did){
        String direction = "D"+ did;

        return userMapper.findNumberOfStudent(direction);
    }

}
