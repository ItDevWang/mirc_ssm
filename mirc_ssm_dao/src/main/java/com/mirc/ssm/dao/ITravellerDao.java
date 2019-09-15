package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Traveller;

import java.util.List;

public interface ITravellerDao {

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    List<Traveller> findByOrdersId(String id) throws Exception;

}
