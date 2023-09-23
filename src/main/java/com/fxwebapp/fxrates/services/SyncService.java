package com.fxwebapp.fxrates.services;

import com.fxwebapp.fxrates.beans.CcyTbl;
import com.fxwebapp.fxrates.beans.FxRates;
import com.fxwebapp.fxrates.entities.RateHis;
import com.fxwebapp.fxrates.utils.XMLUtils;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SyncService {

    @Autowired
    private RatesService ratesService;
    @Autowired
    private RatesHistoryService historyService;
    @Autowired
    private CurrenciesService currenciesService;
    @Autowired
    private LBService lbService;

    public void syncRates() throws JAXBException {
        XMLUtils xmlUtils = new XMLUtils();
        FxRates rates = xmlUtils.deserializeRatesXML(lbService.getRatesDataFromLB());
        ratesService.saveRates(rates);
    }

    public void syncHistory() throws JAXBException {
        XMLUtils xmlUtils = new XMLUtils();
        List<RateHis> rateHisList = new ArrayList<>();

        ratesService.getRates().forEach(rate -> {
            try {
                System.out.println("HIS UPLOAD FOR " + rate.getCcyTo());
                rateHisList.addAll(xmlUtils.deserializeRatesXML(lbService.getHistoryDataFromLB(rate.getCcyTo())).toRateHisEntityList());
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        });

        historyService.saveHistoryRates(rateHisList);
    }

    public void syncCurrencies() throws JAXBException {
        XMLUtils xmlUtils = new XMLUtils();
        CcyTbl table = xmlUtils.deserializeCurrenciesXML(lbService.getCurrenciesFromLB());
        currenciesService.saveCurrencies(table);
    }

}
