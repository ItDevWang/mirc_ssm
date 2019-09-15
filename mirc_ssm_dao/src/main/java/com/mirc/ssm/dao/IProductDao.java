package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Product;

import java.util.List;

/**
 * 持久层
 */

public interface IProductDao {

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(String id) throws Exception;

    /**
     * 保存账户
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;
}
