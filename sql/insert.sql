CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_66gkcp94endmotfwb8r4ocxm9` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) NOT NULL,
  `destination_account_number` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `request_id` varchar(255) NOT NULL,
  `requester` varchar(255) NOT NULL,
  `source_account_number` varchar(255) NOT NULL,
  `transaction_time` varchar(255) NOT NULL,
  `transaction_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qsel5ry62xhf2co7lg3wdalgw` (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO account (name, address, account_number, balance, status)
VALUES ("acc001", "Gulshan-1, Dhaka", "001241009211439", "5000.00", 0);

INSERT INTO account (name, address, account_number, balance, status)
VALUES ("acc002", "Gulshan-2, Dhaka", "32341200923487", "5000.00", 0);

INSERT INTO account (name, address, account_number, balance, status)
VALUES ("acc003", "Dhanmondi-27, Dhaka", "123456789123456", "5000.00", 0);
