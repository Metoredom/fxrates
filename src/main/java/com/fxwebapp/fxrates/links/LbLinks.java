package com.fxwebapp.fxrates.links;

public class LbLinks {

    final public static String GET_RATES = "https://lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU";
    final public static String GET_HISTORY = "https://lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?tp=EU&dtFrom=2015-10-01&dtTo=%s&ccy=%s";
    final public static String GET_CURRENCIES = "https://lb.lt/webservices/FxRates/FxRates.asmx/getCurrencyList";

}
