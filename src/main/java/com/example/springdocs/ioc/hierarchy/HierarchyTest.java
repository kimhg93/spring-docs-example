package com.example.springdocs.ioc.hierarchy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

/**
 * 컨텍스트의 계층 구조
 * IoC 컨테이너를 계층구조를 만들 수 있으며 DI를 위해 Bean을 찾을 때 부모 컨텍스트의 Bean까지 모두 검색한다.
 * 우선순위는 자신이 먼저이며 부모가 같은 이름의 Bean을 가졌더라도 무시된다.
 */
public class HierarchyTest {

    @Test
    public void test() {
        StaticApplicationContext parent = new StaticApplicationContext();
        parent.registerBean("printer", StringPrinter.class);

        BeanDefinition parentDef = new RootBeanDefinition(Hello.class);
        parentDef.getPropertyValues().addPropertyValue("name", "Parent");
        parentDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));
        parent.registerBeanDefinition("hello", parentDef);
        /* xml 설정
        <bean id="printer" class="com.example.springdocs.ioc.hierarchy.Printer" />

        <bean id="hello" class="com.example.springdocs.ioc.hierarchy.Hello">
             <property name="name" value="Parent" />
             <property name="printer" ref="printer"/>
        </bean>
         */

        // parent를 부모 컨텍스트로 지정
        StaticApplicationContext child = new StaticApplicationContext(parent);

        BeanDefinition childDef = new RootBeanDefinition(Hello.class);
        childDef.getPropertyValues().addPropertyValue("name", "Child");
        childDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));
        child.registerBeanDefinition("hello", childDef);
        /* xml 설정
        <bean id="hello" class="com.example.springdocs.ioc.hierarchy.Hello">
             <property name="name" value="Child" />
             <property name="printer" ref="printer"/>
        </bean>
         */


        Printer printer = child.getBean("printer", Printer.class);

        // 자식 컨텍스트에서 printer Bean에 접근 가능한지 확인
        assertThat(printer, is(notNullValue()));

        // 동일한 이름의 Bean을 가져와 컨텍스트간 우선순위 확인(자식 컨텍스트의 Bean이 가져와짐)
        Hello hello = child.getBean("hello", Hello.class);
        hello.print();
        assertThat(printer.toString(), is("Hello Child"));


    }
}
