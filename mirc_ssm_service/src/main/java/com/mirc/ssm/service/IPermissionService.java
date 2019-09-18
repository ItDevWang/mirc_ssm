package com.mirc.ssm.service;

import com.mirc.ssm.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源权限业务层
 */
public interface IPermissionService {

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 添加资源权限
     * @throws Exception
     */
    void save(Permission permission) throws Exception;

    /**
     * 资源详情
     * @param permissionId
     */
    Permission findById(String permissionId) throws Exception;

    /**
     * 删除权限
     * @param permissionId
     */
    void deletePermission(String permissionId) throws Exception;
}
