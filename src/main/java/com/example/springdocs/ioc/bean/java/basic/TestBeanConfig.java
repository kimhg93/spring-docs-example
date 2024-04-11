package com.example.springdocs.ioc.bean.java.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ImportBeanConfig.class)
public class TestBeanConfig {

    @Bean
    public TestBean testBean(){
        TestBean testBean =  new TestBean("test text!");
        testBean.setMessage("test message!");
        return testBean;
    }

}
