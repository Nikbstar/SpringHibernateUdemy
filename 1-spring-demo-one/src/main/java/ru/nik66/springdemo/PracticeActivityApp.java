package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivityApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("practiceActivityCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }

}
