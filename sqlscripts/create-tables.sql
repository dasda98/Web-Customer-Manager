CREATE TABLE `customer`
(
    `id`        INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `fist_name` VARCHAR(50) DEFAULT NULL,
    `last_name` VARCHAR(50) DEFAULT NULL,
    `email`     VARCHAR(50) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE `product`
(
    `id`    INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name`  VARCHAR(50) DEFAULT NULL,
    `price` DOUBLE      DEFAULT NULL
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `customer_product`;

CREATE TABLE `customer_product`
(
    `customer_id` INT(11) NOT NULL,
    `product_id`  INT(11) NOT NULL,

    PRIMARY KEY (`customer_id`, `product_id`),

    KEY           `FK_PRODUCT_idx` (`product_id`),

    CONSTRAINT `FK_CUSTOMER` FOREIGN KEY (`customer_id`)
        REFERENCES `customer` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`product_id`)
        REFERENCES `product` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB;
