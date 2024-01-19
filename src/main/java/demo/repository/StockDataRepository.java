package demo.repository;

import demo.dao.entity.StockData;

import demo.dao.entity.StockData1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * StockData1Repository
 * CRUD repository for {@link StockData1} entity basic DB operations
 *
 * @author Gera
 * @version POC
 * @since Dec 08,2023
 */
@Repository
public interface StockDataRepository extends CrudRepository<StockData, String> {

    Iterable<StockData> findByStockName(String stockName);

}
