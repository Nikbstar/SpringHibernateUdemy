package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach firstCoach = context.getBean("tennisCoach", Coach.class);
        Coach secondCoach = context.getBean("tennisCoach", Coach.class);
        boolean result = (firstCoach == secondCoach);
        System.out.println("firstCoach == secondCoach ? " + result);
        System.out.println("Memory location for firstCoach: " + firstCoach);
        System.out.println("Memory location for secondCoach: " + secondCoach);
        context.close();
    }

}
