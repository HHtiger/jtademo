package com.tiger.config.dataSources;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.stereotype.Repository;

import java.util.Properties;
@Repository
public class SlaveAtomDataSource extends AtomikosDataSourceBean {

    private static final long serialVersionUID = -6210394799199416765L;
    public SlaveAtomDataSource(){
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("URL", "jdbc:mysql://127.0.0.1:3306/test2");
        setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        setUniqueResourceName("mysql_test2_test");
        setPoolSize(900);
        setMaxPoolSize(900);
        setXaProperties(prop);
    }


}