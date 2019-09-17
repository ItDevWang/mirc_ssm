package com.mirc.ssm.service.impl;

import com.mirc.ssm.dao.IUserDao;
import com.mirc.ssm.domain.Role;
import com.mirc.ssm.domain.UserInfo;
import com.mirc.ssm.service.IUserService;
import com.mirc.ssm.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 权限校验器
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;

        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理用户信息封装为UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true,
                true,
                true,
                true,
                getAuthority(userInfo.getRoles()));

        return user;
    }

    // 作用是返回一个集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAllUsers() throws Exception {
        return userDao.findAllUsers();
    }

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    @Override
    public void saveUser(UserInfo user) throws Exception {
        // 加密
        String password = BCryptPasswordEncoderUtils.encodePassword(user.getPassword());
        user.setPassword(password);
        userDao.saveUser(user);
    }


    /**
     * 用户详情
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String userId) throws Exception {
        return userDao.findById(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
