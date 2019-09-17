package com.mirc.ssm.dao;

import com.mirc.ssm.domain.SysLog;

import java.util.List;

/**
 * 日志类
 */
public interface ISysLogDao {

    /**
     * 保存日志内容
     * @param syslog
     * @throws Exception
     */
    void save(SysLog syslog) throws Exception;


    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<SysLog> findAll() throws Exception;
}
