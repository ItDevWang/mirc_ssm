package com.mirc.ssm.service.impl;

import com.mirc.ssm.dao.IRoleDao;
import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.domain.Role;
import com.mirc.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception{
        roleDao.save(role);
    }

    @Override
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception{
        return roleDao.findPermissionByRoleId(roleId);
    }
}
