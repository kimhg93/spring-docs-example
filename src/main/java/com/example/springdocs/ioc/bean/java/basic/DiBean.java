package com.example.springdocs.ioc.bean.java.basic;

public class DiBean {

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

    public void setImportBean(ImportBean importBean) {
        this.importBean = importBean;
    }

    public void action(){
        System.out.println(message);
        testBean.action();
        importBean.action();
    }

}
