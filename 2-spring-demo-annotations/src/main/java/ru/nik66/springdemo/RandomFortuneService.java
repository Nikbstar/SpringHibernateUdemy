package ru.nik66.springdemo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    List<String> services;

    public RandomFortuneService() {
        this.services = Arrays.asList("Beware of thie wolf in sheep's clothing",
                "Diligence is the mother of good luck", "The journey is the reward");
    }

    @Override
    public String getFortune() {
        return gerRandomService();
    }

    private String gerRandomService() {
        Random random = new Random(System.currentTimeMillis());
        int rndNum = random.nextInt(this.services.size());
        return this.services.get(rndNum);
    }

}
