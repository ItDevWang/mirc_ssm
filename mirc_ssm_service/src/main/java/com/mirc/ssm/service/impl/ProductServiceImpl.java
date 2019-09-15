package com.mirc.ssm.service.impl;

import com.mirc.ssm.dao.IProductDao;
import com.mirc.ssm.domain.Product;
import com.mirc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao = null;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
