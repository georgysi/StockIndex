package demo.service.impl;

import demo.dao.entity.StockData1;
import demo.repository.StockData1Repository;
import demo.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private StockData1Repository stockData1Repository;

    @Override
    public List<String> getAllIndex() throws Exception {
        log.info("Fetching Stock Data 1");

        final Iterator<StockData1> stockData1Iterator =
                this.stockData1Repository.findAll().iterator();

        List<String> result = new ArrayList<>();

        while (stockData1Iterator.hasNext()) {

            final StockData1 sd = stockData1Iterator.next();

            result.add(sd.toString());

        }

        log.info("Fetched {} {} Stock Data 1", result.size(), result);

        return result;

    }

    @Override
    public List<String> getAllByName(String name) throws Exception {
        log.info("Fetching Stock Data 1 By Name {}", name);

        final Iterator<StockData1> stockData1Iterator =
                this.stockData1Repository.findByStockName(name).iterator();

        List<String> result = new ArrayList<>();

        while (stockData1Iterator.hasNext()) {

            final StockData1 sd = stockData1Iterator.next();

            result.add(sd.toString());

        }

        log.info("Fetched {} {} Stock Data 1 By Name {}", result.size(), result, name);

        return result;

    }

}