package com.gyarsilalsolanki011.JournalApp.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {

    private Main main;

    @Getter
    @Setter
    public static class Main {
        private double temp;
    }
}

