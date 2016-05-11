package org.skillsup;

import org.skillsup.services.WeatherService1;
import org.skillsup.services.WeatherService2;
import org.skillsup.services.WeatherService3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WeatherManager {

    private WeatherService1 weatherService1;
    private WeatherService2 weatherService2;
    private WeatherService3 weatherService3;

    public void calculate(String city) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        Integer sum = 0;

        futures.add(service.submit(new WeatherReceiver(weatherService1, city)));
        futures.add(service.submit(new WeatherReceiver(weatherService2, city)));
        futures.add(service.submit(new WeatherReceiver(weatherService3, city)));

        service.shutdown();

        for (Future<Integer> future : futures) {
            Integer second = future.get();
            sum += second;
        }
        System.out.println("----------------------------");
        System.out.println("Average temperature " + sum / 3 + " degrees Celsius");
    }

    public WeatherService1 getWeatherService1() {
        return weatherService1;
    }

    public void setWeatherService1(WeatherService1 weatherService1) {
        this.weatherService1 = weatherService1;
    }

    public WeatherService2 getWeatherService2() {
        return weatherService2;
    }

    public void setWeatherService2(WeatherService2 weatherService2) {
        this.weatherService2 = weatherService2;
    }

    public WeatherService3 getWeatherService3() {
        return weatherService3;
    }

    public void setWeatherService3(WeatherService3 weatherService3) {
        this.weatherService3 = weatherService3;
    }
}
