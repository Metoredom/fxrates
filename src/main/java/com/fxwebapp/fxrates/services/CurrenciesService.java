package com.fxwebapp.fxrates.services;

import com.fxwebapp.fxrates.beans.CcyTbl;
import com.fxwebapp.fxrates.entities.Currency;
import com.fxwebapp.fxrates.repositories.CurrenciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrenciesService {

    private final CurrenciesRepository currenciesRepository;

    public CurrenciesService(CurrenciesRepository currenciesRepository){
        this.currenciesRepository = currenciesRepository;
    }

    public List<Currency> getAllCurrencies(){
        return currenciesRepository.findAll();
    }

    public List<Currency> saveCurrencies(CcyTbl table){
        currenciesRepository.deleteAll();
        return currenciesRepository.saveAll(table.toEntityList());
    }

}
