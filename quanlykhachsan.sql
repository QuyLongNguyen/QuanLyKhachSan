-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mytestdb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `khachthue`
--

DROP TABLE IF EXISTS `khachthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachthue` (
  `MaKhach` int NOT NULL AUTO_INCREMENT,
  `SoCMT` varchar(13) NOT NULL,
  `Ten` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NamSinh` int NOT NULL,
  `SDT` char(13) NOT NULL,
  PRIMARY KEY (`MaKhach`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachthue`
--

LOCK TABLES `khachthue` WRITE;
/*!40000 ALTER TABLE `khachthue` DISABLE KEYS */;
INSERT INTO `khachthue` VALUES (3,'024435634','Long',2000,'0342147849'),(4,'024435634','Hai',2000,'0985712355'),(5,'093732934','Linh',1994,'0368847849'),(6,'083241259','Manh',1996,'0352145821'),(21,'034824','Lam',1999,'9234712'),(23,'9128734','Kiên',1999,'12324234124');
/*!40000 ALTER TABLE `khachthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaiphong`
--

DROP TABLE IF EXISTS `loaiphong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaiphong` (
  `MaLoai` int NOT NULL AUTO_INCREMENT,
  `DonGia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`MaLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaiphong`
--

LOCK TABLES `loaiphong` WRITE;
/*!40000 ALTER TABLE `loaiphong` DISABLE KEYS */;
INSERT INTO `loaiphong` VALUES (1,500),(2,400),(3,300);
/*!40000 ALTER TABLE `loaiphong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `MaPhong` int NOT NULL AUTO_INCREMENT,
  `MaLoai` int DEFAULT NULL,
  `TinhTrang` int DEFAULT NULL,
  PRIMARY KEY (`MaPhong`),
  KEY `fk_MaLoai_idx` (`MaLoai`),
  CONSTRAINT `fk_MaLoai` FOREIGN KEY (`MaLoai`) REFERENCES `loaiphong` (`MaLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (1,1,1),(2,1,1),(3,1,0),(4,1,1),(5,1,1),(6,2,0),(7,2,1),(8,3,1),(9,3,0);
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuephong`
--

DROP TABLE IF EXISTS `thuephong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuephong` (
  `MaPhieu` int NOT NULL AUTO_INCREMENT,
  `MaPhong` int NOT NULL,
  `MaKhach` int DEFAULT NULL,
  `NgayThue` datetime NOT NULL,
  `NgayTra` datetime NOT NULL,
  PRIMARY KEY (`MaPhieu`),
  KEY `fk_MaPhong_idx` (`MaPhong`),
  KEY `fk_MaKhach_idx` (`MaKhach`),
  CONSTRAINT `fk_MaKhach` FOREIGN KEY (`MaKhach`) REFERENCES `khachthue` (`MaKhach`),
  CONSTRAINT `fk_MaPhong` FOREIGN KEY (`MaPhong`) REFERENCES `phong` (`MaPhong`),
  CONSTRAINT `check_ngay` CHECK ((`NgayTra` > `NgayThue`))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuephong`
--

LOCK TABLES `thuephong` WRITE;
/*!40000 ALTER TABLE `thuephong` DISABLE KEYS */;
INSERT INTO `thuephong` VALUES (3,4,3,'2021-04-28 00:00:00','2021-05-02 00:00:00'),(4,5,4,'2021-04-29 00:00:00','2021-05-02 00:00:00'),(5,7,5,'2021-04-30 00:00:00','2021-05-03 00:00:00'),(6,8,6,'2021-04-30 00:00:00','2021-05-04 00:00:00'),(13,2,21,'2020-05-01 00:00:00','2020-05-03 00:00:00'),(14,1,23,'2021-05-03 00:00:00','2021-05-06 00:00:00');
/*!40000 ALTER TABLE `thuephong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Permission` tinyint NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `user_name_UNIQUE` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'quylong','123456',0),(2,'long','123',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-03 21:25:28
