package com.fxwebapp.fxrates.beans;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CcyAmt")
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyAmt {

    @XmlElement(name = "Ccy")
    public String ccy;
    @XmlElement(name = "Amt")
    public float amt;

}
