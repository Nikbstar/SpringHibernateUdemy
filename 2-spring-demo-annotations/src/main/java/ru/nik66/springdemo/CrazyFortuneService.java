package ru.nik66.springdemo;

public class CrazyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "It's a crazy day for you!";
    }
}
