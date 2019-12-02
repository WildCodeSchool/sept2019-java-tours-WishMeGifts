-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: wish_me_gifts
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(145) NOT NULL,
  `adresse` varchar(145) DEFAULT NULL,
  `message` longtext,
  `dateEvent` date DEFAULT NULL,
  `occasion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (52,'k,sks','ssks,s','sk,sksls,','2019-10-30','Autres'),(53,'k,sks','ssks,s','sk,sksls,','2019-10-30','Autres'),(54,'k,sks','ssks,s','sk,sksls,','2019-10-30','Autres'),(55,'zkkzzktest','zk,zkz','zkzkzkzok','2019-11-22','Noël'),(56,'zkkzzktest','zk,zkz','zkzkzkzok','2019-11-22','Noël'),(57,'skssi','q,k,q','zkoz','2019-11-08','Autres'),(58,'hbhsbs','shbhss','sbshsbsh','2019-11-08','Noël'),(59,'dhbhd','shs','bsshsbhs','2019-11-23','Anniversaire'),(60,'testJointure','testJ','testJointures','2019-11-08','Autres'),(61,'test','test','dgvdgddgd','2019-11-15','Naissance'),(62,'test','test','dgvdgddgd','2019-11-15','Naissance'),(63,'test','test','dgvdgddgd','2019-11-15','Naissance'),(64,'hgjhg','ghj','ygjy','2019-11-08','Autres'),(65,'','','','2019-11-15','Autres'),(66,'','','','2019-11-15','Autres'),(67,'','','','2019-11-15','Autres'),(68,'','','','2019-11-15','Autres'),(69,'','','','2019-11-15','Autres'),(70,'','','','2019-11-06','Autres'),(71,'','','','2019-11-06','Autres'),(72,'','','','2019-11-14','Autres'),(73,'','','','2019-11-14','Autres'),(74,'','','','2019-11-07','Autres'),(75,'','','','2019-11-08','Autres'),(76,'','','','2019-11-07','Autres'),(77,'jnsjnsjsn','','','2019-11-07','Autres'),(78,'test','','','2019-11-07','Autres'),(79,'test','','','2019-11-07','Autres'),(80,'test','','','2019-11-07','Autres'),(81,'test','','','2019-11-07','Autres'),(82,'test','','','2019-11-20','Autres'),(83,'test','','','2019-11-20','Autres'),(84,'test','','','2019-11-14','Autres'),(85,'test','','','2019-11-14','Autres'),(86,'test','','','2019-11-14','Autres'),(87,'test','','','2019-11-06','Autres'),(88,'test','','','2019-11-06','Autres'),(89,'test','','','2019-11-06','Autres'),(90,'ok','','','2019-11-07','Autres'),(91,'jjnj','','','2019-10-31','Autres'),(92,'sjs','','','2019-11-15','Naissance'),(93,'test','','','2019-10-31','Naissance'),(94,'test','','','2019-11-07','Autres'),(95,'test','','','2019-11-07','Autres'),(96,'test','','','2019-11-07','Autres'),(97,'test','','','2019-11-07','Autres'),(98,'test','','','2019-11-07','Autres'),(99,'test','jisjsi','','2019-11-07','Autres'),(100,'test','jisjsi','','2019-11-07','Autres'),(101,'test','','','2019-11-15','Anniversaire'),(102,'test','','','2019-11-15','Anniversaire'),(103,'test','sksk','','2019-11-14','Anniversaire'),(104,'test','test','','2019-11-06','Autres'),(105,'test','test','','2019-11-06','Autres'),(106,'test','test','','2019-11-06','Autres'),(107,'test','test','','2019-11-06','Autres'),(108,'test','test','','2019-11-06','Autres'),(109,'test','','','2019-11-12','Anniversaire'),(110,'test','','','2019-11-12','Anniversaire'),(111,'test','','','2019-11-12','Anniversaire'),(112,'test','test','','2019-11-12','Naissance'),(113,'test','test','','2019-11-12','Naissance'),(114,'test','','','2019-11-21','Noël'),(115,'test','','','2019-11-20','Autres'),(116,'ghdydytf','','','2019-11-19','Autres'),(117,'ferfer','','','2019-11-26','Autres'),(118,'test','','','2019-11-20','Autres'),(119,'Anniversaire de Titi','143, rue du grand pont 37000 TOURS','Bonjour, voici ma liste de cadeaux !','2019-11-21','Naissance'),(120,'tss','chez moi','Bonjour jnejejejsjsnsj','2019-12-23','Naissance'),(121,'test','chez moi','Bonjour voici ma liste','2019-12-13','Naissance');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gift`
--

DROP TABLE IF EXISTS `gift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(145) DEFAULT NULL,
  `lien` varchar(145) DEFAULT NULL,
  `id_event_list` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_list_idx` (`id_event_list`),
  CONSTRAINT `fk_list` FOREIGN KEY (`id_event_list`) REFERENCES `event` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gift`
--

LOCK TABLES `gift` WRITE;
/*!40000 ALTER TABLE `gift` DISABLE KEYS */;
INSERT INTO `gift` VALUES (3,'pyjama',NULL,53),(4,'tftdrt','http://de.com',118),(16,'premier cadeau','https://test.com',121),(17,'deuxieme cadeau','https://test.com',121),(18,'deuxieme cadeau','https://test.com',121);
/*!40000 ALTER TABLE `gift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 10:03:48
