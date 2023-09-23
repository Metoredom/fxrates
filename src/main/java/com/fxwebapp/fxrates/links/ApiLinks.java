package com.fxwebapp.fxrates.links;

import org.springframework.stereotype.Component;

@Component
public class ApiLinks {
    final public static String GET_RATES = "/getRates";
    final public static String GET_RATE_HISTORY = "/getRateHistory";
    final public static String SYNC_DATA = "/sync";
    final public static String GET_CURRENCIES = "/getCurrencies";

}
