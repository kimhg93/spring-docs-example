package com.example.springdocs.ioc.bean.circulardependencies;

public class DiBeanC {

    private DiBeanD diBeanD;

    public void setDiBeanD(DiBeanD diBeanD) {
        this.diBeanD = diBeanD;
    }

    public void action(){
        System.out.println("DiBeanC Action!!");
    }

    public void diAction() {
        diBeanD.action();
    }
}
