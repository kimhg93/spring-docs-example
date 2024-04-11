package com.example.springdocs.ioc.bean.circulardependencies;

public class DiBeanB {

    private DiBeanA diBeanA;

    public DiBeanB(DiBeanA diBeanA){
        this.diBeanA = diBeanA;
    }
}
