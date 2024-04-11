package com.example.springdocs.ioc.bean.circulardependencies;

public class DiBeanA {

    private DiBeanB diBeanB;

    public DiBeanA(DiBeanB diBeanB){
        this.diBeanB = diBeanB;
    }
}
