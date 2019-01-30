/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import java.lang.management.ManagementFactory;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.junit.Test;
import sun.management.ConnectorAddressLink;

/**
 *
 * @author Denys.Prokopiuk
 */
public class JMXTest {

    @Test
    public void test() throws Exception {
        String jmxHost = ConnectorAddressLink.importFrom(16916);
        System.out.println("jmxHost=" + jmxHost);

        JMXServiceURL serviceURL = new JMXServiceURL(jmxHost);
        JMXConnector connector = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection server = connector.getMBeanServerConnection();

        Set<ObjectName> set = server.queryNames(null, null);
        System.out.println("count=" + set.size());

        for (ObjectName item : set) {
            System.out.println(item.getDomain());
        }

        ObjectName objectName = new ObjectName("audit.service:type=JMSContainer,name=queueContainer");
        ObjectInstance instance = server.getObjectInstance(objectName);
        System.out.println(instance.getClassName());
        server.invoke(objectName, "start", new Object[]{}, new String[]{});
        //instance.getClass().getMethod("stop").invoke(instance);
    }

}
