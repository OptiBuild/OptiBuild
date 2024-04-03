-- MySQL dump 10.13  Distrib 5.7.24, for osx11.1 (x86_64)
--
-- Host: localhost    Database: Hardware_Components
-- ------------------------------------------------------
-- Server version	8.3.0

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

--
-- Table structure for table `CPU`
--

DROP TABLE IF EXISTS `CPU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPU` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `coreNum` int DEFAULT NULL,
  `threadNum` int DEFAULT NULL,
  `upperClock` float DEFAULT NULL,
  `lowerClock` float DEFAULT NULL,
  `socketType` varchar(100) DEFAULT NULL,
  `L3Cache` int DEFAULT NULL,
  `TDP` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPU`
--

LOCK TABLES `CPU` WRITE;
/*!40000 ALTER TABLE `CPU` DISABLE KEYS */;
INSERT INTO `CPU` VALUES (1,'Intel','Core i5-13400F',25257,10,16,2.5,4.6,'Socket 1700',20,65,185.99),(2,'AMD','Ryzen 5 7600',27263,6,12,3.8,5.1,'Socket AM5',32,65,198.99),(3,'Intel','Core i5-12600K',27749,10,16,3.7,4.9,'Socket 1700',20,125,169.99),(4,'AMD','Ryzen 5 7600X',28605,6,12,4.7,5.3,'Socket AM5',32,105,209.95),(5,'AMD','Ryzen 7 7800X3D',34399,8,16,4.2,5,'Socket AM5',96,120,357.00),(6,'AMD','Ryzen 7 7700',34620,8,16,3.8,5.3,'Socket AM5',32,65,268.04),(7,'Intel','Core i7-12700K',34664,12,20,3.6,5,'Socket 1700',25,125,224.99),(8,'AMD','Ryzen 7 7700X',36043,8,16,4.5,5.4,'Socket AM5',32,105,309.99),(9,'Intel','Core i5-13600K',38181,14,20,3.5,5.1,'Socket 1700',24,125,284.99),(10,'AMD','Ryzen 9 5900X',39197,12,24,3.7,4.8,'Socket AM4',64,105,279.00),(11,'Intel','Core i5-14600K',39322,14,20,3.5,5.3,'Socket 1700',24,125,309.99),(12,'Intel','Core i9-12900K',41377,16,24,3.2,5.2,'Socket 1700',30,125,314.99),(13,'AMD','Ryzen 9 5950X',45689,16,32,3.4,4.9,'Socket AM4',64,105,375.72),(14,'Intel','Core i7-13700K',46580,16,24,3.4,5.4,'Socket 1700',30,125,354.99),(15,'AMD','Ryzen 9 7900X',51966,12,24,4.7,5.6,'Socket AM5',64,170,383.92),(16,'Intel','Core i7-14700K',53758,20,28,3.4,5.6,'Socket 1700',33,125,389.99),(17,'Intel','Core i9-13900K',59396,24,32,3,5.8,'Socket 1700',36,125,499.99),(18,'Intel','Core i9-14900K',61058,24,32,3.2,6,'Socket 1700',36,125,529.99),(19,'AMD','Ryzen 9 7950X3D',62598,16,32,4.2,5.7,'Socket AM5',128,120,580.71),(20,'AMD','Ryzen 9 7950X',62983,16,32,4.5,5.7,'Socket AM5',64,170,549.99);
/*!40000 ALTER TABLE `CPU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CPUCooler`
--

DROP TABLE IF EXISTS `CPUCooler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPUCooler` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `size` int DEFAULT NULL,
  `height` int DEFAULT NULL,
  `RGB` tinyint(1) DEFAULT NULL,
  `addressable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPUCooler`
--

LOCK TABLES `CPUCooler` WRITE;
/*!40000 ALTER TABLE `CPUCooler` DISABLE KEYS */;
/*!40000 ALTER TABLE `CPUCooler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CPUCooler_SocketCompatiblity`
--

DROP TABLE IF EXISTS `CPUCooler_SocketCompatiblity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPUCooler_SocketCompatiblity` (
  `cooler_id` bigint NOT NULL,
  `compatibility_id` bigint NOT NULL,
  PRIMARY KEY (`cooler_id`,`compatibility_id`),
  KEY `compatibility_id` (`compatibility_id`),
  CONSTRAINT `cpucooler_socketcompatiblity_ibfk_1` FOREIGN KEY (`cooler_id`) REFERENCES `CPUCooler` (`id`),
  CONSTRAINT `cpucooler_socketcompatiblity_ibfk_2` FOREIGN KEY (`compatibility_id`) REFERENCES `SocketCompatibility` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPUCooler_SocketCompatiblity`
--

LOCK TABLES `CPUCooler_SocketCompatiblity` WRITE;
/*!40000 ALTER TABLE `CPUCooler_SocketCompatiblity` DISABLE KEYS */;
/*!40000 ALTER TABLE `CPUCooler_SocketCompatiblity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_requirement`
--

DROP TABLE IF EXISTS `game_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_requirement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pc_requirements` text,
  `os` varchar(255) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `memory` int DEFAULT NULL,
  `graphics` varchar(255) DEFAULT NULL,
  `directx` varchar(255) DEFAULT NULL,
  `network` varchar(255) DEFAULT NULL,
  `storage` int DEFAULT NULL,
  `sound_card` varchar(255) DEFAULT NULL,
  `additional_notes` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_requirement`
--

LOCK TABLES `game_requirement` WRITE;
/*!40000 ALTER TABLE `game_requirement` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GPU`
--

DROP TABLE IF EXISTS `GPU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GPU` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `codaCoreNum` int DEFAULT NULL,
  `baseClock` int DEFAULT NULL,
  `boostClock` int DEFAULT NULL,
  `memory` int DEFAULT NULL,
  `memoryClock` int DEFAULT NULL,
  `requestSystemPower` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GPU`
--

LOCK TABLES `GPU` WRITE;
/*!40000 ALTER TABLE `GPU` DISABLE KEYS */;
INSERT INTO `GPU` VALUES (3,'NVIDIA','GeForce RTX 4090',38765,16384,2230000,2520000,24,1313,850,304,1599.00),(4,'NVIDIA','GeForce RTX 4090 D',29414,14592,2280000,0,0,0,0,0,0.00),(5,'NVIDIA','GeForce RTX 4080 SUPER',34344,10240,2290000,2550000,16,1438,750,304,999.00),(6,'NVIDIA','GeForce RTX 4080',34656,9728,2210000,2510000,16,1400,750,304,999.00),(7,'NVIDIA','GeForce RTX 4070 Ti SUPER',31805,8448,2340000,2610000,16,1313,700,0,799.99),(8,'NVIDIA','GeForce RTX 4070 Ti',31750,7680,2310000,2610000,12,1313,700,0,719.99),(9,'NVIDIA','GeForce RTX 4070 SUPER',30343,7168,1980000,2480000,12,1313,650,244,589.99),(10,'NVIDIA','GeForce RTX 4070',27003,5888,1920000,2480000,12,1313,650,244,529.99),(11,'NVIDIA','GeForce RTX 4060 Ti 16 GB',22971,4352,2310000,2540000,16,2250,550,244,449.99),(12,'NVIDIA','GeForce RTX 4060 Ti 8 GB',22899,4352,2310000,2540000,8,2250,550,244,399.00),(13,'NVIDIA','GeForce RTX 4060',19689,3072,1830000,2460000,8,2125,550,0,289.99),(14,'NVIDIA','GeForce RTX 4050',0,2560,2500000,0,6,2250,0,0,0.00),(15,'NVIDIA','GeForce RTX 3090 Ti',29786,10752,1560000,1860000,24,1313,850,12,1999.99),(16,'NVIDIA','GeForce RTX 3090',26832,10496,1400000,1700000,24,1314,750,12,1499.00),(17,'NVIDIA','GeForce RTX 3080 Ti',27253,10240,1370000,1670000,12,1188,750,11,1099.99),(18,'NVIDIA','GeForce RTX 3080(16GB)',0,8960,0,1810000,16,1188,750,11,999.99),(19,'NVIDIA','GeForce RTX 3080(12GB)',26744,0,0,1725000,12,1189,0,0,948.21),(20,'NVIDIA','GeForce RTX 3080(10GB)',25330,0,0,1905000,10,1190,0,0,862.03),(21,'NVIDIA','GeForce RTX 3070 Ti',23686,6144,1580000,1770000,8,1188,750,10,599.99),(22,'NVIDIA','GeForce RTX 3070',22431,5888,1500000,1730000,8,1750,650,9,399.99),(23,'NVIDIA','GeForce RTX 3060 Ti',20568,4864,1410000,1670000,8,1188,600,9,379.99),(24,'NVIDIA','GeForce RTX 3060',15541,3584,1320000,1780000,12,1875,550,0,269.99),(25,'NVIDIA','GeForce RTX 3060 (12 GB)',17095,3584,1320000,1780000,12,1875,550,0,279.99),(26,'NVIDIA','GeForce RTX 3050(8 GB)',0,2560,1550000,1780000,8,1750,550,0,219.99),(27,'NVIDIA','GeForce RTX 3050(6 GB)',12880,2304,1040000,1470000,6,1750,300,0,169.99),(28,'AMD','Radeon RX 7900 XTX',0,0,0,0,0,0,0,0,0.00),(29,'AMD','Radeon RX 7900 XT',30977,0,0,0,0,0,0,0,899.00),(30,'AMD','Radeon RX 6950 XT',28906,0,0,0,0,0,0,0,699.00),(31,'AMD','Radeon RX 6900 XT',28367,0,0,0,0,0,0,0,779.00),(32,'AMD','Radeon RX 6800 XT',26866,0,0,0,0,0,0,0,529.00),(33,'AMD','Radeon RX 7800 XT',25103,0,0,0,0,0,0,0,439.00),(34,'AMD','Radeon RX 6800',24042,0,0,0,0,0,0,0,489.00),(35,'AMD','Radeon RX 7700 XT',22330,0,0,0,0,0,0,0,389.00),(36,'AMD','Radeon RX 6750 XT',21191,0,0,0,0,0,0,0,399.00),(37,'AMD','Radeon RX 6700 XT',20834,0,0,0,0,0,0,0,329.00),(38,'AMD','Radeon RX 6700',19881,0,0,0,0,0,0,0,329.00),(39,'AMD','Radeon RX 6650 XT',18611,0,0,0,0,0,0,0,229.00),(40,'AMD','Radeon RX 7600 XT',17322,0,0,0,0,0,0,0,229.00),(41,'AMD','Radeon RX 5700 XT',16905,0,0,0,0,0,0,0,329.00),(42,'AMD','Radeon RX 6600 XT',16696,0,0,0,0,0,0,0,286.00),(43,'AMD','Radeon RX 7600',16464,0,0,0,0,0,0,0,229.00),(44,'AMD','Radeon RX 6600',16261,0,0,0,0,0,0,0,259.00),(45,'AMD','Radeon RX 5700',15130,0,0,0,0,0,0,0,199.00),(46,'','',14521,0,0,0,0,0,0,0,239.00);
/*!40000 ALTER TABLE `GPU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HardDrives`
--

DROP TABLE IF EXISTS `HardDrives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HardDrives` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `formFactor` float DEFAULT NULL,
  `hdInterface` varchar(255) DEFAULT NULL,
  `NVMe` tinyint(1) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HardDrives`
--

LOCK TABLES `HardDrives` WRITE;
/*!40000 ALTER TABLE `HardDrives` DISABLE KEYS */;
INSERT INTO `HardDrives` VALUES (94,'HDD','4TB,8TB',3.5,'SATA III',4,'Seagate','FireCuda HDD',101.00),(95,'HDD','500GB, 1TB, 2TB, 4TB, 6TB, 8TB, 10TB',3.5,'SATA III',4,'WD','Black HDD',76.99),(96,'HDD','500GB, 1TB, 3TB',3.5,'SATA III',4,'WD','Blue HDD',30.85),(97,'HDD','2TB, 4TB, 6TB, 8TB, 10TB, 12TB, 14TB, 16TB, 18TB, 20TB, 22TB',3.5,'SATA III',4,'Seagate','IronWolf Pro HDD',110.19),(98,'HDD','2TB, 4TB, 6TB, 8TB, 10TB, 12TB, 14TB, 16TB, 18TB, 20TB, 22TB',3.5,'SATA III',4,'WD','Red Pro HDD',400.99),(99,'HDD','4TB, 6TB, 8TB, 10TB, 12TB, 14TB, 16TB, 18TB, 20TB',3.5,'SATA III',4,'Toshiba','N300 Pro ',186.64),(100,'SSD','4TB, 2TB, 1TB',2280,'M.2',0,'WD','BLACK SN850X NVMe',94.99),(101,'SSD','2TB, 1TB',2280,'M.2',0,'Samsung','990 EVO',94.99),(102,'SSD','2TB, 1TB, 512GB, 480GB, 256GB, 240GB',2.5,'SATA III',3,'Team Group','T-FT-FORCE VULCAN Z',54.99),(103,'SSD','2TB, 1TB, 512GB, 480GB, 256GB, 240GB',2.5,'SATA III',3,'Team Group','CX2',57.99),(104,'SSD','1TB, 500GB, 250GB',2280,'M.2',0,'Samsung','980',99.99);
/*!40000 ALTER TABLE `HardDrives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HDD`
--

DROP TABLE IF EXISTS `HDD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HDD` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hardDriveId` bigint DEFAULT NULL,
  `maxTransferRate` int DEFAULT NULL,
  `cache` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hardDriveId` (`hardDriveId`),
  CONSTRAINT `hdd_ibfk_1` FOREIGN KEY (`hardDriveId`) REFERENCES `HardDrives` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HDD`
--

LOCK TABLES `HDD` WRITE;
/*!40000 ALTER TABLE `HDD` DISABLE KEYS */;
/*!40000 ALTER TABLE `HDD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAM`
--

DROP TABLE IF EXISTS `RAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAM` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `DDRVersion` int DEFAULT NULL,
  `stickNum` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  `clockSpeed` int DEFAULT NULL,
  `voltage` decimal(5,2) DEFAULT NULL,
  `RGB` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAM`
--

LOCK TABLES `RAM` WRITE;
/*!40000 ALTER TABLE `RAM` DISABLE KEYS */;
INSERT INTO `RAM` VALUES (32,'G. Skill ','Trident Z5 Neo RGB',117.99,5,2,16,6000,1.35,1),(33,'G. Skill ','Trident Z5 RGB',199.97,5,2,16,6000,1.30,1),(34,'Samsung','',109.00,5,2,16,4800,1.10,0),(35,'TeamGroup','T-Force Xtreem ARGB',84.99,4,2,8,3600,1.45,0),(36,'Patriot','ViperSteel',339.99,4,2,8,4400,1.45,0),(37,'Corsair','Vengeance RGB Pro',377.39,4,4,8,3200,1.35,1),(38,'G. Skill ','Trident Z Neo',89.99,4,2,16,3600,1.35,0),(39,'Corsair','Vengeance LPX',49.99,4,2,8,2666,1.20,0),(40,'OLOy','Blade',175.99,5,2,32,6000,1.40,0),(41,'Crucial','Pro',114.99,5,2,16,5600,1.10,0),(42,'Crucial','Pro',159.99,5,2,24,5600,1.10,0),(43,'Crucial','Pro',179.99,5,2,32,5600,1.10,0),(44,'Crucial','Pro',264.99,5,2,48,5600,1.10,0),(45,'Crucial ','Pro',56.99,4,2,16,3200,1.20,0),(46,'Crucial ','Pro',114.99,5,2,32,3200,1.20,0),(47,'OLOy','Blade',169.99,5,2,16,7800,1.45,1),(48,'OLOy','Blade',149.99,5,2,16,7600,1.45,1),(49,'OLOy','Blade',99.99,5,2,16,6400,1.35,1),(50,'OLOy','Blade',95.99,5,2,16,6000,1.35,1);
/*!40000 ALTER TABLE `RAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SocketCompatibility`
--

DROP TABLE IF EXISTS `SocketCompatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SocketCompatibility` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `socketType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SocketCompatibility`
--

LOCK TABLES `SocketCompatibility` WRITE;
/*!40000 ALTER TABLE `SocketCompatibility` DISABLE KEYS */;
/*!40000 ALTER TABLE `SocketCompatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SSD`
--

DROP TABLE IF EXISTS `SSD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SSD` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hardDriveId` bigint DEFAULT NULL,
  `maxSequentialRead` int DEFAULT NULL,
  `maxSequentialWrite` int DEFAULT NULL,
  `memoryComponent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hardDriveId` (`hardDriveId`),
  CONSTRAINT `ssd_ibfk_1` FOREIGN KEY (`hardDriveId`) REFERENCES `HardDrives` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SSD`
--

LOCK TABLES `SSD` WRITE;
/*!40000 ALTER TABLE `SSD` DISABLE KEYS */;
/*!40000 ALTER TABLE `SSD` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-04  4:51:32
