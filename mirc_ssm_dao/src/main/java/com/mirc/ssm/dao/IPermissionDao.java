package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Permission;

import java.util.List;

public interface IPermissionDao {


    /**
     * 角色详情
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;


    /**
     * 创建角色
     * @throws Exception
     */
    void save(Permission permission) throws Exception;



}
