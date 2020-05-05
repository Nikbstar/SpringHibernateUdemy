package ru.nik66.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String email;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("CricketCoach.setEmail: inside setter method.");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach.setTeam: inside setter method.");
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach.setFortuneService: inside setter method.");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling!";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
