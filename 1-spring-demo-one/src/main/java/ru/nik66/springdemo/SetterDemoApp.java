package ru.nik66.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println("Team: " + coach.getTeam());
        System.out.println("Email: " + coach.getEmail());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }

}
