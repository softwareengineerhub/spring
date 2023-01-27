package com.app.demp.utils;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXUtils {

    public static void stop(String url) throws Exception {
        MBeanServerConnection connection = getConnector(url);
        stop(connection);
    }

    public static void start(String url) throws Exception {
        MBeanServerConnection connection = getConnector(url);
        start(connection);
    }

    public static void setConcurrentConsumers(String url, int concurrency) throws Exception {
        MBeanServerConnection connection = getConnector(url);
        setConcurrentConsumers(connection, concurrency);
    }

    private static MBeanServerConnection getConnector(String url) throws Exception {
        //String url = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector";
        JMXServiceURL serviceUrl = new JMXServiceURL(url);
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();
        return connection;
    }

    private static void stop(MBeanServerConnection connection) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "stop";
        connection.invoke(objectName, operationName, new Object[0], new String[0]);
    }

    private static void start(MBeanServerConnection connection) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "start";
        connection.invoke(objectName, operationName, new Object[0], new String[0]);
    }

    private static void setConcurrentConsumers(MBeanServerConnection connection, int concurrency) throws Exception {
        ObjectName objectName = new ObjectName("bean:name=MySimpleListenerContainer");
        String operationName = "setConcurrentConsumers";
        connection.invoke(objectName, operationName, new Object[]{concurrency}, new String[]{"int"});
    }

}
