package com.app.config;

import com.atomikos.icatch.jta.J2eeUserTransaction;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.SystemException;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    /*@Bean
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/repotest?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }*/


   /* @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource2() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/repotest?useSSL=false");
        //mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_employee");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("11111111");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("my2-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }*/

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/repotest?useSSL=false");
        //mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_employee");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("11111111");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("my-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }

    @Bean
    public JtaTransactionManager transactionManager() throws IOException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
        jtaTransactionManager.setAllowCustomIsolationLevels(true);
        return jtaTransactionManager;
    }


    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager manager = new UserTransactionManager();
        manager.setForceShutdown(false);
        return manager;
    }

    @Bean
    public J2eeUserTransaction atomikosUserTransaction() {
        try {
            J2eeUserTransaction userTransaction = new J2eeUserTransaction();
            userTransaction.setTransactionTimeout(300);
            return userTransaction;
        } catch (SystemException ex) {
            throw new RuntimeException(ex);
        }
    }
}
