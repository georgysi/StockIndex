package demo.rest;

import com.google.gson.Gson;
import demo.response.stockDataResponse;
import demo.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "v1")
public class APIController {

    @Autowired
    private demo.service.StockService stockService;
    @GetMapping(path = "/{stockId}")
    public ResponseEntity<stockDataResponse> getStockPrice(@PathVariable("stockId") String stockId) throws Exception {

        // return ResponseEntity.status(HttpStatus.OK)
        //       .body(new Gson().toJson(this.stockService.getPrice(stockId)));
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.stockService.getPrice(stockId));
    }
    @Autowired
    private IndexService indexService;

    @GetMapping(path = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllAlerts() throws Exception {

        return ResponseEntity.
                status(HttpStatus.OK).
                body(new Gson().toJson(
                        this.indexService.getAllIndex())
                );

    }

    @GetMapping(path = "/stocks/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllAlertsByName(@PathVariable String name) throws Exception {

        return ResponseEntity.
                status(HttpStatus.OK).
                body(new Gson().toJson(
                        this.indexService.getAllByName(name))
                );

    }


}
