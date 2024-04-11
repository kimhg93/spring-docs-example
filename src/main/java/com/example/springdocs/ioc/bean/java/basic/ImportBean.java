package com.example.springdocs.ioc.bean.java.basic;

public class ImportBean {

    private String message;
    private String text;

    public ImportBean(String text) {
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
