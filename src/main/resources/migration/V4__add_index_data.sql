use dev_stock;

drop table IF EXISTS STOCK_DATA_1;

#4.STOCK_DATA_1

create TABLE `STOCK_DATA_1` (
    `ID`                 int NOT NULL AUTO_INCREMENT,
    `STOCK_NAME`         varchar(20) NOT NULL,
    `INDEX_DUMMY`        varchar(15),
    `CREATION_TIMESTAMP` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;