package com.fxwebapp.fxrates.beans;

import com.fxwebapp.fxrates.entities.Rate;
import com.fxwebapp.fxrates.entities.RateHis;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "FxRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class FxRates {

    @Getter
    @Setter
    @XmlElement(name = "FxRate")
    private List<FxRate> rates;

    public List<Rate> toRateEntityList(){
        List<Rate> list = new ArrayList<>();

        if(rates != null)
            rates.forEach(rate -> {
                Rate rate_tmp = new Rate();
                rate_tmp.setDate(rate.getDt());
                rate_tmp.setCcyFrom(rate.getCcyAmtList().get(0).ccy);
                rate_tmp.setCcyTo(rate.getCcyAmtList().get(1).ccy);
                rate_tmp.setRate(rate.getCcyAmtList().get(1).amt);
                list.add(rate_tmp);
            });

        return list;
    }

    public List<RateHis> toRateHisEntityList(){
        List<RateHis> list = new ArrayList<>();
        if(rates != null)
            rates.forEach(rate -> {
                RateHis rate_tmp = new RateHis();
                rate_tmp.setDate(rate.getDt());
                rate_tmp.setCcyFrom(rate.getCcyAmtList().get(0).ccy);
                rate_tmp.setCcyTo(rate.getCcyAmtList().get(1).ccy);
                rate_tmp.setRate(rate.getCcyAmtList().get(1).amt);
                list.add(rate_tmp);
            });

        return list;
    }
}
