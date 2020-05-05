package ru.nik66.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5 km.";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it! " + this.fortuneService.getFortune();
    }

    public void initMethod() {
        System.out.println("TrackCoach.initMethod: Do my startup stuff");
    }

    public void destroyMethod() {
        System.out.println("TrackCoach.destroyMethod: Do my cleanup stuff");
    }


}
