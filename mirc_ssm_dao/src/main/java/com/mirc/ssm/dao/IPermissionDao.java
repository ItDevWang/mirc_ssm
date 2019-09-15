package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Permission;

import java.util.List;

public interface IPermissionDao {


    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionByRoleId(String id) throws Exception;

}
