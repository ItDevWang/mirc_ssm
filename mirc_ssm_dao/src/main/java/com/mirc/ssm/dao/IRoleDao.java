package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

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
     * 根据id查角色
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findRoleById(String roleId) throws Exception;


    /**
     * 角色和权限的关联
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


    /**
     * 查询可以添加的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRole(String userId) throws Exception;


    /**
     * 删除角色
     * @param roleId
     * @throws Exception
     */
    void deleteRole(String roleId) throws Exception;


    /**
     * 查询可添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissionByRoleId(String roleId) throws Exception;


    /**
     * 为用户添加权限
     * @param roleid
     * @param permissionId
     * @throws Exception
     */
    void addPermissionToRole(@Param("roleId") String roleid, @Param("permissionId") String permissionId) throws Exception;
}
