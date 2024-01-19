package demo.service;

import demo.response.stockDataResponse;

import java.io.IOException;

public interface StockService {
    stockDataResponse getPrice(String stockId) throws Exception;
}