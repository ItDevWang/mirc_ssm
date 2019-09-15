package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Orders;

import java.util.List;

public interface IOrdersDao {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll() throws Exception;


    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    Orders findById(String id) throws Exception;

}
