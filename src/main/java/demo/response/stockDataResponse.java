package demo.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class stockDataResponse {
    public String stock_name;
    public String high;
    public String low;
    public String avg;
    public String sell;
    public Timestamp creationtimestamp;
}
