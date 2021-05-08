package com.run.resume.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DirectionMapper {
    //注册时 选择方向
    int updateDirection(Integer uid,Integer did);

    //更改方向的介绍
    int changeDirectionInfo(Integer directionID, String info);

    //获取方向的介绍
    String getDirectionInfo(Integer directionId);

}
