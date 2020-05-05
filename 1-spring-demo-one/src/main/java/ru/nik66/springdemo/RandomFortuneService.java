package ru.nik66.springdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private List<String> services = Arrays.asList("Bad day", "Usually day", "Lucky day");

    @Override
    public String getFortune() {
        return "It's your " + gerRandomService() + "!!!";
    }

    private String gerRandomService() {
        Random random = new Random(System.currentTimeMillis());
        int rndNum = random.nextInt(this.services.size());
        return this.services.get(rndNum);
    }

}
