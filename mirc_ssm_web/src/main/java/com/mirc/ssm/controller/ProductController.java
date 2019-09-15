package com.mirc.ssm.controller;

import com.mirc.ssm.domain.Product;
import com.mirc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll();

        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }


}
