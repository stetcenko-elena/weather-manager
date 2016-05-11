package org.skillsup.services;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WeatherService1 implements WeatherService {

    public Integer getWeather(String city) throws InterruptedException {
        Random random = new Random();
        int temperature = random.nextInt(30) + 1;
        TimeUnit.SECONDS.sleep(random.nextInt(3) + 1);
        System.out.println(" The temperature in the city  " + city + " - " + temperature + " degrees Celsius");
        return temperature;
    }
}
