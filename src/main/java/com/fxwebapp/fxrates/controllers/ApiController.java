package com.fxwebapp.fxrates.controllers;

import com.fxwebapp.fxrates.entities.Currency;
import com.fxwebapp.fxrates.entities.Rate;
import com.fxwebapp.fxrates.entities.RateHis;
import com.fxwebapp.fxrates.services.*;
import com.fxwebapp.fxrates.links.ApiLinks;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ApiController {

    @Autowired
    RatesService ratesService;
    @Autowired
    RatesHistoryService ratesHistoryService;
    @Autowired
    CurrenciesService currenciesService;
    @Autowired
    SyncService syncService;

    @GetMapping(path = ApiLinks.GET_RATES)
    public ResponseEntity<?> getRates(){
        List<Rate> rates = ratesService.getRates();
        return ResponseEntity.ok(rates);
    }

    @GetMapping(path = ApiLinks.GET_RATE_HISTORY)
    public ResponseEntity<?> getRateHistory(@RequestParam String ccy){
        List<RateHis> ratesHis = ratesHistoryService.getHistory(ccy);
        return ResponseEntity.ok(ratesHis);
    }

    @GetMapping(path = ApiLinks.GET_CURRENCIES)
    public ResponseEntity<?> getCurrencies(){
        List<Currency> currencies = currenciesService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    @GetMapping(path = ApiLinks.SYNC_DATA)
    public ResponseEntity<?> updateRates(){
        try {
            syncService.syncCurrencies();
            syncService.syncRates();
            Thread.sleep(1000);
            syncService.syncHistory();
        } catch (JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Successfully synchronised");
    }

}
