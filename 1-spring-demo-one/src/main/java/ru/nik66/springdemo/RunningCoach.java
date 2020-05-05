package ru.nik66.springdemo;

public class RunningCoach implements Coach {

    private FortuneService fortuneService;

    public RunningCoach(FortuneService fortuneService) {
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
