package org.skillsup.services;

public interface WeatherService {
    Integer getWeather(String city) throws InterruptedException;
}
