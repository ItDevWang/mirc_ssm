package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.domain.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 通过用户Id查询角色Id
     * @param usersId
     * @return
     * @throws Exception
     */
    Role findRoleByUserId(String usersId) throws Exception;


    /**
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionByRoleId(String roleId) throws Exception;


    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存操作
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;


}
