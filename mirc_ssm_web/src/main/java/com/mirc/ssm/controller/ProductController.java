package com.mirc.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mirc.ssm.domain.Product;
import com.mirc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * web层
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService = null;

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(value = "pageSize", required = true, defaultValue = "3") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll(page, size);

        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }


}
