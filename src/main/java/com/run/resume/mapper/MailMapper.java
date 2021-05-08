package com.run.resume.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailMapper {

    //找到管理员的邮箱
    List<String> findAdminMail(Integer did);




}
