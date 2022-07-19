CREATE DATABASE  IF NOT EXISTS `gestech2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestech2`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: gestech2
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hy_avvisi`
--

DROP TABLE IF EXISTS `hy_avvisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hy_avvisi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(50) DEFAULT NULL,
  `id_risorsa` int DEFAULT NULL,
  `ruoli` varchar(100) DEFAULT NULL,
  `note` text,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hy_avvisi`
--

LOCK TABLES `hy_avvisi` WRITE;
/*!40000 ALTER TABLE `hy_avvisi` DISABLE KEYS */;
INSERT INTO `hy_avvisi` VALUES (4,'tgt',1,NULL,'fhhh','2022-07-18 00:00:00'),(5,'rdg',1,NULL,'drgdrgdrg','2022-07-18 00:00:00'),(6,'rgdg',1,NULL,'dgrdg','2022-07-18 12:51:18'),(7,'tgdr',1,'[dipendente, tutti]','gdrgdrg','2022-07-18 12:57:40'),(8,'ht',0,'[dipendente]','hfthftht','2022-07-18 20:29:58'),(9,'f',1,'[dipendente]','ntftfnf','2022-07-19 11:55:32'),(10,'hth',1,'[dipendente, tutti]','ftfhtf','2022-07-19 13:02:59'),(11,'thfhf',1,'[recruiter, commerciale]','thfthft','2022-07-19 13:09:44'),(12,'rdg',1,'[commerciale]','4grdrg','2022-07-19 16:28:20');
/*!40000 ALTER TABLE `hy_avvisi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-19 16:41:54
