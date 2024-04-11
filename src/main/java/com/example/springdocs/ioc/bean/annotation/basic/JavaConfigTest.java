package com.example.springdocs.ioc.bean.annotation.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {

    /**
     * Java 기반 Bean 설정에 대한 예시
     *
     * com.example.springdocs.ioc.bean.xml.basic 패키지 내의 xml 기반 설정과 동일한 어노테이션 기반 설정
     */

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.action();

        ImportBean importBean = (ImportBean) context.getBean("importBean");
        importBean.action();

        DiBean diBean = (DiBean) context.getBean("diBean");
        diBean.action();
    }

}
