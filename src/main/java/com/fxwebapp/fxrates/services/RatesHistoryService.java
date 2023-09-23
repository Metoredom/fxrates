package com.fxwebapp.fxrates.services;

import com.fxwebapp.fxrates.entities.RateHis;
import com.fxwebapp.fxrates.repositories.RatesHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatesHistoryService {

    private final RatesHistoryRepository historyRepository;

    public RatesHistoryService(RatesHistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    public List<RateHis> getHistory(String ccy){
        List<RateHis> rates = historyRepository.findByCcyTo(ccy);
        return rates;
    }

    public List<RateHis> saveHistoryRates(List<RateHis> rateHisList){
        historyRepository.deleteAll();
        return historyRepository.saveAll(rateHisList);
    }

}
