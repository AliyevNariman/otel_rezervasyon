-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: otel
-- ------------------------------------------------------
-- Server version	8.0.27


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
-- Table structure for table `rezervasyonbilgileri`
--

DROP TABLE IF EXISTS `rezervasyonbilgileri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervasyonbilgileri` (
  `RezervasyonID` int NOT NULL AUTO_INCREMENT,
  `RezervasyonBaslangicTarihi` date NOT NULL,
  `RezervasyonBitisTarihi` date NOT NULL,
  `OdaID` int NOT NULL,
  `RezervasyonDurum` int NOT NULL DEFAULT '1',
  `ToplamFiyat` double DEFAULT NULL,
  `MusteriID` int DEFAULT NULL,
  PRIMARY KEY (`RezervasyonID`),
  KEY `OdaID` (`OdaID`),
  CONSTRAINT `rezervasyonbilgileri_ibfk_1` FOREIGN KEY (`OdaID`) REFERENCES `odabilgileri` (`OdaID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervasyonbilgileri`
--

LOCK TABLES `rezervasyonbilgileri` WRITE;
/*!40000 ALTER TABLE `rezervasyonbilgileri` DISABLE KEYS */;
INSERT INTO `rezervasyonbilgileri` VALUES (1,'2021-12-31','2022-01-05',1,2,NULL,1),(2,'2021-12-31','2022-01-05',2,2,NULL,1),(3,'2022-01-15','2022-01-16',1,2,300,1),(4,'2022-01-28','2022-01-29',3,2,250,1),(5,'2022-01-15','2022-01-16',5,2,200,1),(6,'2022-01-01','2022-01-05',1,2,1200,1),(7,'2022-01-08','2022-01-16',1,1,2400,1),(8,'2022-01-04','2022-01-05',1,2,300,8),(9,'2022-01-07','2022-01-16',3,2,2250,8),(10,'2022-01-20','2022-01-22',1,2,600,8),(11,'2022-01-20','2022-01-30',7,2,4000,8),(12,'2022-01-14','2022-01-15',2,1,300,8),(13,'2022-01-15','2022-01-16',3,1,250,8),(14,'2022-01-05','2022-01-14',1,1,2700,25),(15,'2022-01-05','2022-01-07',3,2,500,28),(16,'2022-01-07','2022-01-13',3,1,1500,6);
/*!40000 ALTER TABLE `rezervasyonbilgileri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-02 20:54:02
