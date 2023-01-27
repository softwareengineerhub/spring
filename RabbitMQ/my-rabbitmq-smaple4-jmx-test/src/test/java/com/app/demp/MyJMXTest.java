package com.app.demp;

import org.junit.Test;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
import java.net.MalformedURLException;
import java.util.Hashtable;

public class MyJMXTest {

    @Test
    public void test3() throws Exception {
        String url = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector";
        JMXServiceURL serviceUrl = new JMXServiceURL(url);
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();
        int count = connection.getMBeanCount();
        System.out.println("count=" + count);
        //stop(connection);
        //start(connection);
        update(connection);
    }

    private void stop(MBeanServerConnection connection) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "stop";
        connection.invoke(objectName, operationName, new Object[0], new String[0]);
    }

    private void start(MBeanServerConnection connection) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "start";
        connection.invoke(objectName, operationName, new Object[0], new String[0]);
    }

    private void update(MBeanServerConnection connection) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "setConcurrentConsumers";
        connection.invoke(objectName, operationName, new Object[]{4}, new String[]{"int"});
    }
}
