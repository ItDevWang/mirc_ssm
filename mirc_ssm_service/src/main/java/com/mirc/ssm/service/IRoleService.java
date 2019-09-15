package com.mirc.ssm.service;

import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.domain.Role;

import java.util.List;

/**
 * 角色持久层
 */
public interface IRoleService {

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存操作
     * @param role
     */
    void save(Role role) throws Exception;

    /**
     * 查关联表
     * @param roleId
     * @return
     */
    List<Permission> findPermissionByRoleId(String roleId) throws Exception;
}
