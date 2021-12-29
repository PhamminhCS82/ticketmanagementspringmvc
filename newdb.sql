-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: qlbanvexe
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iduser` int NOT NULL,
  `idtrip` int NOT NULL,
  `rating` int DEFAULT '0',
  `createddate` datetime DEFAULT NULL,
  `detail` longtext,
  PRIMARY KEY (`id`),
  KEY `comment_user_idx` (`iduser`),
  KEY `trip_comment_idx` (`idtrip`),
  CONSTRAINT `trip_comment` FOREIGN KEY (`idtrip`) REFERENCES `trip` (`id`),
  CONSTRAINT `user_comment` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_ticket`
--

DROP TABLE IF EXISTS `order_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` date DEFAULT NULL,
  `user_id` int NOT NULL,
  `is_paid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fk_order_user_idx` (`user_id`),
  CONSTRAINT `fk_user_order_ticket` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_ticket`
--

LOCK TABLES `order_ticket` WRITE;
/*!40000 ALTER TABLE `order_ticket` DISABLE KEYS */;
INSERT INTO `order_ticket` VALUES (5,'2021-12-29',36,_binary '\0');
/*!40000 ALTER TABLE `order_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengercar`
--

DROP TABLE IF EXISTS `passengercar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengercar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT 'Xe khách',
  `carnumber` varchar(45) NOT NULL,
  `active` tinyint DEFAULT '1',
  `iduser` int DEFAULT NULL,
  `num_of_seats` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `carnumber_UNIQUE` (`carnumber`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`),
  CONSTRAINT `car_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengercar`
--

LOCK TABLES `passengercar` WRITE;
/*!40000 ALTER TABLE `passengercar` DISABLE KEYS */;
INSERT INTO `passengercar` VALUES (1,'Xe khách','abcd1234',1,2,45),(2,'Xe khách','xyz2456',1,3,40),(3,'Xe khách','adasdaf',1,NULL,30);
/*!40000 ALTER TABLE `passengercar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `start` varchar(45) DEFAULT NULL,
  `finish` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'Khu vực 2 - Khu vực 1','Da Lat','Sai Gon'),(2,'Khu vực 7 - Khu vực 11','Nha Trang','Binh Dinh');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `idorder` int DEFAULT NULL,
  `seat_name` int DEFAULT NULL,
  `trip_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_order_idx` (`idorder`),
  KEY `fk_ticket_trip_idx` (`trip_id`),
  CONSTRAINT `fk_ticket_order` FOREIGN KEY (`idorder`) REFERENCES `order_ticket` (`id`),
  CONSTRAINT `fk_ticket_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (13,'QCEd8bZ3Pm',220,5,1,3),(14,'aGbicsO4g4',220,5,2,3),(15,'wq5fDD5O3F',220,5,3,3),(16,'5LdLg0QwFu',220,5,4,3),(17,'K6cbbRJOIm',220,5,5,3);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date_time` datetime NOT NULL,
  `idroute` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `num_of_seats` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_time_UNIQUE` (`date_time`),
  KEY `route_trip_idx` (`idroute`),
  KEY `fk_car_trip_idx` (`car_id`),
  CONSTRAINT `fk_car_trip` FOREIGN KEY (`car_id`) REFERENCES `passengercar` (`id`),
  CONSTRAINT `route_trip` FOREIGN KEY (`idroute`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,'Chuyến số 1','2021-12-19 13:00:00',1,200000,1,45),(2,'Chuyến số 2','2021-12-19 14:00:00',2,180000,2,40),(3,'Chuyến số 3','2021-12-19 15:00:00',1,220000,3,25),(4,'Chuyến số 2','2021-12-30 04:52:00',2,220000,1,45);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `active` tinyint DEFAULT '1',
  `avatar` varchar(255) DEFAULT NULL,
  `userrole` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'pminh','$2a$10$RL0rTJd2ThLmCzYHMhz9aOBBZfA8ybYpa3Ugl9ds.Pkb8AjtSHWua','Pham','Minh','pminh723@gmail.com',388514487,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','ADMIN'),(2,'taixe1','$2a$10$RL0rTJd2ThLmCzYHMhz9aOBBZfA8ybYpa3Ugl9ds.Pkb8AjtSHWua','Nguyen','A','taixe1@gmail.com',111111111,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','DRIVER'),(3,'taixe2','$2a$10$RL0rTJd2ThLmCzYHMhz9aOBBZfA8ybYpa3Ugl9ds.Pkb8AjtSHWua','Nguyen','B','taixe2@gmail.com',222222222,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','DRIVER'),(4,'khachhang1','$2a$10$RL0rTJd2ThLmCzYHMhz9aOBBZfA8ybYpa3Ugl9ds.Pkb8AjtSHWua','Nguyen','C','khachhang1@gmail.com',333333333,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','USER'),(32,NULL,NULL,'Pham','Minh','pminh723@gmail.com',388514487,NULL,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','GUEST'),(35,NULL,NULL,'Pham','Minh','pminh@gmail.com',123456,NULL,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','GUEST'),(36,NULL,NULL,'Pham','Minh','pminh@gmail.com',123456,NULL,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','GUEST'),(37,NULL,NULL,'Pham','Minh','pminh@gmail.com',123456,NULL,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','GUEST'),(38,'diem123','$2a$10$zRch9M1Pirr5B5dm2mD0iu2b00AAAskTYngxHd6DH1clPhF8r7GKm','Pham','Minh','pminh723@gmail.com',388514487,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','USER'),(39,'helloworld','$2a$10$qQ1yYdrz8L8paMWRvqhYU.noCPXAmVetI8r29nej06aTBRK29a7Ma','Pham','Minh','pminh723@gmail.com',388514487,1,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','USER'),(40,NULL,NULL,'Pham','Minh','pminh723@gmail.com',388514487,NULL,'https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg','GUEST');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlbanvexe'
--

--
-- Dumping routines for database 'qlbanvexe'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-29 18:58:33
