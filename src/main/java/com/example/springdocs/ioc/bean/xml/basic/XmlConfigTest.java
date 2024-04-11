package com.example.springdocs.ioc.bean.xml.basic;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTest {

    /**
     * XML 기반 Bean 설정에 대한 예시
     *
     *  TestBean 클래스의 Bean 메타데이터는 applicationContext.xml에 정의되어 있다
     *  ImportTestBean 클래스의 Bean 메타데이터는 importTest.xml에 정의되어 있으며 applicationContext.xml에서 import 한다
     *  DiBean 클래스의 Bean 메타데이터는 di.xml에 정의되어 있으며 property를 통해 ImportBean을 전달하고,
     *  constructor-arg를 사용하여 TestBean을 DiBean의 생성자로 전달한다 (DiBean에 ImportBean, TestBean이 DI 된다)
     *  ClassPathXmlApplicationContext는 applicationContext.xml, di.xml을 참조하여 TestBean, ImportTestBean, DiBean을 등록한다
     */

    @Test
    public void test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "classpath:com/example/springdocs/ioc/bean/xml/basic/applicationContext.xml",
                        "classpath:com/example/springdocs/ioc/bean/xml/basic/di.xml");

        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.action();

        ImportBean importBean = (ImportBean) context.getBean("importBean");
        importBean.action();

        DiBean diBean = (DiBean) context.getBean("diBean");
        diBean.action();
    }

}
