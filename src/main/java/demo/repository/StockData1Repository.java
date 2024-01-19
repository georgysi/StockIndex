package demo.repository;

import demo.dao.entity.StockData1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * StockData1Repository
 * CRUD repository for {@link StockData1} entity basic DB operations
 *
 * @author Binyamin (Dima) Pyanin
 * @version POC
 * @since April 24,2023
 */
@Repository
public interface StockData1Repository extends CrudRepository<StockData1, Integer> {

    Iterable<StockData1> findByStockName(String stockName);

}
