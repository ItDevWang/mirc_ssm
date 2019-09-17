package com.mirc.ssm.service.impl;

import com.mirc.ssm.dao.ISysLogDao;
import com.mirc.ssm.domain.SysLog;
import com.mirc.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog syslog) throws Exception {
        sysLogDao.save(syslog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
