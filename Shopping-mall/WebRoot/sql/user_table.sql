/*
SQLyog Ultimate v9.62 
MySQL - 5.0.96-community-nt : Database - ch08
*********************************************************************
*/
/*
 Navicat Premium Data Transfer

 Source Server         : .
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : shopping-mall

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 21/12/2020 10:51:21
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`Shopping_mall` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `Shopping_mall`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` CHAR(30) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `name` CHAR(30) NOT NULL,
  `phone` CHAR(30) NOT NULL,
  `institute` VARCHAR(200) NOT NULL,
  `e_mail` VARCHAR(100) NOT NULL,
  PRIMARY KEY  (`id`) USING BTREE
) ENGINE=INNODB CHARSET=utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

/*Data for the table `user` */
INSERT INTO `user` VALUES('201801420715','123456','Bert','15197546322','计算机科学与工程学院','1973455781@qq.com');
INSERT INTO `user` VALUES('201801420840','123456','曾康','19174145503','计算机科学与工程学院','123456@qq.com');
INSERT INTO `user` VALUES('201801520430','111111','李一','19827614755','艺术学院','12904@qq.com');
INSERT INTO `user` VALUES('201801468430','222222','李晓','19753914757','管理学院','1957834@qq.com');
	
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
