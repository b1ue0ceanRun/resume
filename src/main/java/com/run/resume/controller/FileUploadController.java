package com.run.resume.controller;

import com.run.resume.mapper.DirectionMapper;
import com.run.resume.mapper.FileMapper;
import com.run.resume.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



@Api(description = "用户上传文件的接口")
//目标： 限制文件上传类型  !
@RestController
public class FileUploadController {
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DirectionMapper directionMapper;


    @ApiOperation("用户上传文件")
    @PostMapping(name = "/user/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Object> upload( @RequestPart("file") MultipartFile file,
                                      @RequestParam("directionID") Integer did) throws IOException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Integer Uid = userMapper.getUidByUsername(authentication.getName());
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("status", 200);
        map1.put("msg", "上传成功");
        map2.put("status", 222);
        map2.put("msg", "上传失败，超出10MB或者格式不符合");


        if (!file.isEmpty()) {


            //路径
            String path = "D:\\IMGUPLOAD";


            //获取文件名
            String originalFilename = file.getOriginalFilename();

            //获取文件大小
            Long size = file.getSize();

            //获取文件类型
            String type = file.getContentType();

            //获取扩展文件名
            String extension = "." + FilenameUtils.getExtension(file.getOriginalFilename());


            if (!extension.equals(".docx")) {
                return map2;
            }

            //获取当前上传的时间
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String uploadTime = formatter.format(date);

            //命名新文件名

            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "") + extension;

            //处理文件上传
            file.transferTo(new File(path + "\\" + newFileName));

            //将信息存贮至数据库
            com.run.resume.pojo.File uploadFile = new com.run.resume.pojo.File();
            uploadFile.setDid(did);
            uploadFile.setFileName(originalFilename);
            uploadFile.setSize(String.valueOf(size));
            uploadFile.setType(type);
            uploadFile.setPath(path + "\\" + newFileName);
            uploadFile.setUploadTime(uploadTime);
            uploadFile.setUid(Uid);
            uploadFile.setExtension(extension);
            uploadFile.setNewFileName(newFileName);

            System.out.println(uploadFile);

            fileMapper.addFile(uploadFile);
            directionMapper.updateDirection(Uid,did);

            return map1;


        }else {
            return map2;
        }





    }

}