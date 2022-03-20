USE `Shopping_mall`;
/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` CHAR(30) NOT NULL,
  `name` CHAR(50) NOT NULL,
  `kind` VARCHAR(50) NOT NULL,
  `detail` CHAR(50) NOT NULL,
  `price` CHAR(30) NOT NULL,
  `num` VARCHAR(30) NOT NULL,
  `date` DATE NOT NULL,
  `time` CHAR(30) NOT NULL
) ENGINE=INNODB CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

DATA FOR the TABLE `user`
INSERT INTO `goods` VALUES('18378650345','立白','生活用品','洗衣液','10','1','2020-12-23','16:08:50');
INSERT INTO `goods` VALUES('201201421715','哑铃','生活用品','健身器材','20','2','2020-12-23','16:01:50');
INSERT INTO `goods` VALUES('201702530955','枕头','生活用品','床上用品','15','1','2020-12-23','14:08:50'); 
INSERT INTO `goods` VALUES('201801420715','挂钩','生活用品','床上用品','15','1','2020-12-23','16:18:50'); 
INSERT INTO `goods` VALUES('201801468430','枕头','生活用品','床上用品','10','1','2020-12-23','12:08:50'); 
INSERT INTO `goods` VALUES('201801468430','棉衣','生活用品','衣服','15','1','2020-12-23','11:08:50'); 
INSERT INTO `goods` VALUES('201849120715','华为手机','电子产品','手机','1500','1','2020-12-23','10:08:50'); 
INSERT INTO `goods` VALUES('201956797537','小米电脑','电子产品','电脑','2000','1','2020-12-23','16:09:50');
INSERT INTO `goods` VALUES('202001520818','拍立得相机','电子产品','相机','500','1','2020-12-23','12:02:50');
INSERT INTO `goods` VALUES('202001520818','华为电脑','电子产品','电脑','1500','1','2020-12-23','16:08:30');
INSERT INTO `goods` VALUES('201907865489','游戏机','电子产品','手机','1500','1','2020-12-23','16:04:20');
INSERT INTO `goods` VALUES('202002425735','自动走珠笔','学习用品','笔','5','1','2020-12-23','16:12:50');
INSERT INTO `goods` VALUES('201801468430','如何考研','学习用品','考研资料','5000','1','2020-12-23','12:15:50');
INSERT INTO `goods` VALUES('201801420840','大学如何规划','学习用品','学习资料','500','1','2020-12-23','11:02:50');
INSERT INTO `goods` VALUES('201702530955','活着','学习用品','书籍','50','1','2020-12-23','12:08:40');
INSERT INTO `goods` VALUES('201801420715','自动走珠笔','学习用品','笔','5','10','2020-12-23','9:08:50');
INSERT INTO `goods` VALUES('201601820718','玫瑰花99','其他分类','其他','300','1','2020-12-23','9:09:50');
INSERT INTO `goods` VALUES('201201421715','空气清新剂','其他分类','其他','300','1','2020-12-23','10:05:50');
INSERT INTO `goods` VALUES('201201421715','墙贴','其他分类','其他','300','1','2020-12-23','14:13:50');
INSERT INTO `goods` VALUES('201907865489','坐垫99','其他分类','其他','360','1','2020-12-23','12:02:58');
INSERT INTO `goods` VALUES('201801420840','撑衣竿','其他分类','其他','30','1','2020-12-23','12:13:35');

	 
