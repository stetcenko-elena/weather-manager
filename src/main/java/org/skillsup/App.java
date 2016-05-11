package org.skillsup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        WeatherManager weatherManager = context.getBean(WeatherManager.class);
        weatherManager.calculate("Dnepropetrovsk");
    }
}
