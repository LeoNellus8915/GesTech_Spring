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
-- Table structure for table `ty_linguaggi`
--

DROP TABLE IF EXISTS `ty_linguaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ty_linguaggi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ty_linguaggi`
--

LOCK TABLES `ty_linguaggi` WRITE;
/*!40000 ALTER TABLE `ty_linguaggi` DISABLE KEYS */;
INSERT INTO `ty_linguaggi` VALUES (1,'cobol'),(2,'php'),(3,'java'),(4,'java BE'),(5,'java FE'),(6,'J2EE'),(7,'spring'),(8,'struts'),(9,'.net c#'),(10,'.net vb.net'),(11,'c'),(12,'c++'),(13,'web'),(14,'pl/sql'),(15,'tsql'),(16,'hibernate'),(17,'angular js'),(18,'mysql'),(19,'sviluppo'),(20,'testing'),(21,'uml'),(22,'devops'),(23,'agile'),(24,'micro servizi'),(25,'scrum'),(26,'unix'),(27,'linux'),(28,'microsoft'),(29,'mvs'),(30,'db2'),(31,'oracle'),(32,'sql server'),(33,'mongodb'),(34,'distribuiti/ass-tecnica'),(35,'sna'),(36,'cisco'),(37,'tcp'),(38,'voip'),(39,'tlc'),(40,'abap'),(41,'sap'),(42,'microstrategy'),(43,'powercenter'),(44,'bo'),(45,'datastage'),(46,'qlikview'),(47,'qliksense'),(48,'siebel'),(49,'salesforce'),(50,'tibco'),(51,'bea'),(52,'jboss'),(53,'websphere'),(54,'broadcasting');
/*!40000 ALTER TABLE `ty_linguaggi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-12 15:34:42
