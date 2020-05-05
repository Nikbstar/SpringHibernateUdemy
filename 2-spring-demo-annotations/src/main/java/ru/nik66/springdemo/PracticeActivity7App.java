package ru.nik66.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeActivity7App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyJavaConfig.class);
        Coach coach = context.getBean("gymCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }

}
