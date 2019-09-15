package com.mirc.ssm.service;

import com.mirc.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 *  用户业务层接口
 */
public interface IUserService extends UserDetailsService{

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

}
