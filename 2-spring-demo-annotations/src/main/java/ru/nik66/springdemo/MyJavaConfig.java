package ru.nik66.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJavaConfig {

    @Bean
    public FortuneService crazyFortuneService() {
        return new CrazyFortuneService();
    }

    @Bean
    public Coach gymCoach() {
        GymCoach result = new GymCoach();
        result.setFortuneService(crazyFortuneService());
        return result;
    }

}
