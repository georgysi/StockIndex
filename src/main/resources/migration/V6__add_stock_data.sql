use dev_stock;

drop table IF EXISTS STOCK_DATA;

#4.STOCK_DATA

create TABLE `STOCK_DATA` (
    `STOCK_NAME`         varchar(20) NOT NULL,
    `HIGH`        varchar(15),
    `LOW`        varchar(15),
    `AVG`        varchar(15),
    `SELL`        varchar(15),
    `CREATION_TIMESTAMP` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`STOCK_NAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;