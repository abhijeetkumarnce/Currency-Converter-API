package com.week4.currencyconverter.service;

import com.week4.currencyconverter.entities.CurrencyApiResponse;
import com.week4.currencyconverter.entities.CurrencyConversionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConversionService {

    @Value("${currency.api.key}")
    private String apiKey;

    @Value("${currency.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public CurrencyConversionResponse convert(String fromCurrency, String toCurrency, double units) {

        String url = apiUrl +
                "?apikey=" + apiKey +
                "&base_currency=" + fromCurrency +
                "&currencies=" + toCurrency;

        ResponseEntity<CurrencyApiResponse> response = restTemplate
                .getForEntity(url, CurrencyApiResponse.class);

        Double rate = response.getBody().getData().get(toCurrency);

        double convertedAmount = units * rate;

        return new CurrencyConversionResponse(fromCurrency, toCurrency, units, convertedAmount);
    }
}
