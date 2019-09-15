package com.mirc.ssm.service;

import com.mirc.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrdersService {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll() throws Exception;



    /**
     * 分页查询所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int size) throws Exception;


    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    Orders findById(String id) throws Exception;

}
