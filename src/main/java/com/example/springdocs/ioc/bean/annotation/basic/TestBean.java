package com.example.springdocs.ioc.bean.annotation.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(ImportBean.class)
public class TestBean {

    private String text;
    @Value("test message!")
    private String message;

    public TestBean(@Value("test text!") String text){
        this.text = text;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void action(){
        System.out.println(text);
        System.out.println(message);
    }

}

