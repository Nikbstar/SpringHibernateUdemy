package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivityApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("runningCoach", Coach.class);
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());
        context.close();
    }

}
