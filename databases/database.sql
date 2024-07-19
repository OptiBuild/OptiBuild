-- MySQL dump 10.13  Distrib 8.3.0, for Win64 (x86_64)
--
-- Host: localhost    Database: hardware_components
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `computercase`
--

DROP TABLE IF EXISTS `computercase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computercase` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `drive_bays35` int NOT NULL,
  `drive_bays25` int NOT NULL,
  `maxgpulength` int DEFAULT NULL,
  `maxcpucooler_height` int DEFAULT NULL,
  `maxpsulength` int DEFAULT NULL,
  `dimension` varchar(255) NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computercase`
--

LOCK TABLES `computercase` WRITE;
/*!40000 ALTER TABLE `computercase` DISABLE KEYS */;
INSERT INTO `computercase` VALUES (1,'Phanteks','Enthoo PRO 2','ATX Full Tower',149.99,12,11,503,195,254,'22.83\" x 9.45\" x 22.05\"',28.7),(2,'Corsair','4000D Airflow','ATX Mid Tower',104.99,2,2,360,170,180,'18.35\" x 9.06\" x 17.83\"',17.31),(3,'Fractal Design','Focus G Mini','m-ATX',54.99,2,1,380,165,230,'15.07\" x 8.07\" x 18.27\"',9.04),(4,'Thermaltake','Tower 100 Black Edition','ITX',89.99,2,2,330,190,180,'18.2\" x 10.5\" x 10.5\"',13.45);
/*!40000 ALTER TABLE `computercase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computercase_formfactorcompatibility`
--

DROP TABLE IF EXISTS `computercase_formfactorcompatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computercase_formfactorcompatibility` (
  `case_id` bigint NOT NULL,
  `form_factor_type_id` bigint NOT NULL,
  PRIMARY KEY (`case_id`,`form_factor_type_id`),
  KEY `form_factor_type_id` (`form_factor_type_id`),
  CONSTRAINT `computercase_formfactorcompatibility_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `computercase` (`id`),
  CONSTRAINT `computercase_formfactorcompatibility_ibfk_2` FOREIGN KEY (`form_factor_type_id`) REFERENCES `form_factor_compatibility` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computercase_formfactorcompatibility`
--

LOCK TABLES `computercase_formfactorcompatibility` WRITE;
/*!40000 ALTER TABLE `computercase_formfactorcompatibility` DISABLE KEYS */;
INSERT INTO `computercase_formfactorcompatibility` VALUES (1,1),(2,1),(1,2),(2,2),(3,2),(1,3),(2,3),(1,4),(2,4),(3,4),(4,4),(1,5),(2,5),(1,6);
/*!40000 ALTER TABLE `computercase_formfactorcompatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpu`
--

DROP TABLE IF EXISTS `cpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `score` int NOT NULL,
  `core_num` int NOT NULL,
  `thread_num` int NOT NULL,
  `lower_clock` float NOT NULL,
  `upper_clock` float NOT NULL,
  `L3Cache` int NOT NULL,
  `TDP` int NOT NULL,
  `price` double NOT NULL,
  `socket_id` bigint NOT NULL,
  `socket_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu`
--

LOCK TABLES `cpu` WRITE;
/*!40000 ALTER TABLE `cpu` DISABLE KEYS */;
INSERT INTO `cpu` VALUES (1,'Intel','Core i5-13400F',25257,10,16,2.5,4.6,20,65,185.99,4,'Intel LGA 1700'),(2,'AMD','Ryzen 5 7600',27263,6,12,3.8,5.1,32,65,198.99,10,'AMD AM5'),(3,'Intel','Core i5-12600K',27749,10,16,3.7,4.9,20,125,169.99,4,'Intel LGA 1700'),(4,'AMD','Ryzen 5 7600X',28605,6,12,4.7,5.3,32,105,209.95,10,'AMD AM5'),(5,'AMD','Ryzen 7 7800X3D',34399,8,16,4.2,5,96,120,357,10,'AMD AM5'),(6,'AMD','Ryzen 7 7700',34620,8,16,3.8,5.3,32,65,268.04,10,'AMD AM5'),(7,'Intel','Core i7-12700K',34664,12,20,3.6,5,25,125,224.99,4,'Intel LGA 1700'),(8,'AMD','Ryzen 7 7700X',36043,8,16,4.5,5.4,32,105,309.99,10,'AMD AM5'),(9,'Intel','Core i5-13600K',38181,14,20,3.5,5.1,24,125,284.99,4,'Intel LGA 1700'),(10,'AMD','Ryzen 9 5900X',39197,12,24,3.7,4.8,64,105,279,9,'AMD AM4'),(11,'Intel','Core i5-14600K',39322,14,20,3.5,5.3,24,125,309.99,4,'Intel LGA 1700'),(12,'Intel','Core i9-12900K',41377,16,24,3.2,5.2,30,125,314.99,4,'Intel LGA 1700'),(13,'AMD','Ryzen 9 5950X',45689,16,32,3.4,4.9,64,105,375.72,9,'AMD AM4'),(14,'Intel','Core i7-13700K',46580,16,24,3.4,5.4,30,125,354.99,4,'Intel LGA 1700'),(15,'AMD','Ryzen 9 7900X',51966,12,24,4.7,5.6,64,170,383.92,10,'AMD AM5'),(16,'Intel','Core i7-14700K',53758,20,28,3.4,5.6,33,125,389.99,4,'Intel LGA 1700'),(17,'Intel','Core i9-13900K',59396,24,32,3,5.8,36,125,499.99,4,'Intel LGA 1700'),(18,'Intel','Core i9-14900K',61058,24,32,3.2,6,36,125,529.99,4,'Intel LGA 1700'),(19,'AMD','Ryzen 9 7950X3D',62598,16,32,4.2,5.7,128,120,580.71,10,'AMD AM5'),(20,'AMD','Ryzen 9 7950X',62983,16,32,4.5,5.7,64,170,549.99,10,'AMD AM5');
/*!40000 ALTER TABLE `cpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpucooler`
--

DROP TABLE IF EXISTS `cpucooler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpucooler` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `size` int NOT NULL,
  `height` int NOT NULL,
  `RGB` tinyint(1) NOT NULL,
  `addressable` tinyint(1) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpucooler`
--

LOCK TABLES `cpucooler` WRITE;
/*!40000 ALTER TABLE `cpucooler` DISABLE KEYS */;
INSERT INTO `cpucooler` VALUES (1,120,160,0,0,'Deepcool','AK620',64.99),(2,120,160,0,0,'Deepcool','AK620',64.99),(3,120,168,1,1,'be quiet!','Dark Rock Pro 5',99.9),(4,120,168,1,1,'be quiet!','Dark Rock Pro 6',99.9),(5,120,148,1,1,'Vetroo','V5',24.99),(6,120,148,1,1,'Vetroo','V6',24.99),(7,120,155,1,0,'Thermaltake','UX200 Special Edition',29.99),(8,120,155,1,0,'Thermaltake','UX200 Special Edition',29.99);
/*!40000 ALTER TABLE `cpucooler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpucooler_socket_compatibility`
--

DROP TABLE IF EXISTS `cpucooler_socket_compatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpucooler_socket_compatibility` (
  `cooler_id` bigint NOT NULL,
  `compatibility_id` bigint NOT NULL,
  PRIMARY KEY (`cooler_id`,`compatibility_id`),
  KEY `compatibility_id` (`compatibility_id`),
  CONSTRAINT `cpucooler_socket_compatibility_ibfk_1` FOREIGN KEY (`cooler_id`) REFERENCES `cpucooler` (`id`),
  CONSTRAINT `cpucooler_socket_compatibility_ibfk_2` FOREIGN KEY (`compatibility_id`) REFERENCES `socket_compatibility` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpucooler_socket_compatibility`
--

LOCK TABLES `cpucooler_socket_compatibility` WRITE;
/*!40000 ALTER TABLE `cpucooler_socket_compatibility` DISABLE KEYS */;
INSERT INTO `cpucooler_socket_compatibility` VALUES (1,1),(1,2),(1,3),(1,4),(4,4),(5,4),(7,4),(1,5),(4,5),(5,5),(7,5),(1,6),(4,6),(1,7),(4,7),(1,8),(4,8),(2,9),(3,9),(6,9),(8,9),(3,10),(6,10),(8,10),(4,11),(5,12),(7,13),(8,14),(8,15),(8,16),(8,17),(8,18),(8,19);
/*!40000 ALTER TABLE `cpucooler_socket_compatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_factor_compatibility`
--

DROP TABLE IF EXISTS `form_factor_compatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form_factor_compatibility` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `form_factor_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_factor_compatibility`
--

LOCK TABLES `form_factor_compatibility` WRITE;
/*!40000 ALTER TABLE `form_factor_compatibility` DISABLE KEYS */;
INSERT INTO `form_factor_compatibility` VALUES (1,'ATX'),(2,'Micro ATX'),(3,'ITX'),(4,'Mini ITX'),(5,'E-ATX'),(6,'SSI-EEB');
/*!40000 ALTER TABLE `form_factor_compatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_factor_compatibility_seq`
--

DROP TABLE IF EXISTS `form_factor_compatibility_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form_factor_compatibility_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_factor_compatibility_seq`
--

LOCK TABLES `form_factor_compatibility_seq` WRITE;
/*!40000 ALTER TABLE `form_factor_compatibility_seq` DISABLE KEYS */;
INSERT INTO `form_factor_compatibility_seq` VALUES (1);
/*!40000 ALTER TABLE `form_factor_compatibility_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_requirement`
--

DROP TABLE IF EXISTS `game_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_requirement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pc_requirements` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_requirement`
--

LOCK TABLES `game_requirement` WRITE;
/*!40000 ALTER TABLE `game_requirement` DISABLE KEYS */;
INSERT INTO `game_requirement` VALUES (1,'Palworld','Minimum','Windows 10','Intel Core i5-3570K',16,'NVIDIA GeForce GTX 1050','Version 11','Broadband Internet connection',40,'','Internet connection required for multiplayer. SSD required.'),(2,'HELLDIVERS 2','Minimum','Windows 10','Intel Core i7-4790K,AMD Ryzen 5 1500X',8,'NVIDIA GeForce GTX 1050 Ti,AMD Radeon RX 470','','',100,'',''),(3,'Sons Of The Forest','Minimum','Windows 10 (64-bit)','Intel Core i5-8400,AMD RYZEN 3 3300X',12,'NVIDIA GeForce GTX 1060,AMD Radeon RX 570','Version 11','',20,'','SSD (Preferred)'),(4,'Last Epoch','Minimum','','Intel Core i5 2500,AMD FX-4350',8,'NVIDIA GeForce GTX 1060,AMD RX 580','Version 11','Broadband Internet connection',22,'','SSD strongly recommended'),(5,'FOR HONOR','Minimum','Windows 10 (64-bit)','Intel Core i3-4150,AMD FX-4300',4,'NVIDIA GeForce GTX1050,AMD Radeon RX460','Version 9.0c','Broadband Internet connection',90,'DirectX 9.0c compatible sound card','Mouse and Keyboard supported. Game contains EasyAntiCheat anti-cheat technology and Denuvo anti-tamper technology.'),(6,'Enshrouded','Minimum','Windows 10','Intel Core i5-6400,AMD Ryzen 5 1500X',16,'NVIDIA GeForce GTX 1060,AMD Radeon RX 580,Intel ARC A380','','Broadband Internet connection',60,'on board',''),(7,'Granblue Fantasy: Relink','Minimum','Windows 10 (64-bit)','Intel Core i3-9100,AMD Ryzen 3 3200G',16,'NVIDIA GeForce GTX 1060,AMD Radeon RX 580','Version 11','',90,'','SSD recommended (Capable of 1080p/30fps when graphics are set to Standard.)'),(8,'Wo Long: Fallen Dynasty','Minimum','Windows 10 (64-bit),Windows 11','Intel Core i5-8400,AMD Ryzen 5 3400G',8,'NVIDIA GeForce GTX 1650,AMD Radeon RX 570','Version 12','Broadband Internet connection',60,'16 bit stereo, 48kHz WAVE file can be played','Based on an HDD, 720p, 30 fps environment, and Graphics Settings set to \"Best Performance.\"'),(9,'Deep Rock Galactic: Survivor','Minimum','Windows 10 (64-bit)','Intel Core i5-4590',8,'NVIDIA GeForce GTX 1050','','',2,'',''),(10,'Supermarket Simulator','Minimum','Windows 10 (64-bit)','Intel Core i5 3550,AMD Ryzen 5 2500X',4,'NVIDIA GeForce GTX 1050,AMD R9 270X','Version 11','',5,'',''),(11,'TEKKEN 8','Minimum','Windows 10 (64-bit)','Intel Core i5-6600K,AMD Ryzen 5 1600',8,'NVIDIA GeForce GTX 1050Ti,AMD Radeon R9 380X','Version 12','Broadband Internet connection',100,'DirectX compatible soundcard/Onboard chipset','*\"FPS (frame rate/second): Stable over 60\" is guaranteed and selected under the graphic settings by default when the game is launched for the first time.*Frame rate may drop when other applications are running in the background.*Please note that minimum and recommended specifications are subjected to changes without notice.'),(12,'Myth of Empires','Minimum','','Intel Core i5-4430,AMD FX-6300',8,'NVIDIA GeForce GTX 960,AMD Radeon R7 370','Version 11','Broadband Internet connection',85,'DirectX compatible sound card with the latest drivers',''),(13,'Nightingale','Minimum','Windows 10 (64-bit)','Intel Core i5-4430',16,'NVIDIA GeForce GTX 1060,AMD Radeon RX 580,Intel Arc A580','Version 12','Broadband Internet connection',70,'','Internet connection required to play. SSD required. Windows 10 version 1909 (revision 18363.1350 or greater). Version 2004 (revision 19041.789 or greater). Version 20H2 (revision 19042.789 or greater).'),(14,'Like a Dragon: Infinite Wealth','Minimum','Windows 10 1903 (OS Build 18362)','Intel Core i5-3470,AMD Ryzen 3 1200',8,'NVIDIA GeForce GTX 960,AMD Radeon RX 460,Intel Arc A380','Version 12','',82,'Windows Compatible Audio Device','1080p Low @ 30 FPS w/ Balanced FSR 1.0, requires a CPU which supports the AVX and SSE4.2 instruction set'),(15,'Persona 3 Reload','Minimum','Windows 10','Intel Core i5-2300,AMD FX-4350',8,'NVIDIA GeForce GTX 650Ti,AMD Radeon HD 7850','Version 12','',30,'','Performance Target: 720p, low graphics settings, @ 30 FPS'),(16,'Balatro','Minimum','','Intel Core i3',1,'OpenGL 2.1 compatible graphics card, integrated graphics','','',150,'',''),(17,'The Outlast Trials','Minimum','Windows 10','Intel Core i7-3770,AMD Ryzen 5 1400',8,'NVIDIA GeForce GTX 650Ti,AMD Radeon R7 360,Intel Arc A310','Version 11','Broadband Internet connection',40,'','Low 720p @ 30 FPS, DX11, Ray Tracing OFF'),(18,'Backpack Battles','Minimum','Windows 10','',1,'','','',300,'',''),(19,'Astral Party ','Minimum','','Intel Core i5',8,'NVIDIA GeForce GTX 750','Version 11','Broadband Internet connection',4,'',''),(20,'Pacific Drive','Minimum','Windows 10','Intel Core i5 8600',16,'NVIDIA GeForce GTX 1060','Version 12','',18,'','Requires a 64-bit processor and operating system'),(21,'Palworld','Recommended','Windows 10 (64-bit)','Intel Core i9-9900K',32,'NVIDIA GeForce RTX 2070','Version 11','Broadband Internet connection',40,'','Internet connection required for multiplayer. SSD required.'),(22,'HELLDIVERS 2','Recommended','Windows 10\\','Intel Core i7-9700K,AMD Ryzen 7 3700X',16,'NVIDIA GeForce RTX 2060,AMD Radeon RX 6600 XT','','',100,'','SSD Recommended'),(23,'Sons Of The Forest','Recommended','Windows 10 (64-bit)','Intel Core i7-8700K,AMD RYZEN 5 3600X',16,'NVIDIA GeForce GTX 1080Ti,AMD Radeon RX 5700 XT','Version 11','',20,'','SSD (Preferred)'),(24,'Last Epoch','Recommended','Windows 10','Intel Core i5 6500,AMD Ryzen 3 1200',16,'NVIDIA GeForce RTX 3060,AMD RX 6600-XT','Version 11','Broadband Internet connection',22,'','SSD strongly recommended'),(25,'FOR HONOR','Recommended','Windows 10 (64-bit),Windows 11','Intel Core i5-7500,AMD Ryzen 5 1400',8,'NVIDIA GeForce GTX1080,AMD Radeon RX580','Version 9.0c','Broadband Internet connection',90,'DirectX 9.0c compatible sound card','Mouse and Keyboard supported. Game contains EasyAntiCheat anti-cheat technology and Denuvo anti-tamper technology.'),(26,'Enshrouded','Recommended','Windows 10','Intel Core i7-8700,AMD Ryzen 7 2700X',16,'NVIDIA GeForce RTX 2070 Super,AMD Radeon RX 6700 XT','','Broadband Internet connection',60,'on board',''),(27,'Granblue Fantasy: Relink','Recommended','Windows 10 (64-bit),Windows 11','Intel Core i7-8700,AMD Ryzen 5 3600',16,'NVIDIA GeForce RTX 2080,AMD Radeon RX 6700 XT','Version 11','',90,'','SSD recommended (Capable of 1080p/60fps when graphics are set to Ultra.)'),(28,'Wo Long: Fallen Dynasty','Recommended','Windows 10 (64-bit),Windows 11','Intel Core i7-8700,AMD Ryzen 5 3600XT',16,'NVIDIA GeForce RTX 2060,AMD Radeon RX 5700XT','Version 12','Broadband Internet connection',60,'16 bit stereo, 48kHz WAVE file can be played','Based on an HDD, 1080p, 60 fps environment, and Graphcs Settings set to \"Standard.\"'),(29,'Deep Rock Galactic: Survivor','Recommended','','',0,'','','',0,'',''),(30,'Supermarket Simulator','Recommended','Windows 10 (64-bit)','Intel Core i5 7600K,AMD Ryzen 5 2600x',8,'NVIDIA GeForce GTX 1060,AMD RX 480','Version 11','',5,'',''),(31,'TEKKEN 8','Recommended','Windows 10 (64-bit)','Intel Core i7-7700K,AMD Ryzen 5 2600',16,'NVIDIA GeForce RTX 2070,AMD Radeon RX 5700 XT','Version 12','Broadband Internet connection',100,'DirectX compatible soundcard/Onboard chipset','*\"FPS (frame rate/second): Stable over 60\" is guaranteed and selected under the graphic settings by default when the game is launched for the first time.*Frame rate may drop when other applications are running in the background.*Please note that minimum and recommended specifications are subjected to changes without notice.'),(32,'Myth of Empires','Recommended','','Intel Core i5-6600K,AMD Ryzen 5 1600',16,'NVIDIA GeForce GTX 1060,AMD Radeon RX 580','Version 11','Broadband Internet connection',85,'DirectX compatible sound card with the latest drivers',''),(33,'Nightingale','Recommended','Windows 10 (64-bit)','Intel Core i5-8600',16,'NVIDIA GeForce RTX 2060 Super,AMD Radeon RX 5700XT','Version 12','Broadband Internet connection',70,'','Internet connection required to play. SSD required. Windows 10 version 1909 (revision 18363.1350 or greater). Version 2004 (revision 19041.789 or greater). Version 20H2 (revision 19042.789 or greater).'),(34,'Like a Dragon: Infinite Wealth','Recommended','Windows 10 1903 (OS Build 18362)','Intel Core i7-4790,AMD Ryzen 5 1600',16,'NVIDIA GeForce RTX 2060,AMD Radeon RX 5700,Intel Arc A750','Version 12','',82,'Windows Compatible Audio Device','1080p High @ 60 FPS w/o FSR, requires a CPU which supports the AVX and SSE4.2 instruction set'),(35,'Persona 3 Reload','Recommended','Windows 10','Intel Core i7-4790,AMD Ryzen 5 1400',8,'NVIDIA GeForce GTX 1650,AMD Radeon R9 290X','Version 12','',30,'','Performance Target: 1080p, high graphics settings, @ 60 FPS'),(36,'Balatro','Recommended','','',0,'','','',0,'',''),(37,'The Outlast Trials','Recommended','Windows 10','Intel Core i7-6700K,AMD Ryzen 5 2600X',16,'NVIDIA GeForce GTX 1660,AMD Radeon RX Vega 56,Intel Arc A580','Version 12','Broadband Internet connection',40,'','High 1080p @ 60 FPS, DX12, Ray Tracing OFF'),(38,'Backpack Battles','Recommended','','',0,'','','',0,'',''),(39,'Astral Party ','Recommended','Windows 10','Intel Core i7',16,'NVIDIA GeForce GTX 1660','Version 12','Broadband Internet connection',4,'',''),(40,'Pacific Drive','Recommended','Windows 10','Intel Core i5-10600K',16,'NVIDIA GeForce RTX 2080,NVIDIA GeForce RTX 3070','Version 12','',18,'','Requires a 64-bit processor and operating system');
/*!40000 ALTER TABLE `game_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpu`
--

DROP TABLE IF EXISTS `gpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `score` int NOT NULL,
  `cuda_core_num` int NOT NULL,
  `base_clock` int NOT NULL,
  `boost_clock` int NOT NULL,
  `memory` int NOT NULL,
  `memory_clock` int NOT NULL,
  `request_system_power` int NOT NULL,
  `length` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpu`
--

LOCK TABLES `gpu` WRITE;
/*!40000 ALTER TABLE `gpu` DISABLE KEYS */;
INSERT INTO `gpu` VALUES (3,'NVIDIA','GeForce RTX 4090',38765,16384,2230000,2520000,24,1313,850,304,1599),(4,'NVIDIA','GeForce RTX 4090 D',29414,14592,2280000,0,0,0,0,0,0),(5,'NVIDIA','GeForce RTX 4080 SUPER',34344,10240,2290000,2550000,16,1438,750,304,999),(6,'NVIDIA','GeForce RTX 4080',34656,9728,2210000,2510000,16,1400,750,304,999),(7,'NVIDIA','GeForce RTX 4070 Ti SUPER',31805,8448,2340000,2610000,16,1313,700,0,799.99),(8,'NVIDIA','GeForce RTX 4070 Ti',31750,7680,2310000,2610000,12,1313,700,0,719.99),(9,'NVIDIA','GeForce RTX 4070 SUPER',30343,7168,1980000,2480000,12,1313,650,244,589.99),(10,'NVIDIA','GeForce RTX 4070',27003,5888,1920000,2480000,12,1313,650,244,529.99),(11,'NVIDIA','GeForce RTX 4060 Ti 16 GB',22971,4352,2310000,2540000,16,2250,550,244,449.99),(12,'NVIDIA','GeForce RTX 4060 Ti 8 GB',22899,4352,2310000,2540000,8,2250,550,244,399),(13,'NVIDIA','GeForce RTX 4060',19689,3072,1830000,2460000,8,2125,550,0,289.99),(14,'NVIDIA','GeForce RTX 4050',0,2560,2500000,0,6,2250,0,0,0),(15,'NVIDIA','GeForce RTX 3090 Ti',29786,10752,1560000,1860000,24,1313,850,12,1999.99),(16,'NVIDIA','GeForce RTX 3090',26832,10496,1400000,1700000,24,1314,750,12,1499),(17,'NVIDIA','GeForce RTX 3080 Ti',27253,10240,1370000,1670000,12,1188,750,11,1099.99),(18,'NVIDIA','GeForce RTX 3080(16GB)',0,8960,0,1810000,16,1188,750,11,999.99),(19,'NVIDIA','GeForce RTX 3080(12GB)',26744,0,0,1725000,12,1189,0,0,948.21),(20,'NVIDIA','GeForce RTX 3080(10GB)',25330,0,0,1905000,10,1190,0,0,862.03),(21,'NVIDIA','GeForce RTX 3070 Ti',23686,6144,1580000,1770000,8,1188,750,10,599.99),(22,'NVIDIA','GeForce RTX 3070',22431,5888,1500000,1730000,8,1750,650,9,399.99),(23,'NVIDIA','GeForce RTX 3060 Ti',20568,4864,1410000,1670000,8,1188,600,9,379.99),(24,'NVIDIA','GeForce RTX 3060',15541,3584,1320000,1780000,12,1875,550,0,269.99),(25,'NVIDIA','GeForce RTX 3060 (12 GB)',17095,3584,1320000,1780000,12,1875,550,0,279.99),(26,'NVIDIA','GeForce RTX 3050(8 GB)',0,2560,1550000,1780000,8,1750,550,0,219.99),(27,'NVIDIA','GeForce RTX 3050(6 GB)',12880,2304,1040000,1470000,6,1750,300,0,169.99),(28,'AMD','Radeon RX 7900 XTX',0,0,0,0,0,0,0,0,0),(29,'AMD','Radeon RX 7900 XT',30977,0,0,0,0,0,0,0,899),(30,'AMD','Radeon RX 6950 XT',28906,0,0,0,0,0,0,0,699),(31,'AMD','Radeon RX 6900 XT',28367,0,0,0,0,0,0,0,779),(32,'AMD','Radeon RX 6800 XT',26866,0,0,0,0,0,0,0,529),(33,'AMD','Radeon RX 7800 XT',25103,0,0,0,0,0,0,0,439),(34,'AMD','Radeon RX 6800',24042,0,0,0,0,0,0,0,489),(35,'AMD','Radeon RX 7700 XT',22330,0,0,0,0,0,0,0,389),(36,'AMD','Radeon RX 6750 XT',21191,0,0,0,0,0,0,0,399),(37,'AMD','Radeon RX 6700 XT',20834,0,0,0,0,0,0,0,329),(38,'AMD','Radeon RX 6700',19881,0,0,0,0,0,0,0,329),(39,'AMD','Radeon RX 6650 XT',18611,0,0,0,0,0,0,0,229),(40,'AMD','Radeon RX 7600 XT',17322,0,0,0,0,0,0,0,229),(41,'AMD','Radeon RX 5700 XT',16905,0,0,0,0,0,0,0,329),(42,'AMD','Radeon RX 6600 XT',16696,0,0,0,0,0,0,0,286),(43,'AMD','Radeon RX 7600',16464,0,0,0,0,0,0,0,229),(44,'AMD','Radeon RX 6600',16261,0,0,0,0,0,0,0,259),(45,'AMD','Radeon RX 5700',15130,0,0,0,0,0,0,0,199),(46,'','',14521,0,0,0,0,0,0,0,239);
/*!40000 ALTER TABLE `gpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hard_drive`
--

DROP TABLE IF EXISTS `hard_drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hard_drive` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL,
  `capacity` varchar(255) NOT NULL,
  `form_factor` float NOT NULL,
  `hd_interface` varchar(255) NOT NULL,
  `nvme` tinyint(1) NOT NULL,
  `price` double NOT NULL,
  `max_transfer_rate` int DEFAULT NULL,
  `cache` int DEFAULT NULL,
  `max_sequential_read` int DEFAULT NULL,
  `max_sequential_write` int DEFAULT NULL,
  `memory_component` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hard_drive`
--

LOCK TABLES `hard_drive` WRITE;
/*!40000 ALTER TABLE `hard_drive` DISABLE KEYS */;
INSERT INTO `hard_drive` VALUES (1,'Seagate','FireCuda HDD','HDD','1TB',3.5,'SATA III',0,101,260,256,NULL,NULL,NULL),(2,'WD','Black HDD','HDD','1TB',3.5,'SATA III',0,76.99,263,256,NULL,NULL,NULL),(3,'WD','Blue HDD','HDD','1TB',3.5,'SATA III',0,30.85,185,128,NULL,NULL,NULL),(4,'Seagate','IronWolf Pro HDD','HDD','2TB',3.5,'SATA III',0,110.19,NULL,256,NULL,NULL,NULL),(5,'WD','Red Pro HDD','HDD','12TB',3.5,'SATA III',0,400.99,NULL,512,NULL,NULL,NULL),(6,'Toshiba','N300 Pro','HDD','6TB',3.5,'SATA III',0,186.64,NULL,512,NULL,NULL,NULL),(7,'WD','BLACK SN850X NVMe','SSD','4TB',2280,'M.2',1,299,NULL,NULL,7300,6300,'3D NAND TLC'),(8,'Samsung','990 EVO','SSD','2TB',2280,'M.2',0,94.99,NULL,NULL,5000,4200,'V-NAND TLC'),(9,'Team Group','T-FT-FORCE VULCAN Z','SSD','500GB',2.5,'SATA III',0,54.99,NULL,NULL,500,500,'3D NAND'),(10,'Team Group','CX2','SSD','500GB',2.5,'SATA III',0,57.99,NULL,NULL,540,490,'3D TLC'),(11,'Samsung','980','SSD','1TB',2280,'M.2',0,84,NULL,NULL,3500,3000,'V-NAND MLC');
/*!40000 ALTER TABLE `hard_drive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motherboard`
--

DROP TABLE IF EXISTS `motherboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motherboard` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `socket_type` varchar(255) NOT NULL,
  `chipset` varchar(255) NOT NULL,
  `memory_slot` int NOT NULL,
  `clock_speed` int NOT NULL,
  `max_memory` int NOT NULL,
  `ddrx` int NOT NULL,
  `PCIe4x16Slots` int DEFAULT NULL,
  `SATASlots` int DEFAULT NULL,
  `SATASpeed` int DEFAULT NULL,
  `M2Slots` int DEFAULT NULL,
  `M2Type` varchar(255) DEFAULT NULL,
  `supportNVMe` tinyint(1) NOT NULL,
  `form_factor` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `socket_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `CHK_supportNVMe` CHECK ((`supportNVMe` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motherboard`
--

LOCK TABLES `motherboard` WRITE;
/*!40000 ALTER TABLE `motherboard` DISABLE KEYS */;
INSERT INTO `motherboard` VALUES (1,'ASUS','TUF Gaming B650-E WIFI','AMD AM5','AMD B650',4,5200,192,5,2,4,6,3,'(supports PCIe 4.0 x4 mode)',1,'ATX',199.99,10),(2,'ASUS','ROG STRIX B650-A Gaming WIFI 6E','AMD AM5','AMD B650',4,6400,128,5,2,4,6,3,'(supports PCIe 4.0 x4 mode)',1,'ATX',259.99,10),(3,'MSI','GAMING PLUS WIFI','AMD AM5','AMD B650',4,6000,192,5,2,4,6,2,'',1,'ATX',169.99,10),(4,'ASRock','B650M Pro RS WIFI','AMD AM5','AMD B650',4,6000,128,5,2,4,6,3,'',1,'Micro ATX',149.99,10),(5,'Gigabyte','X670E AORUS PRO X','AMD AM5','AMD X670',4,8000,192,5,3,4,6,4,'',1,'ATX',299.99,10),(6,'ASUS','PRIME B450M-A II','AMD AM4','AMD B450',4,4400,128,4,1,6,6,2,'',1,'Micro ATX',71.99,9),(7,'MSI','MAG Z790 TOMAHAWK MAX WIFI','Intel LGA 1700','Intel Z790',4,7800,192,5,2,8,6,4,'',1,'ATX',279.99,4),(8,'ASRock','Z690 PG VELOCITA','Intel LGA 1700','Intel Z690',4,6400,128,5,3,6,6,4,'',1,'ATX',149.99,4),(9,'MSI','B760 GAMING PLUS WIFI','Intel LGA 1700','Intel B760',4,6800,192,5,2,4,6,2,'',1,'ATX',159.99,4),(10,'Gigabyte','H610I','Intel LGA 1700','Intel H610',2,5600,64,5,1,4,6,1,'',0,'ITX',109.99,4);
/*!40000 ALTER TABLE `motherboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motherboard_formfactorcompatibility`
--

DROP TABLE IF EXISTS `motherboard_formfactorcompatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motherboard_formfactorcompatibility` (
  `motherboard_id` bigint NOT NULL,
  `formFactorType_id` bigint NOT NULL,
  PRIMARY KEY (`motherboard_id`,`formFactorType_id`),
  KEY `formFactorType_id` (`formFactorType_id`),
  CONSTRAINT `motherboard_formfactorcompatibility_ibfk_1` FOREIGN KEY (`motherboard_id`) REFERENCES `motherboard` (`id`),
  CONSTRAINT `motherboard_formfactorcompatibility_ibfk_2` FOREIGN KEY (`formFactorType_id`) REFERENCES `formfactorcompatibility` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motherboard_formfactorcompatibility`
--

LOCK TABLES `motherboard_formfactorcompatibility` WRITE;
/*!40000 ALTER TABLE `motherboard_formfactorcompatibility` DISABLE KEYS */;
INSERT INTO `motherboard_formfactorcompatibility` VALUES (1,1),(2,1),(3,1),(5,1),(7,1),(8,1),(9,1),(4,2),(6,2),(10,3);
/*!40000 ALTER TABLE `motherboard_formfactorcompatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_supply`
--

DROP TABLE IF EXISTS `power_supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `power_supply` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `model` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `form_factor` varchar(255) NOT NULL,
  `max_power` int NOT NULL,
  `maxPSULength` int NOT NULL,
  `modular` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_supply`
--

LOCK TABLES `power_supply` WRITE;
/*!40000 ALTER TABLE `power_supply` DISABLE KEYS */;
INSERT INTO `power_supply` VALUES (1,'RM750e','Corsair',89.99,'ATX',750,151,'Yes'),(2,'RM1000e','Corsair',139.99,'ATX',1000,151,'Yes'),(3,'XP1000W 80PLUS PLATINUM','Sama',129.99,'ATX',1000,140,'Yes'),(4,'Hybrid II Series','Raidmax',49.99,'ATX',530,159,'Semi-Modular'),(5,'SuperNOVA 750 GM','EVGA',149.99,'SFX',750,100,'Yes'),(6,'SFX Series','SilverStone',65.99,'SFX',300,100,'No'),(7,'650 N1','EVGA',59.99,'ATX',650,140,'No');
/*!40000 ALTER TABLE `power_supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ram`
--

DROP TABLE IF EXISTS `ram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ram` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `DDRVersion` int NOT NULL,
  `stick_num` int NOT NULL,
  `size` int NOT NULL,
  `clock_speed` int NOT NULL,
  `voltage` double NOT NULL,
  `RGB` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ram`
--

LOCK TABLES `ram` WRITE;
/*!40000 ALTER TABLE `ram` DISABLE KEYS */;
INSERT INTO `ram` VALUES (32,'G. Skill','Trident Z5 Neo RGB',117.99,5,2,16,6000,1.35,1),(33,'G. Skill','Trident Z5 RGB',199.97,5,2,16,6000,1.3,1),(34,'Samsung','?',109,5,2,16,4800,1.1,0),(35,'TeamGroup','T-Force Xtreem ARGB',84.99,4,2,8,3600,1.45,0),(36,'Patriot','ViperSteel',339.99,4,2,8,4400,1.45,0),(37,'Corsair','Vengeance RGB Pro',377.39,4,4,8,3200,1.35,1),(38,'G. Skill','Trident Z Neo',89.99,4,2,16,3600,1.35,0),(39,'Corsair','Vengeance LPX',49.99,4,2,8,2666,1.2,0),(40,'OLOy','Blade',175.99,5,2,32,6000,1.4,0),(41,'Crucial','Pro',114.99,5,2,16,5600,1.1,0),(42,'Crucial','Pro',159.99,5,2,24,5600,1.1,0),(43,'Crucial','Pro',179.99,5,2,32,5600,1.1,0),(44,'Crucial','Pro',264.99,5,2,48,5600,1.1,0),(45,'Crucial','Pro',56.99,4,2,16,3200,1.2,0),(46,'Crucial','Pro',114.99,5,2,32,3200,1.2,0),(47,'OLOy','Blade',169.99,5,2,16,7800,1.45,1),(48,'OLOy','Blade',149.99,5,2,16,7600,1.45,1),(49,'OLOy','Blade',99.99,5,2,16,6400,1.35,1),(50,'OLOy','Blade',95.99,5,2,16,6000,1.35,1);
/*!40000 ALTER TABLE `ram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socket_compatibility`
--

DROP TABLE IF EXISTS `socket_compatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socket_compatibility` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `socket_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_compatibility`
--

LOCK TABLES `socket_compatibility` WRITE;
/*!40000 ALTER TABLE `socket_compatibility` DISABLE KEYS */;
INSERT INTO `socket_compatibility` VALUES (1,'Intel LGA 2066'),(2,'Intel LGA 2011-3'),(3,'Intel LGA 2011'),(4,'Intel LGA 1700'),(5,'Intel LGA 1200'),(6,'Intel LGA 1155'),(7,'Intel LGA 1151'),(8,'Intel LGA 1150'),(9,'AMD AM4'),(10,'AMD AM5'),(11,'Intel LGA 1156'),(12,'Intel LGA 115X'),(13,'Intel LGA 115x'),(14,'AMD AM3+'),(15,'AMD AM3'),(16,'AMD AM2+'),(17,'AMD AM2'),(18,'AMD FM2'),(19,'AMD FM1');
/*!40000 ALTER TABLE `socket_compatibility` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-19 15:02:24
