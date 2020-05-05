package ru.nik66.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @PostConstruct
    public void initMethod() {
        System.out.println("TennisCoach.initMethod: Do my startup stuff");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("TennisCoach.destroyMethod: Do my cleanup stuff");
    }

    public TennisCoach() {
        System.out.println("TennisCoach: inside default constructor.");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

}
