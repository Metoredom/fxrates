package com.fxwebapp.fxrates.beans;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "FxRate")
@XmlAccessorType(XmlAccessType.FIELD)
public class FxRate {

    @Getter
    @Setter
    @XmlElement(name = "Tp")
    private String tp;

    @Getter
    @Setter
    @XmlElement(name = "Dt")
    private Date dt;

    @Getter
    @Setter
    @XmlElement(name = "CcyAmt")
    private List<CcyAmt> ccyAmtList;

}
