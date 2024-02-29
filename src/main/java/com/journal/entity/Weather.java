package com.journal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
public class Weather {
    private CurrentConditions currentConditions;

    @Data
    @Getter
    @Setter
    public static class CurrentConditions {
        private String datetime;
        private int datetimeEpoch;
        private double temp;
        private double feelslike;
        private int humidity;
        private double dew;
        private int precip;
        private int precipprob;
        private int snow;
        private int snowdepth;
        private Object preciptype;
        private double windgust;
        private double windspeed;
        private int winddir;
        private int pressure;
        private double visibility;
        private int cloudcover;
        private int solarradiation;
        private double solarenergy;
        private int uvindex;
        private String conditions;
        private String icon;
        private ArrayList<String> stations;
        private String source;
        private String sunrise;
        private int sunriseEpoch;
        private String sunset;
        private int sunsetEpoch;
        private double moonphase;
        
    }
}
