package demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "STOCK_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockData {
    @Id
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "HIGH")
    private String high;
    @Column(name = "LOW")
    private String low;
    @Column(name = "AVG")
    private String avg;
    @Column(name = "SELL")
    private String sell;
    @Column(name = "CREATION_TIMESTAMP")
    private Timestamp creationTimestamp;
}
