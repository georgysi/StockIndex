package demo.response;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class responseConverter {

    public  stockDataResponse convertToResponse(String ahigh, String alow, String aavg, String asell, String aId){

         return stockDataResponse.builder().high(ahigh).low(alow).avg(aavg).sell(asell).stock_name(aId).creationtimestamp((Timestamp.valueOf(LocalDateTime.now()))).build();

    }
}
