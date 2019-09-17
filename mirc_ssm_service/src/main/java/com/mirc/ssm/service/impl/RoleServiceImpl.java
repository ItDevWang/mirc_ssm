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
    public Role findRoleById(String roleId) throws Exception {
        return roleDao.findRoleById(roleId);
    }

    @Override
    public void save(Role role) throws Exception{
        roleDao.save(role);
    }

    @Override
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception{
        return roleDao.findPermissionByRoleId(roleId);
    }

    @Override
    public List<Role> findOtherRole(String userId) throws Exception {
        return roleDao.findOtherRole(userId);
    }

    /**
     * 删除角色
     * @param roleId
     * @throws Exception
     */
    @Override
    public void deleteRole(String roleId) throws Exception {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Permission> findOtherPermissionByRoleId(String roleId) throws Exception {
        return roleDao.findOtherPermissionByRoleId(roleId);
    }

    @Override
    public void addPermissionToRole(String roleid, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleid, permissionId);
        }
    }
}
