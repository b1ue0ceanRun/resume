package com.run.resume.controller;


import com.run.resume.mapper.UserMapper;
import com.run.resume.pojo.FormInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Api(description = "上传一个formInfo对象")
@RestController
public class GetFormController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("1.Int uid 用户id" +
            "2.Int did 方向id" +
            "formlist: 可任意更改数目  列如 'name':'LiHua' 'hobby':'eat'")
    @PostMapping("/user/sendForm")
    public Map<String,Object> getForm(@RequestBody FormInfo formInfo) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map1.put("status", 500);
        map1.put("msg", "uid不正确");
        map2.put("status", 500);
        map2.put("msg", "已达到提交次数，请明天再来提交");
        map3.put("status", 200);
        map3.put("msg", "提交成功！");
        System.out.println(formInfo);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        int uid = userMapper.getUidByUsername(username);
        if (uid!=formInfo.getUid()){
            return map1;
        }
        int did = formInfo.getDid();

        if (userMapper.findUploadTime(uid,did) > 3) {
            return map2;
        }
        System.out.println("good");
        userMapper.updateUploadTime(uid, did);

        mongoTemplate.insert(formInfo);


        return map3;
    }

}
