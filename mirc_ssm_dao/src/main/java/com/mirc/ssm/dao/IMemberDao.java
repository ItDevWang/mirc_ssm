package com.mirc.ssm.dao;

import com.mirc.ssm.domain.Member;

public interface IMemberDao {

    /**
     * 按id查询
     * @param id
     * @return
     * @throws Exception
     */
    Member findById(String id) throws Exception;


}
