package com.week4.currencyconverter.controller;

import com.week4.currencyconverter.entities.CurrencyConversionResponse;
import com.week4.currencyconverter.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService){
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/convertCurrency")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            @RequestParam double units) {

        return ResponseEntity.ok(currencyConversionService.convert(fromCurrency, toCurrency, units));
    }
}
