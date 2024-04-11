package com.example.springdocs.ioc.bean.java.basic;

public class TestBean {

    private String text;
    private String message;

    public TestBean(String text){
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

