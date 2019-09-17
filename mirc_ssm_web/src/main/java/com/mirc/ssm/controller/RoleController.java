package com.mirc.ssm.controller;

import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.domain.Role;
import com.mirc.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 角色详情
     * @param roleId
     * @return
     */
    @RequestMapping("/findRoleById.do")
    public ModelAndView findRoleById(@RequestParam(value = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleById(roleId);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(value = "id", required = true) String roleId) throws Exception {
        roleService.deleteRole(roleId);
        return "redirect:findAll.do";
    }

    /**
     * 给角色添加权限
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();

        Role role = roleService.findRoleById(roleId);

        List<Permission> permissionList = roleService.findOtherPermissionByRoleId(roleId);

        mv.addObject("role", role);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");

        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(value = "roleId", required = true) String roleid,
                                      @RequestParam(value = "ids", required = true) String[] permissionIds ) throws Exception {
        roleService.addPermissionToRole(roleid, permissionIds);


        return "redirect:findAll.do";
    }



}
