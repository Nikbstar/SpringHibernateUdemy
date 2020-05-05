package ru.nik66.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());
        System.out.println(myCoach.getEmail());
        System.out.println(myCoach.getTeam());
        context.close();
    }

}
