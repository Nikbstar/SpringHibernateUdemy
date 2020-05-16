package ru.nik66.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nik66.aopdemo.config.DemoConfig;
import ru.nik66.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static final Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info(">>> Main Program: AroundDemoApp start");
        logger.info("calling getFortune()");
        boolean tripWire = true;
        String data = service.getFortune(tripWire);
        logger.info("My fortune is: " + data);
        logger.info(">>> Main Program: AroundDemoApp finish");
        context.close();
    }

}
