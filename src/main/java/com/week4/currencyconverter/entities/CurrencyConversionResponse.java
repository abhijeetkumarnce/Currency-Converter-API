package com.week4.currencyconverter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyConversionResponse {

    private String from;
    private String to;
    private double units;
    private double convertedAmount;
}
