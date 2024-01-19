package demo.service.impl;

import demo.dao.entity.StockData;
import demo.repository.StockDataRepository;
import demo.response.stockDataResponse;
import demo.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import demo.response.responseConverter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
@Slf4j
public class StockServiceImpl implements StockService{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private responseConverter rConverter;
    // @Autowired
    private stockDataResponse sdResponse;
    //@Autowired
    //private StockData stockdata;

    @Value("${quot.url}")
    private String apiUrl;

    @Autowired
    StockDataRepository sdRep;
    @Override
    public stockDataResponse getPrice(String stockId) throws Exception  {
        System.out.print("GEORGY IMPL ALERT******************************" + stockId );
        LocalDateTime now = LocalDateTime.now();
        StockData stockdata = new StockData();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.print("GEORGY U   R   L  " + apiUrl );

        try {
            String responce = restTemplate.getForObject(apiUrl + "/" + stockId + "_usd",String.class);


            System.out.print("GEORGY RESPONCEEEEEEEEEEEEEEEEEE   " + responce );
            String high = objectMapper.readTree(responce).get(stockId + "_usd").get("high").asText();
            String low = objectMapper.readTree(responce).get(stockId + "_usd").get("low").asText();
            String avg = objectMapper.readTree(responce).get(stockId + "_usd").get("avg").asText();
            String sell = objectMapper.readTree(responce).get(stockId + "_usd").get("sell").asText();
            //responseConverter rConverter = new responseConverter();
            sdResponse = rConverter.convertToResponse(high,low,avg,sell,stockId);
            stockdata.setHigh(high);
            stockdata.setLow(low);
            stockdata.setAvg(avg);
            stockdata.setSell(sell);
            stockdata.setStockName(stockId+"_usd");
            stockdata.setCreationTimestamp(Timestamp.valueOf(now));
            sdRep.save(stockdata);
            return sdResponse;
            //return sdResponse.getHigh() + sdResponse.getLow() + sdResponse.getAvg() + sdResponse.getSell();
        } catch (Exception e) {
            final String errorMessage = "Web Service Call Attem pt Failed : " + e.getLocalizedMessage();
            log.error(errorMessage);
            System.out.print("E  r R  O R  " + errorMessage );

        }

        return sdResponse;
    }
}