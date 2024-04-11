package com.example.springdocs.ioc.bean.circulardependencies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTest {

    /**
     * 순환 참조 문제
     *
     * A에는 생성자 주입을 통해 B의 인스턴스가 필요하고, B에는 생성자 주입을 통해 A의 인스턴스가 필요한 경우
     * 클래스 A와 B가 서로 주입되도록 Bean을 구성하면 Spring IoC 컨테이너는 BeanCurrentlyInCreationException을 발생시킨다.
     * 해결 방안은 생성자 주입을 피하고 setter injection 하는것이다. 권장되지는 않지만 setter 주입을 통해 순환 참조 문제를 해결할 수 있다.
     **/

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                // 생성자 주입 형태로 설정 (에러발생)
                //"classpath:com/example/springdocs/ioc/bean/xml/circulardependencies/constructor.xml",
                // setter 주입 형태로 설정 (정상동작)
                "classpath:com/example/springdocs/ioc/bean/circulardependencies/setter.xml"
        );

        DiBeanC diBeanC = (DiBeanC) context.getBean("diBeanC");
        diBeanC.diAction();

        DiBeanD diBeanD = (DiBeanD) context.getBean("diBeanD");
        diBeanD.diAction();

    }

}
