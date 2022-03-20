
USE `Shopping_mall`;
DROP TABLE IF EXISTS `my_goods`;

CREATE TABLE `my_goods` (
   `id` CHAR(30) NOT NULL,
  `name` CHAR(50) NOT NULL,
  `kind` VARCHAR(50) NOT NULL,
  `date` DATE NOT NULL,
  `time` CHAR(30) NOT NULL,
  `price` CHAR(30) NOT NULL,
  `num` VARCHAR(30) NOT NULL,
  `lastdate` DATE NOT NULL,
  `lasttime` CHAR(30) NOT NULL,
  `isexit` CHAR(10) NOT NULL
) ENGINE=INNODB CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;