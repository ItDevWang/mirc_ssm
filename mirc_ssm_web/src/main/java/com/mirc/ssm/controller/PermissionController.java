package com.mirc.ssm.controller;

import com.mirc.ssm.domain.Permission;
import com.mirc.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 资源权限控制层
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * 添加资源
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    /**
     * 权限详情
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id", required = true) String permissionId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(permissionId);

        mv.addObject("permission",permission);
        mv.setViewName("permission-show");

        return mv;
    }

    /**
     * 删除非关联的权限
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deletePermission.do")
    public String deletePermission(@RequestParam(value = "id",required = true) String permissionId ) throws Exception {
        permissionService.deletePermission(permissionId);

        return "redirect:findAll.do";
    }


}
