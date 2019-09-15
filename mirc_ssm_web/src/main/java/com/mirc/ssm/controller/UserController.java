package com.mirc.ssm.controller;

import com.mirc.ssm.dao.IUserDao;
import com.mirc.ssm.domain.UserInfo;
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

}
