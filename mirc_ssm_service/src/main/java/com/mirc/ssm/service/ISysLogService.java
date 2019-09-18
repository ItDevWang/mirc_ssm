package com.mirc.ssm.service;

import com.mirc.ssm.domain.SysLog;

import java.util.List;

/**
 * 日志的业务层
 */
public interface ISysLogService {


    /**
     * 保存日志信息
     * @param syslog
     * @throws Exception
     */
    public void save(SysLog syslog) throws Exception;


    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    public List<SysLog> findAll() throws Exception;

}
