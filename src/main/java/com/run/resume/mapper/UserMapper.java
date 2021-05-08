package com.run.resume.mapper;

import com.run.resume.pojo.Role;
import com.run.resume.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User loadUserByUid(int uid);

    User loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer id);

    int getUidByUsername(String username);

    //添加普通用户的权限
    int setUserRole(Integer Uid);

    int insertUploadTime(Integer uid);

    //记录上传次数
    int updateUploadTime(Integer uid, Integer did);

    //判断是否在某方向达到上传次数
    int findUploadTime(Integer uid , Integer did);

    //过了一天 又可以重新提交了
    int updateAllUploadTime();

    int insertUserDirection(Integer uid);

    //获取某方向学员的数量
    int findNumberOfStudent(String direction);



    //boss添加管理员
    int setAdminRole(Integer uid);

    //创建账户
    int addUser(User user);

    //boss冻结账户
    int lockUser(String username);

    //boss解封账户
    int unlockUser(String username);

    //boss删除账户
    int deleteUser(String username);

    //查询所有管理员用户信息
    List<User> ShowAdminInfo();

    //查询对应方向未审核的人员的id
    List<Integer> ShowUncheckedUserInfo(Integer did);


}
