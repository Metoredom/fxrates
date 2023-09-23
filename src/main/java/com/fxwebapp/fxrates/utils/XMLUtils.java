package com.fxwebapp.fxrates.utils;

import com.fxwebapp.fxrates.beans.CcyTbl;
import com.fxwebapp.fxrates.beans.FxRates;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XMLUtils {

    public FxRates deserializeRatesXML(String xmlString) throws JAXBException {
        StringReader sr = new StringReader(xmlString);
        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (FxRates) unmarshaller.unmarshal(sr);
    }

    public CcyTbl deserializeCurrenciesXML(String xmlString) throws JAXBException {
        StringReader sr = new StringReader(xmlString);
        JAXBContext jaxbContext = JAXBContext.newInstance(CcyTbl.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (CcyTbl) unmarshaller.unmarshal(sr);
    }

}
