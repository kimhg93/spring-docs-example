package com.example.springdocs.ioc.bean.circulardependencies;

public class DiBeanD {

    private DiBeanC diBeanC;

    public void setDiBeanC(DiBeanC diBeanC) {
        this.diBeanC = diBeanC;
    }

    public void action(){
        System.out.println("DiBeanD Action!!");
    }

    public void diAction(){
        diBeanC.action();
    }
}
