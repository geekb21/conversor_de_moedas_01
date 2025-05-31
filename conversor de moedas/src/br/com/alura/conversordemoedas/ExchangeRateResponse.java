package br.com.alura.conversordemoedas;

import java.util.Map;

public class ExchangeRateResponse {
    private String base;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}