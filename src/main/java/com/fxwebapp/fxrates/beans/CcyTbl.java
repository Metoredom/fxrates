package com.fxwebapp.fxrates.beans;

import com.fxwebapp.fxrates.entities.Currency;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CcyTbl")
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyTbl {

    @Getter
    @Setter
    @XmlElement(name = "CcyNtry")
    private List<CcyNtry> ccyNtry;

    public List<Currency> toEntityList(){
        List<Currency> list = new ArrayList<>();

        if(ccyNtry != null)
            ccyNtry.forEach(ccy -> {
                Currency ccy_tmp = new Currency();
                ccy_tmp.setCcy(ccy.getCcy());
                ccy_tmp.setName(ccy.getCcyNm().get(1).getName());
                list.add(ccy_tmp);
            });

        return list;
    }

}
