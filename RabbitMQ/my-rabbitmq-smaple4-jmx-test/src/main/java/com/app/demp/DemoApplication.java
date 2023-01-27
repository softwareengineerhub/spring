package com.app.demp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RmiRegistryFactoryBean rmi() {
		RmiRegistryFactoryBean rmi = new RmiRegistryFactoryBean();
		rmi.setPort(1099);
		return rmi;
	}

	@Bean
	public ConnectorServerFactoryBean server() throws Exception {
		ConnectorServerFactoryBean fb = new ConnectorServerFactoryBean();
		fb.setObjectName("connector:name=rmi");
		fb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector");
		return fb;
	}
}
