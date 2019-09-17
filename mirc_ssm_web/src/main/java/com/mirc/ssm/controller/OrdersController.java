package com.mirc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mirc.ssm.domain.Orders;
import com.mirc.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单的表现层
 */

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService = null;


    /**
     * 未分页
     * @return
     * @throws Exception
     */
    //    @RequestMapping("/findAll.do")
    //    public ModelAndView findAll() throws Exception {
    //
    //        ModelAndView modelAndView = new ModelAndView();
    //
    //        List<Orders> orders = ordersService.findAll();
    //
    //        modelAndView.addObject("ordersList", orders);
    //
    //        modelAndView.setViewName("orders-list");
    //
    //        return modelAndView;
    //    }

    /**
     * 订单详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", required = true,defaultValue = "1") Integer page,
                                @RequestParam(value = "pageSize",required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Orders> orders = ordersService.findAll(page, size);

        PageInfo pageInfo = new PageInfo(orders);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("orders-page-list");

        return mv;
    }




}
