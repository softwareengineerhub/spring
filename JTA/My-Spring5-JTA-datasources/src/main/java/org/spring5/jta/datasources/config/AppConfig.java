/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring5.jta.datasources.config;

import com.atomikos.icatch.jta.J2eeUserTransaction;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"org.spring5.jta.datasources"})
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource companyDataSource() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_company?useSSL=false");
        //mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_company");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("111111");
        

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("COMPANY-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource employeeDataSource() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_employee?useSSL=false");
        //mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/jta_employee");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("111111");        

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("EMPLOYEE-XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        dataSource.setXaDataSource(mysqlXaDataSource);
        dataSource.setPoolSize(1);
        return dataSource;
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

    @Bean
    public JtaTransactionManager transactionManager() throws IOException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
        jtaTransactionManager.setAllowCustomIsolationLevels(true);
        return jtaTransactionManager;
    }

}
