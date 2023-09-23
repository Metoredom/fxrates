package com.fxwebapp.fxrates.services;

import com.fxwebapp.fxrates.beans.FxRates;
import com.fxwebapp.fxrates.entities.Rate;
import com.fxwebapp.fxrates.repositories.RatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatesService {

    private final RatesRepository ratesRepository;

    public RatesService(RatesRepository ratesRepository){
        this.ratesRepository = ratesRepository;
    }

    public List<Rate> getRates(){
        return ratesRepository.findAll();
    }

    public List<Rate> saveRates(List<Rate> rates){
        ratesRepository.deleteAll();
        return ratesRepository.saveAll(rates);
    }

    public List<Rate> saveRates(FxRates rates){
        ratesRepository.deleteAll();
        return ratesRepository.saveAll(rates.toRateEntityList());
    }

}
