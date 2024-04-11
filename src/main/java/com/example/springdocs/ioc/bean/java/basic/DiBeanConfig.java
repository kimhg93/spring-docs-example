package com.example.springdocs.ioc.bean.java.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiBeanConfig {

    @Bean
    public DiBean diBean(TestBean testBean, ImportBean importBean){
        DiBean diBean = new DiBean(testBean);
        diBean.setImportBean(importBean);
        diBean.setMessage("========== DI TestBean Call");
        return diBean;
    }
}
