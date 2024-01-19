package demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "STOCK_DATA_1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockData1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "INDEX_DUMMY")
    private String indexDummy;
    @Column(name = "CREATION_TIMESTAMP")
    private Timestamp creationTimestamp;
}
