package com.fxwebapp.fxrates.services;

import com.fxwebapp.fxrates.links.LbLinks;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LBService {

    public String getRatesDataFromLB(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(LbLinks.GET_RATES, String.class);
    }

    public String getHistoryDataFromLB(String currency){
        RestTemplate restTemplate = new RestTemplate();
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = dateObj.format(formatter);
        return restTemplate.getForObject(String.format(LbLinks.GET_HISTORY, today, currency), String.class);
    }

    public String getCurrenciesFromLB(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(LbLinks.GET_CURRENCIES, String.class);
    }

}
