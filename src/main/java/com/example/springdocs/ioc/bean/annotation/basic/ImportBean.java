package com.example.springdocs.ioc.bean.annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImportBean {

    @Value("import test bean message!")
    private String message;
    private String text;

    @Autowired
    public ImportBean(@Value("import test bean text!") String text) {
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
