CREATE DATABASE  IF NOT EXISTS `kino_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kino_test`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: kino_test
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `storyLine` text,
  `language` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `ageLimit` varchar(45) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL,
  `length` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Oblivion','2013','Action Adventure Sci-Fi','A veteran assigned to extract Earth\'s remaining resources begins to question what he knows about his mission and himself.','English','USA','2013-04-11','13','soon','3d',NULL),(2,'G.I. Joe: Retaliation','2013','Action Adventure Sci-Fi','The G.I. Joes are not only fighting their mortal enemy Cobra; they are forced to contend with threats from within the government that jeopardize their very existence.','English','USA','2013-03-28','13','current','3d',NULL),(3,'movie3','2012','Comedy','Bla bla sadas aseaa','Dansk','Denmark','2012-12-14','15','current','2d',NULL),(4,'Sin City','2005','Thriller','A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.','English','USA','2028-04-13','18','status','version',NULL),(5,'some movie','','Animation','','','','2013-05-10','15','status','',''),(6,'Sin City','2005','Thriller','A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.','English','USA','2028-04-13','18','status','version',NULL),(7,'Sin City 2','2005','Thriller','A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.','English','USA','2028-04-13','','status','',NULL),(8,'Sin City','2005','Thriller','A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.','English','USA','2028-04-13','18','status','version',NULL),(9,'Sin City','2005','Thriller','A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.','English','USA','2028-04-13','18','status','version',NULL),(10,'some movie','','Animation','','','','2013-05-09','',NULL,'',NULL),(11,'G.I. Joe: Retaliation 2','2013','Animation','The G.I. Joes are not only fighting their mortal enemy Cobra; they are forced to contend with threats from within the government that jeopardize their very existence.','English','USA','2013-03-28','',NULL,'',NULL);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extras`
--

DROP TABLE IF EXISTS `extras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `pricelist_id` int(11) NOT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Extras_pricelist1_idx` (`pricelist_id`),
  CONSTRAINT `fk_Extras_pricelist1` FOREIGN KEY (`pricelist_id`) REFERENCES `pricelist` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extras`
--

LOCK TABLES `extras` WRITE;
/*!40000 ALTER TABLE `extras` DISABLE KEYS */;
INSERT INTO `extras` VALUES (1,'CocaCola',6,0),(2,'Faxe Kondi',6,0),(3,'Tuborg',4,0),(4,'Popcorn(sweet)',1,2),(5,'Popcorn(salty)',1,2),(6,'Daim',5,1),(7,'Twix',5,1);
/*!40000 ALTER TABLE `extras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `movieId` int(11) DEFAULT NULL,
  `session` int(11) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `theater` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (18,'2013-05-07',2,0,'2013-05-10',0),(22,'2013-05-07',11,1,'2013-05-08',0),(23,'2013-05-09',1,2,'2013-05-10',0);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numberOfSeats` int(11) DEFAULT NULL,
  `customerName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `movies_id` int(11) NOT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Reservations_movies1_idx` (`movies_id`),
  CONSTRAINT `fk_Reservations_movies1` FOREIGN KEY (`movies_id`) REFERENCES `movies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,1,'Dovile','1245676543',1,'Maminskaite','dovile@dovile.com'),(2,2,'boihg','1234567890',1,'lkjlkjhk','fd@asd.com'),(3,2,'kjhgf','12345678',1,'kjhg','qwer@qw.com'),(4,2,'fghj','5678901234',1,'jkl','ghjk@fghj.ghj'),(5,2,'qwerty','76521456',1,'lkjhgfds','hgf@tyu.lt'),(6,2,'','',1,'',''),(7,2,'ygftdr','ruydts',1,'yftdr','yrtre'),(8,3,'hgfd','98765432',1,'jhgf','kjhgfds'),(9,2,'fghjkl','234567890',1,'cvbnm','cvbnm'),(10,2,'uytr','4566',1,'r','hg'),(11,3,'Dovile','2345678',1,'Doviliute','hdo@do.com'),(12,1,'ASDFGH','SDFG',1,'ASDFG','ASDF'),(13,1,'ASDF','KL',1,'SDFGHJKL','HJK'),(14,1,'P','P',1,'P','P'),(15,1,'W','E',1,'E','E');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricelist`
--

DROP TABLE IF EXISTS `pricelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pricelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricelist`
--

LOCK TABLES `pricelist` WRITE;
/*!40000 ALTER TABLE `pricelist` DISABLE KEYS */;
INSERT INTO `pricelist` VALUES (1,100),(2,200),(3,350),(4,80),(5,20),(6,40);
/*!40000 ALTER TABLE `pricelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservedseats`
--

DROP TABLE IF EXISTS `reservedseats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservedseats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `seat` int(11) DEFAULT NULL,
  `row` int(11) DEFAULT NULL,
  `theater` int(11) DEFAULT NULL,
  `Reservations_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservedSeats_Reservations1_idx` (`Reservations_id`),
  CONSTRAINT `fk_reservedSeats_Reservations1` FOREIGN KEY (`Reservations_id`) REFERENCES `reservations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservedseats`
--

LOCK TABLES `reservedseats` WRITE;
/*!40000 ALTER TABLE `reservedseats` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservedseats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `extras_id` int(11) NOT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Orders_Extras1_idx` (`extras_id`),
  CONSTRAINT `fk_Orders_Extras1` FOREIGN KEY (`extras_id`) REFERENCES `extras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (30,1,6,11),(31,1,2,11),(32,2,5,11),(33,1,6,9),(34,1,1,11);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-08 17:43:42
