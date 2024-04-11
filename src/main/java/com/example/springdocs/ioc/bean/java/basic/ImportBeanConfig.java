package com.example.springdocs.ioc.bean.java.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportBeanConfig {

    @Bean
    public ImportBean importBean() {
        ImportBean importBean = new ImportBean("import test bean text!");
        importBean.setMessage("import test bean message!");
        return importBean;
    }
}
