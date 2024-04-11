package com.example.springdocs.ioc.bean.definition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

/**
 * 1. 클래스를 싱글톤 Bean으로 등록(디폴트 메타 정보)
 * 2. BeanDefinition 타입의 메타정보를 생성, 이를통해 Bean으로 등록
 * 3. Printer를 Bean으로 등록하고, BeanDefinition 타입의 메타정보에 DI를 포함하여 생성, Bean으로 등록
 */
public class DefinitionTest {

    @Test
    public void test() {
        // 1
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);
        assertThat(hello1, is(notNullValue()));

        // 2
        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        ac.registerBeanDefinition("hello2", helloDef);
        /* xml 설정
        <bean id="hello2" class="com.example.springdocs.ioc.bean.definition.Hello">
             <property name="name" value="Spring" />
        </bean>
         */

        Hello hello2 = ac.getBean("hello2", Hello.class);

        assertThat(hello2.sayHello(), is("Hello Spring"));

        assertThat(hello1, is(not(hello2)));
        assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));

        // 3
        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));
        BeanDefinition helloDef2 = new RootBeanDefinition(Hello.class);
        helloDef2.getPropertyValues().addPropertyValue("name", "Spring");
        helloDef2.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));
        ac.registerBeanDefinition("hello3", helloDef2);
        /* xml 설정
        <bean id="hello3" class="com.example.springdocs.ioc.bean.definition.Hello">
             <property name="name" value="Spring" />
             <property name="printer" ref="printer"/>
        </bean>
         */

        Hello hello3 = ac.getBean("hello3", Hello.class);
        hello3.print();

        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));

    }
}
