package com.journal.services;


import com.journal.config.AppCache;
import com.journal.entity.Config;
import com.journal.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WeatherServices {
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private AppCache appCache;

    @Value("${weather.api.key}")
    private String apiKey;
    public ResponseEntity<?> getWeather(String city) {
        String API = appCache.appCache.get("WEATHER_API");
        System.out.println(API);
        String  finalAPI = API.replace("CITY", city).replace("<api_key>", apiKey);
        ResponseEntity<Weather> exchange = restTemplate.exchange(finalAPI, HttpMethod.GET, null, Weather.class);
        Weather weather = exchange.getBody();
        if (weather != null) {
            return new ResponseEntity<>("Feels like: "+ weather.getCurrentConditions().getFeelslike(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


