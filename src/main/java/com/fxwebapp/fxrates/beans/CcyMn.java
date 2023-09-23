package com.fxwebapp.fxrates.beans;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyMn {

    @Getter
    @Setter
    @XmlAttribute(name = "lang")
    private String lang;

    @Getter
    @Setter
    @XmlValue
    private String name;

}
