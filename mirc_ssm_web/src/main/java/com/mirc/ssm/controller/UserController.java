package com.mirc.ssm.controller;

import com.mirc.ssm.dao.IUserDao;
import com.mirc.ssm.domain.Role;
import com.mirc.ssm.domain.UserInfo;
import com.mirc.ssm.service.IRoleService;
import com.mirc.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllUsers() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> allUsers = userService.findAllUsers();

        mv.addObject("userList", allUsers);

        mv.setViewName("user-list");

        return mv;
    }

    /**
     * 新建操作
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String Save(UserInfo user) throws Exception {
        userService.saveUser(user);
        return "redirect:/user/findAll.do";
    }

    /**
     * 用户详情
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);

        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;

    }

    /**
     * 用户以及可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> otherRoleList = roleService.findOtherRole(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 注意： jsp页面需要校验，当没有勾选任何角色时
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId", required = true) String userId,
                                @RequestParam(value = "ids", required = true) String[] roleIds ) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }


}
