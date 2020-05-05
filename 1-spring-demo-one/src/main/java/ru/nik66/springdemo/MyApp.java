package ru.nik66.springdemo;

public class MyApp {

    public static void main(String[] args) {
        Coach baseballCoach = new TrackCoach(new HappyFortuneService());
        System.out.println(baseballCoach.getDailyWorkout());
    }

}
