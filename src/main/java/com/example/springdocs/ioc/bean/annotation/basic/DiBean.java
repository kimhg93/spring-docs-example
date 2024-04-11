package com.example.springdocs.ioc.bean.annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiBean {

    @Value("========== DI TestBean Call")
    private String message;
    private TestBean testBean;
    private ImportBean importBean;

    // 생성자 주입
    // applicationContext 를 통해 등록된 TestBean 을 di.xml 의 constructor-arg 를 통해 주입된다
    public DiBean(TestBean testBean){
        this.testBean = testBean;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Autowired
    public void setImportBean(ImportBean importBean) {
        this.importBean = importBean;
    }

    public void action(){
        System.out.println(message);
        testBean.action();
        importBean.action();
    }

}
