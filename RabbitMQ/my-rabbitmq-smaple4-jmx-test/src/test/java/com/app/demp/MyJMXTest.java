package com.app.demp;

import org.junit.Test;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import java.net.MalformedURLException;

public class MyJMXTest {

    @Test
    public void test() throws Exception {
        MBeanServerConnectionFactoryBean jmx = new MBeanServerConnectionFactoryBean();
        jmx.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector");
    }

}
