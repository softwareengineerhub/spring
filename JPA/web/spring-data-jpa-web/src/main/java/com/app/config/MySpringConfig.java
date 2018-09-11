/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configurable
@EnableTransactionManagement
@ComponentScan(basePackages = {"com"})
@PropertySource("classpath:app.properties")
//@EnableJpaRepositories("com.devcolibri.dataexam.repository")
@EnableWebMvc
public class MySpringConfig {

    @Resource
    private Environment environment;

    @Bean
    public JpaTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        LocalContainerEntityManagerFactoryBean factoryBean = getEntityManagerFactory();
        System.out.println("factoryBean="+factoryBean);
        //transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        DataSource dataSource = getDataSource();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        //entityManagerFactoryBean.setPackagesToScan(environment.getProperty("db.entitymanager.packages.to.scan"));
        entityManagerFactoryBean.setPackagesToScan("com");
        Properties props = getHibernateProperties();
        entityManagerFactoryBean.setJpaProperties(props);
        return entityManagerFactoryBean;
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.put("db.hibernate.dialect", environment.getRequiredProperty("db.hibernate.dialect"));
        props.put("db.hibernate.show_sql", environment.getRequiredProperty("db.hibernate.show_sql"));
        props.put("db.hibernate.hbm2ddl.auto", environment.getRequiredProperty("db.hibernate.hbm2ddl.auto"));
        return props;
    }
    
    @Bean
    public PersistenceAnnotationBeanPostProcessor getPersistenceAnnotationBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

}
