package com.example.springdocs.ioc.bean.annotation.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springdocs.ioc.bean.annotation")
public class AppConfig {
}
