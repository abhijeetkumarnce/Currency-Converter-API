package com.week4.currencyconverter.entities;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyApiResponse {

    private Map<String, Double> data;
}
