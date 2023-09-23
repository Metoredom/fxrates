package com.fxwebapp.fxrates.beans;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "CcyNtry")
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyNtry {

    @Getter
    @Setter
    @XmlElement(name = "Ccy")
    private String ccy;

    @Getter
    @Setter
    @XmlElement(name = "CcyNm")
    private List<CcyMn> ccyNm;

    @Getter
    @Setter
    @XmlElement(name = "CcyNbr")
    private int ccyNbr;

    @Getter
    @Setter
    @XmlElement(name = "CcyMnrUnts")
    private int ccyMnrUnts;

}
