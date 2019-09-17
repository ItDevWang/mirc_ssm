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
     * 根据ID查角色
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findRoleById(String roleId) throws Exception;


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


    /**
     * 查 user 以外的角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findOtherRole(String userId) throws Exception;

    /**
     * 删除角色
     * @param roleId
     * @throws Exception
     */
    void deleteRole(String roleId) throws Exception;


    /**
     * 查询可以添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissionByRoleId(String roleId) throws Exception;


    /**
     * 给角色添加权限
     * @param roleid
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(String roleid, String[] permissionIds) throws Exception;
}
