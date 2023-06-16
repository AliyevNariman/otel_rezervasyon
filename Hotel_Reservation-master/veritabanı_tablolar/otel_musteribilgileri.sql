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
-- Table structure for table `musteribilgileri`
--

DROP TABLE IF EXISTS `musteribilgileri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musteribilgileri` (
  `MusteriID` int NOT NULL AUTO_INCREMENT,
  `MusteriTC` varchar(11) DEFAULT NULL,
  `MusteriAdi` varchar(20) NOT NULL,
  `MusteriSoyadi` varchar(20) NOT NULL,
  `MusteriTel` varchar(15) DEFAULT NULL,
  `MusteriParola` varchar(20) DEFAULT NULL,
  `MusteriMail` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`MusteriID`),
  UNIQUE KEY `MusteriTC` (`MusteriTC`),
  UNIQUE KEY `MusteriMail` (`MusteriMail`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteribilgileri`
--

LOCK TABLES `musteribilgileri` WRITE;
/*!40000 ALTER TABLE `musteribilgileri` DISABLE KEYS */;
INSERT INTO `musteribilgileri` VALUES (6,'0123456789','Sevket','Guney','1234567890','Adalet06','sevket.guney@hotmail.com'),(7,'12312093812','sevket','guney','12312093812','sevket','sevket@sevket.com'),(8,'12121212121','Şevket','Güney','5555555555','Ankara74','guney.sevket@adalet.gov.tr'),(10,'5555555555','Şevket','Güney','11111111111','Adalet06','seiko@hotmail.com'),(25,'49394949394','osman','ülger','55555555','Adalet06','osmanulger@hotmail.com'),(26,'30240304','ankara','ankara','1111','111','aaaaa@aaaa'),(27,'949494994','Şevket','Güney','33203030','Adalet06','seiko@seiko.com'),(28,'8383838','ankara','ankara','11','ankara','ankara@ankara'),(29,'11111111199','sevket','guney','333','1212','sevketsekvket@ada');
/*!40000 ALTER TABLE `musteribilgileri` ENABLE KEYS */;
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
