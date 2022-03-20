
USE `Shopping_mall`;
DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` CHAR(30) NOT NULL,
  `goodsName` CHAR(50) NOT NULL,
  `kind` VARCHAR(50) NOT NULL,
  `name` CHAR(30) NOT NULL,
  `phone` CHAR(30) NOT NULL,
  `price` CHAR(30) NOT NULL,
  `num` VARCHAR(30) NOT NULL
) ENGINE=INNODB CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;