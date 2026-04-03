-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_db
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `fav_movie`
--

DROP TABLE IF EXISTS `fav_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fav_movie` (
  `sno` int NOT NULL AUTO_INCREMENT,
  `id` int NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fav_movie`
--

LOCK TABLES `fav_movie` WRITE;
/*!40000 ALTER TABLE `fav_movie` DISABLE KEYS */;
INSERT INTO `fav_movie` VALUES (5,975419,'jasmeen@gmail.com'),(20,964679,'jasmeen@gmail.com'),(29,123463,'jasmeenkaur@gmail.com'),(47,229185,'jasmeen@gmail.com'),(48,10195,'jasmeenkaur@gmail.com'),(49,464293,'jasmeen@gmail.com'),(50,170078,'jasmeen@gmail.com'),(52,50388,'jasmeen@gmail.com'),(56,1184243,'jasmeen@gmail.com'),(65,10195,'jasmeen@gmail.com'),(70,928221,'jasmeenkaur2356@gmail.com'),(71,538154,'jasmeenkaur2356@gmail.com'),(72,617483,'jasmeenkaur2356@gmail.com'),(74,1184243,'jasmeenkaur2356@gmail.com'),(79,1045211,'jasmeenkaur2356@gmail.com'),(87,826510,'jasmeenkaur2356@gmail.com'),(88,278,'jasmeenkaur2356@gmail.com'),(92,589270,'jasmeenkaur2356@gmail.com'),(96,10195,'jasmeenkaur2356@gmail.com'),(99,50388,'jasmeenkaur2356@gmail.com'),(100,1337143,'jasmeenkaur2356@gmail.com'),(101,616037,'jasmeenkaur2356@gmail.com'),(102,939243,'jasmeenkaur2356@gmail.com'),(103,238,'jasmeenkaur2356@gmail.com'),(104,284053,'jasmeenkaur2356@gmail.com'),(106,1126166,'jasmeenkaur2356@gmail.com'),(107,240,'jasmeenkaur2356@gmail.com'),(108,183154,'jasmeenkaur2356@gmail.com');
/*!40000 ALTER TABLE `fav_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fav_tv`
--

DROP TABLE IF EXISTS `fav_tv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fav_tv` (
  `sno` int NOT NULL AUTO_INCREMENT,
  `id` int NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fav_tv`
--

LOCK TABLES `fav_tv` WRITE;
/*!40000 ALTER TABLE `fav_tv` DISABLE KEYS */;
INSERT INTO `fav_tv` VALUES (3,1668,'jasmeenkaur@gmail.com'),(4,71728,'jasmeen@gmail.com'),(8,130805,'jasmeen@gmail.com'),(24,12703,'jasmeen@gmail.com'),(27,87547,'jasmeen@gmail.com'),(45,42109,'jasmeenkaur@gmail.com'),(64,36594,'jasmeen@gmail.com'),(65,20813,'jasmeen@gmail.com'),(69,78606,'jasmeen@gmail.com'),(75,2408,'jasmeen@gmail.com'),(78,155439,'jasmeenkaur2356@gmail.com'),(81,80018,'jasmeen@gmail.com'),(87,2304,'jasmeenkaur2356@gmail.com'),(90,33765,'jasmeenkaur2356@gmail.com'),(91,127635,'jasmeenkaur2356@gmail.com'),(92,12703,'jasmeenkaur2356@gmail.com'),(93,87547,'jasmeenkaur2356@gmail.com'),(102,260875,''),(103,1668,'jasmeenkaur2356@gmail.com'),(104,386590,'jasmeenkaur2356@gmail.com'),(105,80018,'jasmeenkaur2356@gmail.com'),(106,351072,'jasmeenkaur2356@gmail.com');
/*!40000 ALTER TABLE `fav_tv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `photo` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('jasmeenkaur','jasmeen@gmail.com','123','98765','src/myuploads/netflix.jpeg'),('jasmeenkaur','jasmeen12@gmail.com','789456','789456','src/myuploads/1.jpg'),('jasmeenk','jasmeenk@gmail.com','12345','98765','src/myuploads/1.jpg'),('jaskaur','jasmeenkaur@gmail.com','1452','587432169','src/myuploads/1.jpg'),('Jasmeen Kaur','jasmeenkaur2356@gmail.com','123456','7528897197','src/myuploads/Screenshot 2025-04-15 140107.png'),('jasmeenkaur','jasmeenwaraich@gmail.com','78945','987783','src/myuploads/white.jpg');
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

-- Dump completed on 2025-09-12 21:21:44
