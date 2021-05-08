package com.run.resume.mapper;

import com.run.resume.pojo.File;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {

    int addFile(File file);

    List<File> findFile(Integer uid, Integer did);

    //审查文件
    int checkFile(int id);




}
