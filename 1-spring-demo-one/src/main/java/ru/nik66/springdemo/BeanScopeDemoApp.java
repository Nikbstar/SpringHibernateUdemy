package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeContext.xml");
        Coach firstCoach = context.getBean("myCoach", Coach.class);
        Coach secondCoach = context.getBean("myCoach", Coach.class);
        boolean result = (firstCoach == secondCoach);
        System.out.println("firstCoach == secondCoach ? " + result);
        System.out.println("Memory location for firstCoach: " + firstCoach);
        System.out.println("Memory location for secondCoach: " + secondCoach);
        context.close();
    }

}
