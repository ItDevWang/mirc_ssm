package com.mirc.ssm.dao;

import com.mirc.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findByUsername(String username) throws Exception;


    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUsers() throws Exception;


    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    void saveUser(UserInfo user) throws Exception;

    /**
     * 用户详情
     * @param userId
     * @return
     * @throws Exception
     */
    UserInfo findById(String userId) throws Exception;

    /**
     * 用户和角色的关联
     * @param userId
     * @param roleId
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
