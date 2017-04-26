package com.tiger.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.tiger.config.dataSources.MasterAtomDatasource;
import com.tiger.config.dataSources.SlaveAtomDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;

/**
 * Created by root on 17-4-26.
 */


@Configuration
@ComponentScan(
        basePackages = {"com.tiger"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.tiger.model")}
)
public class BaseConfig {

    @Bean
    public UserTransactionManager getUserTransactionManager(){
        UserTransactionManager utm = new UserTransactionManager();
        utm.setForceShutdown(true);
        return utm;
    }

    @Bean
    public UserTransactionImp getUserTransactionImp(){
        UserTransactionImp uti = new UserTransactionImp();
        try {
            uti.setTransactionTimeout(3000);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return uti;
    }

    @Bean
    public JtaTransactionManager getJtaTransactionManager(){
        JtaTransactionManager jtm = new JtaTransactionManager();
        jtm.setTransactionManager(getUserTransactionManager());
        jtm.setUserTransaction(getUserTransactionImp());
        jtm.setAllowCustomIsolationLevels(true);
        return jtm;
    }

    @Bean(name = "mastTemplate")
    public JdbcTemplate getMastTemplate(){
        return new JdbcTemplate(new MasterAtomDatasource());
    }

    @Bean(name = "slaveTemplate")
    public JdbcTemplate getSlaveTemplate(){
        return new JdbcTemplate(new SlaveAtomDataSource());
    }

}
