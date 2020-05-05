package ru.nik66.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements Coach {

    private final FortuneService fortuneService;

    @Autowired
    public RunningCoach(@Qualifier("fileRandomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Easy run 21 km.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

}
