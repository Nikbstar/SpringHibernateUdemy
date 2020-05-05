package ru.nik66.springdemo;

public class GymCoach implements Coach {

    private FortuneService fortuneService;

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do crossfit training along 40 min.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

}
