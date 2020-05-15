package ru.nik66.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nik66.aopdemo.config.DemoConfig;
import ru.nik66.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println(">>> Main Program: AroundDemoApp start");
        System.out.println("calling getFortune()");
        String data = service.getFortune();
        System.out.println("My fortune is: " + data);
        System.out.println(">>> Main Program: AroundDemoApp finish");
        context.close();
    }

}
