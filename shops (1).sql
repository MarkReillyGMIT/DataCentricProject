-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: shops
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP DATABASE IF EXISTS `shops`;
CREATE DATABASE `shops`;
USE `shops`;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `prodName` varchar(50) DEFAULT NULL,
  `price` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sid` (`sid`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'1L Full Fat Milk',1.05),(2,1,'1L Low Fat Milk',1.20),(3,2,'1L Full Fat Milk',1.05),(4,2,'1L Low Fat Milk',1.10),(5,3,'1L Full Fat Milk',1.15),(6,3,'1L Low Fat Milk',1.20),(7,1,'Sliced Loaf (Brown)',1.70),(8,2,'Sliced Loaf (Brown)',1.65),(9,2,'Sliced Loaf (Brown)',1.70),(10,1,'Sliced Loaf (White)',1.20),(11,2,'Sliced Loaf (White)',1.20),(12,3,'Sliced Loaf (White)',1.40),(13,1,'Eggs - Half Dozen',2.20),(14,2,'Eggs - Half Dozen',2.10),(15,3,'Granola',4.10),(16,2,'Granola',3.50),(17,1,'Butter - 1lb',2.90),(18,2,'Butter - 1lb',2.90),(19,3,'Butter - 1lb',2.90),(20,1,'Sparkling Water - 1L',0.90),(21,2,'Sparkling Water - 1L',0.80),(22,2,'Sparkling Water - 1L',0.70),(23,1,'Still Water - 1L',0.70),(24,2,'Still Water - 1L',0.70),(25,3,'Still Water - 1L',0.50),(26,1,'Cheddar Cheese',2.20),(27,3,'Cheddar Cheese',4.30),(28,1,'iPhone',200.00),(29,2,'Tayto Crisps',1.00),(30,1,'Tomatoes',0.90),(31,3,'Tomatoes',1.05);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `founded` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'Tesco','1919-07-12'),(2,'Dunnes Stores','1944-03-31'),(3,'SuperValu','1968-06-27');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-01 20:56:31
