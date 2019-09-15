package com.mirc.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.mirc.ssm.dao.IOrdersDao;
import com.mirc.ssm.domain.Orders;
import com.mirc.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao = null;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
