package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycleContext.xml");
        Coach coach = context.getBean("myCoach", Coach.class);
        System.out.println("Coach: " + coach.getDailyWorkout());
        System.out.println("Coach: " + coach.getDailyFortune());
        Coach coach1 = context.getBean("myCoach", Coach.class);
        System.out.println("Coach1: " + coach1.getDailyWorkout());
        System.out.println("Coach1: " + coach1.getDailyFortune());
        context.close();
    }

}
