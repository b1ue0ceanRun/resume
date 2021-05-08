package com.run.resume.controller;


import com.run.resume.mapper.DirectionMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(description = "获取和修改对应方向的描述的接口")
@RestController
public class DirectionInfoController {
    @Autowired
    private DirectionMapper directionMapper;

    @ApiOperation("directionID 1.java 2.python 3.美术 4.前端 5.产品经理 6.GO 7.Unity  info:介绍")
    @GetMapping("/admin/setDirectionInfo")
    public int setDirectionInfo(@RequestParam("directionID") Integer directionID,
                                @RequestParam("info") String info) {
        directionMapper.changeDirectionInfo(directionID, info);
        return 1;

    }

    @ApiOperation("获取对应方向的介绍")
    @GetMapping("/user/getDirectionInfo")
    public Map<String,Object> getDirectionInfo(@RequestParam("directionID") Integer directionID){
        String info = directionMapper.getDirectionInfo(directionID);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("msg",info);
        return map1;
    }
}
