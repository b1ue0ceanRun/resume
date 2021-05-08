package com.run.resume.controller;

import com.run.resume.mapper.FileMapper;
import com.run.resume.pojo.File;
import com.run.resume.pojo.FormInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@Api(description = "1.供小组管理员进行审核  2.获取文件和表单")
@RestController
public class CheckController {
    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "formInfo";



    @ApiOperation("展示某个人某个方向的file的信息")
    @GetMapping("/admin/findFile")
    public List<File> findFile(@RequestParam("uid") Integer uid,
                               @RequestParam("did") Integer did){
        return fileMapper.findFile(uid,did);
    }

    @ApiOperation("根据路径下载file")
    @GetMapping("/admin/downloadFile")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("filePath") String filePath) throws IOException {

        FileSystemResource downloadFile = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", downloadFile.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(downloadFile.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(downloadFile.getInputStream()));

    }





    @ApiOperation("根据用户id和方向id展示某个人填写的表格")
    @GetMapping("/admin/showFormMessage")
    public List<FormInfo> showFormMessage(@RequestParam("uid") int uid,
                                          @RequestParam("did") int did){


        Query query=new Query(Criteria.where("uid").is(uid).and("did").is(did));
        List<FormInfo> formInfos =  mongoTemplate.find(query, FormInfo.class,COLLECTION_NAME);
        System.out.println(formInfos);
        return formInfos;
    }




    @ApiOperation("根据用户id审查用户的文件")
    @GetMapping("/admin/checkFile")
    public int checkFile(@RequestParam("id") int id){
        fileMapper.checkFile(id);
        return 1;

    }

}
