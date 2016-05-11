package org.skillsup;

import org.skillsup.services.WeatherService;

import java.util.concurrent.Callable;

public class WeatherReceiver implements Callable<Integer> {
    private WeatherService service;
    private String city;

    public WeatherReceiver(WeatherService service, String city) {
        this.service = service;
        this.city = city;
    }

    public WeatherService getService() {
        return service;
    }

    public void setService(WeatherService service) {
        this.service = service;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer call() throws Exception {
        return service.getWeather(city);
    }
}
