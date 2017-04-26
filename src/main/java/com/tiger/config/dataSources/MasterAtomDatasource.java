package com.tiger.config.dataSources;

import com.atomikos.jdbc.AtomikosDataSourceBean;

import java.util.Properties;

public class MasterAtomDatasource extends AtomikosDataSourceBean {

    private static final long serialVersionUID = -2471230875536339311L;

    public MasterAtomDatasource(){
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("URL", "jdbc:mysql://127.0.0.1:3306/test");
        setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        setUniqueResourceName("mysql_test_demo");
        setPoolSize(900);
        setMaxPoolSize(900);
        setXaProperties(prop);
    }

}