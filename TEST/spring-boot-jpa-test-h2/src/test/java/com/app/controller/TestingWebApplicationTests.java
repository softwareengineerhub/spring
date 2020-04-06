package com.app.controller;

import com.app.config.MySpringConfig;
import com.app.service.SimpleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MySpringConfig.class})
public class TestingWebApplicationTests {

    @Autowired
    private SimpleService simpleService;

    //@Autowired
    //private HelloWorldController helloWorldController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(simpleService).isNotNull();
    }

    @Test
    public void contextLoads() {
    }

}
