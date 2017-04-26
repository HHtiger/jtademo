package com.tiger.service.impl;

import com.tiger.service.AtomTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtomTransactionServiceImpl implements AtomTransactionService {

    @Autowired
    JdbcTemplate mastTemplate;

    @Autowired
    JdbcTemplate slaveTemplate;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertTest() throws Exception {
        String str = "bb";
        String masterSql = "insert into demo (name) values "+"('"+str+"')";
        String slaveSql = "insert into test (name) values "+"('"+str+"')";
        mastTemplate.execute(masterSql);
        slaveTemplate.execute(slaveSql);
    }

}