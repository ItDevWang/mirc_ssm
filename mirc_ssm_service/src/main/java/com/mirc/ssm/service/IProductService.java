package com.mirc.ssm.service;

import com.mirc.ssm.domain.Product;

import java.util.List;

/**
 * 业务层
 */
public interface IProductService {

   List<Product> findAll(Integer page, Integer size) throws Exception;

   void save(Product product) throws Exception;
}
