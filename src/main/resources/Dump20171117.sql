-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_security_app
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `attributes`
--

DROP TABLE IF EXISTS `attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributes` (
  `attr_id` varchar(36) NOT NULL,
  `Value` varchar(45) NOT NULL,
  `Object_type_id` varchar(36) NOT NULL,
  PRIMARY KEY (`attr_id`,`Object_type_id`),
  KEY `fk_Attributes_Object_type1_idx` (`Object_type_id`),
  CONSTRAINT `fk_Attributes_Object_type1` FOREIGN KEY (`Object_type_id`) REFERENCES `object_type` (`Object_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributes`
--

LOCK TABLES `attributes` WRITE;
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` VALUES ('fcae6055-cbcf-11e7-97a3-94de807a9669','CONDITION','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcb5c185-cbcf-11e7-97a3-94de807a9669','SEASONS','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcbcd3df-cbcf-11e7-97a3-94de807a9669','KIND_OF_CLOTHES','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcce6802-cbcf-11e7-97a3-94de807a9669','SIZE_','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcd7dc6a-cbcf-11e7-97a3-94de807a9669','KIND_OF_SHOES','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcdbbf28-cbcf-11e7-97a3-94de807a9669','TYPE_','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fce25636-cbcf-11e7-97a3-94de807a9669','FOR_WHOM','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fce58ea3-cbcf-11e7-97a3-94de807a9669','GUARANTEE_PERIOD','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fce89f0e-cbcf-11e7-97a3-94de807a9669','HEIGHT','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcebe48e-cbcf-11e7-97a3-94de807a9669','MANUFACTURER_IMPORTER','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fceef8d5-cbcf-11e7-97a3-94de807a9669','KIND','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcf27cb8-cbcf-11e7-97a3-94de807a9669','NUMBER_OF_ROOMS','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fcfd9280-cbcf-11e7-97a3-94de807a9669','TOTAL_AREA','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd033b20-cbcf-11e7-97a3-94de807a9669','FLOOR','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd076387-cbcf-11e7-97a3-94de807a9669','YEAR_OF_CONSTRUCTION','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd0bcd2f-cbcf-11e7-97a3-94de807a9669','PRESENCE_OF_BALCONY','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd0ed1d6-cbcf-11e7-97a3-94de807a9669','AVAILABILITY_OF_FURNITURE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd1231c2-cbcf-11e7-97a3-94de807a9669','TYPE_OF_LEASE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd155db0-cbcf-11e7-97a3-94de807a9669','ADDRESS','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd19c17c-cbcf-11e7-97a3-94de807a9669','WALL_MATERIAL','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd1cd34e-cbcf-11e7-97a3-94de807a9669','PRESENCE_OF_SECURITY','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd1fffff-cbcf-11e7-97a3-94de807a9669','AREA','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd235de6-cbcf-11e7-97a3-94de807a9669','PRODUCT_LOCATION','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd27a0f1-cbcf-11e7-97a3-94de807a9669','MANUFACTURER','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd2ac67b-cbcf-11e7-97a3-94de807a9669','RESOLUTION','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd2e13d9-cbcf-11e7-97a3-94de807a9669','CPU','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd31202e-cbcf-11e7-97a3-94de807a9669','SCREEN_RESOLUTION','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd343389-cbcf-11e7-97a3-94de807a9669','RAM','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd377038-cbcf-11e7-97a3-94de807a9669','BRAND','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd3ddaa2-cbcf-11e7-97a3-94de807a9669','SCREEN_DIAGONAL','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd411f3e-cbcf-11e7-97a3-94de807a9669','HDMI','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd4914ee-cbcf-11e7-97a3-94de807a9669','USB','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd4dc016-cbcf-11e7-97a3-94de807a9669','MODEL','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd50b9f6-cbcf-11e7-97a3-94de807a9669','YEAR','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd5400b1-cbcf-11e7-97a3-94de807a9669','MILEAGE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd5721bd-cbcf-11e7-97a3-94de807a9669','BODY_TYPE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd5a585b-cbcf-11e7-97a3-94de807a9669','ENGINE_TYPE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd5d644f-cbcf-11e7-97a3-94de807a9669','COLOUR','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd610ef4-cbcf-11e7-97a3-94de807a9669','DIAMETER','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd6518de-cbcf-11e7-97a3-94de807a9669','LENGTH','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd6861aa-cbcf-11e7-97a3-94de807a9669','WIDTH','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd6c28e2-cbcf-11e7-97a3-94de807a9669','WEIGHT','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd6ff160-cbcf-11e7-97a3-94de807a9669','AMOUNT','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd74ca4d-cbcf-11e7-97a3-94de807a9669','GUARANTEE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd78f273-cbcf-11e7-97a3-94de807a9669','ANIMAL_GENDER','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd7cc7e8-cbcf-11e7-97a3-94de807a9669','AGE','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd80811d-cbcf-11e7-97a3-94de807a9669','COST','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd846366-cbcf-11e7-97a3-94de807a9669','OWNER','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd87f935-cbcf-11e7-97a3-94de807a9669','CATEGORY','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd8c09c4-cbcf-11e7-97a3-94de807a9669','SUPERCATEGORY','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('fd8fc8a5-cbcf-11e7-97a3-94de807a9669','SECURITY_ID','6bba16df-cbce-11e7-97a3-94de807a9669'),('fd93b41b-cbcf-11e7-97a3-94de807a9669','FULL_NAME','6bba16df-cbce-11e7-97a3-94de807a9669'),('fd97346f-cbcf-11e7-97a3-94de807a9669','USER_GENDER','6bba16df-cbce-11e7-97a3-94de807a9669'),('fd9c98fa-cbcf-11e7-97a3-94de807a9669','TELEPHONE','6bba16df-cbce-11e7-97a3-94de807a9669'),('fda0bbe9-cbcf-11e7-97a3-94de807a9669','BIRTHDAY','6bba16df-cbce-11e7-97a3-94de807a9669'),('fda621dc-cbcf-11e7-97a3-94de807a9669','MAIL','6bba16df-cbce-11e7-97a3-94de807a9669'),('fdad14d4-cbcf-11e7-97a3-94de807a9669','USER_LOCATION','6bba16df-cbce-11e7-97a3-94de807a9669'),('fdb0ebf0-cbcf-11e7-97a3-94de807a9669','TEXT_','6bc34fa0-cbce-11e7-97a3-94de807a9669'),('fdb4da4b-cbcf-11e7-97a3-94de807a9669','USER_MAKER','6bc34fa0-cbce-11e7-97a3-94de807a9669'),('fdb85110-cbcf-11e7-97a3-94de807a9669','USER_REC','6bc34fa0-cbce-11e7-97a3-94de807a9669'),('fdbc8ce6-cbcf-11e7-97a3-94de807a9669','PRODUCT_REC','6bc34fa0-cbce-11e7-97a3-94de807a9669'),('fdc02d2a-cbcf-11e7-97a3-94de807a9669','USER','6bcd906f-cbce-11e7-97a3-94de807a9669'),('fdc55704-cbcf-11e7-97a3-94de807a9669','PRODUCT','6bcd906f-cbce-11e7-97a3-94de807a9669');
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object`
--

DROP TABLE IF EXISTS `object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object` (
  `Object_id` varchar(36) NOT NULL,
  `Object_type_id` varchar(36) NOT NULL,
  PRIMARY KEY (`Object_id`,`Object_type_id`),
  KEY `fk_Object_Object_type1_idx` (`Object_type_id`),
  CONSTRAINT `fk_Object_Object_type1` FOREIGN KEY (`Object_type_id`) REFERENCES `object_type` (`Object_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object`
--

LOCK TABLES `object` WRITE;
/*!40000 ALTER TABLE `object` DISABLE KEYS */;
INSERT INTO `object` VALUES ('12185792-5469-463b-bb2a-620546fd99df','6bba16df-cbce-11e7-97a3-94de807a9669'),('27163d1c-039a-4a8a-8691-fe6f5d6e0314','6bba16df-cbce-11e7-97a3-94de807a9669'),('34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','6bba16df-cbce-11e7-97a3-94de807a9669'),('62f75f36-1898-4fbb-85c0-e87c47132192','6bba16df-cbce-11e7-97a3-94de807a9669'),('a7ffe52a-2361-475b-a994-363f3566a0c5','6bba16df-cbce-11e7-97a3-94de807a9669'),('c7666bf3-4f41-487e-abbc-d70f7860c0ec','6bba16df-cbce-11e7-97a3-94de807a9669'),('0f819b30-7712-4593-ba5d-c6a75e7ee3ae','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('1022f51d-461a-4414-a972-369be658a018','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('19f71a58-03f5-4083-a4c0-76264751ebcc','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('25b6afa2-a627-4af2-95eb-a0aca68089b3','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('38d74a9d-be6d-4abd-987d-445648c43882','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('4596cc26-8c05-420d-a46b-980d2707390e','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('67dd8bff-1e04-40c1-913a-39cabcdef57c','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('834ebc4e-7172-4d09-a901-40e77c34f2c7','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('92610549-70d7-49f3-baf6-da0a28d3338d','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('940366f5-8431-4909-a9f4-f020f9aac8fe','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('ce328c6c-f2fd-4161-956d-ddcd9837f6e7','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('f0a486cf-ae13-4e54-b1d6-a699a2aa8206','6cf4ece3-cbca-11e7-97a3-94de807a9669'),('ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','6cf4ece3-cbca-11e7-97a3-94de807a9669');
/*!40000 ALTER TABLE `object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_type`
--

DROP TABLE IF EXISTS `object_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_type` (
  `Object_type_id` varchar(36) NOT NULL,
  `Value` varchar(45) NOT NULL,
  PRIMARY KEY (`Object_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_type`
--

LOCK TABLES `object_type` WRITE;
/*!40000 ALTER TABLE `object_type` DISABLE KEYS */;
INSERT INTO `object_type` VALUES ('6bba16df-cbce-11e7-97a3-94de807a9669','USER'),('6bc34fa0-cbce-11e7-97a3-94de807a9669','COMMENT'),('6bcd906f-cbce-11e7-97a3-94de807a9669','LIKE'),('6cf4ece3-cbca-11e7-97a3-94de807a9669','PRODUCT');
/*!40000 ALTER TABLE `object_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,1),(3,1),(1,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'IvanTkachev','$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'),(2,'nikak123','$2a$11$qWmKH9T0HbMGQu64hNnN/u.qkri75.mFLRqhgG9zOoEXKi6WA0kfe'),(3,'Darment123','$2a$11$dnJ4HUnu8jnk0vhpueNABOibZxBxwe2V70v9DkbxMRzhFWZON/7Fy');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `values`
--

DROP TABLE IF EXISTS `values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `values` (
  `value_id` varchar(36) NOT NULL,
  `Object_id` varchar(36) NOT NULL,
  `Attributes_attr_id` varchar(36) NOT NULL,
  `Value` varchar(45) NOT NULL,
  PRIMARY KEY (`value_id`,`Object_id`,`Attributes_attr_id`),
  KEY `fk_Values_Object_idx` (`Object_id`),
  KEY `fk_Values_Attributes1_idx` (`Attributes_attr_id`),
  CONSTRAINT `fk_Values_Attributes1` FOREIGN KEY (`Attributes_attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Values_Object` FOREIGN KEY (`Object_id`) REFERENCES `object` (`Object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `values`
--

LOCK TABLES `values` WRITE;
/*!40000 ALTER TABLE `values` DISABLE KEYS */;
INSERT INTO `values` VALUES ('04eb73b3-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('0503b997-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fd87f935-cbcf-11e7-97a3-94de807a9669','WOMEN_CLOTHING'),('0503fde1-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fcce6802-cbcf-11e7-97a3-94de807a9669','30'),('05045dcb-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fcae6055-cbcf-11e7-97a3-94de807a9669','Замечательное'),('050493d0-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fcb5c185-cbcf-11e7-97a3-94de807a9669','Осень'),('051bc60d-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fd80811d-cbcf-11e7-97a3-94de807a9669','8 $'),('051c070f-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Колготки'),('051c4782-cbd7-11e7-97a3-94de807a9669','f0a486cf-ae13-4e54-b1d6-a699a2aa8206','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('0585a666-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('0585f9d4-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fd87f935-cbcf-11e7-97a3-94de807a9669','AUDIO'),('058c06e1-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fcae6055-cbcf-11e7-97a3-94de807a9669','Хорошее'),('058c3392-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fd27a0f1-cbcf-11e7-97a3-94de807a9669','Sven'),('058c84f8-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Акустика'),('058cba8d-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fd80811d-cbcf-11e7-97a3-94de807a9669','237 BYN'),('058ce910-cbd9-11e7-97a3-94de807a9669','834ebc4e-7172-4d09-a901-40e77c34f2c7','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('0899232c-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('08a05b52-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fd93b41b-cbcf-11e7-97a3-94de807a9669','Светланова Светлана'),('08a09d16-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fd97346f-cbcf-11e7-97a3-94de807a9669','Ж'),('08a0ca9c-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fd9c98fa-cbcf-11e7-97a3-94de807a9669','Красненький'),('08abf3f5-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fda0bbe9-cbcf-11e7-97a3-94de807a9669','28.02.1997'),('08ac1beb-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fda621dc-cbcf-11e7-97a3-94de807a9669','220102'),('08ac3f3b-cbda-11e7-97a3-94de807a9669','c7666bf3-4f41-487e-abbc-d70f7860c0ec','fdad14d4-cbcf-11e7-97a3-94de807a9669','г. Брест'),('2e7ab2f2-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('2e7af3ab-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fd93b41b-cbcf-11e7-97a3-94de807a9669','Старый Иван Федерович'),('2e7b3524-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fd97346f-cbcf-11e7-97a3-94de807a9669','М'),('2e7b6bb6-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fd9c98fa-cbcf-11e7-97a3-94de807a9669','8 029 379 83 13'),('2e7baaf2-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fda0bbe9-cbcf-11e7-97a3-94de807a9669','10.11.1834'),('2e7ceb17-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fda621dc-cbcf-11e7-97a3-94de807a9669','Голубь Белый'),('2e7d2c58-cbda-11e7-97a3-94de807a9669','27163d1c-039a-4a8a-8691-fe6f5d6e0314','fdad14d4-cbcf-11e7-97a3-94de807a9669','г. Менеск'),('3a36286a-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('3a367eaf-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fd87f935-cbcf-11e7-97a3-94de807a9669','MEN_CLOTHING'),('3a47b5df-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fcce6802-cbcf-11e7-97a3-94de807a9669','40'),('3a47f21c-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fcae6055-cbcf-11e7-97a3-94de807a9669','Поношенное'),('3a4823aa-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fcb5c185-cbcf-11e7-97a3-94de807a9669','Весна-Осень'),('3a48559b-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fd80811d-cbcf-11e7-97a3-94de807a9669','60 BYN'),('3a488537-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Куртка'),('3a48ac35-cbd7-11e7-97a3-94de807a9669','4596cc26-8c05-420d-a46b-980d2707390e','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('4c3ac884-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('4c3b04c6-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd87f935-cbcf-11e7-97a3-94de807a9669','PHONES'),('4c3b424d-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fcae6055-cbcf-11e7-97a3-94de807a9669','Побитый'),('4c3b747e-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Слайдер'),('4c4d22f5-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd377038-cbcf-11e7-97a3-94de807a9669','BenQ-Siemens EL71'),('4c4d7964-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd3ddaa2-cbcf-11e7-97a3-94de807a9669','2'),('4c4dd290-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd80811d-cbcf-11e7-97a3-94de807a9669','50 BYN'),('4c4e169f-cbd8-11e7-97a3-94de807a9669','ff4ba7bc-167c-43a8-9a6d-ba2fa7021e4c','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('580020f6-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('58139e06-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fd87f935-cbcf-11e7-97a3-94de807a9669','MEN_CLOTHING'),('5813cca8-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fcce6802-cbcf-11e7-97a3-94de807a9669','38'),('5814092e-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fcae6055-cbcf-11e7-97a3-94de807a9669','Хорошее'),('58146718-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fcb5c185-cbcf-11e7-97a3-94de807a9669','Круглый год'),('5814963d-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fd80811d-cbcf-11e7-97a3-94de807a9669','5 BYN'),('5814c005-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Пуховик'),('581f7230-cbd7-11e7-97a3-94de807a9669','ce328c6c-f2fd-4161-956d-ddcd9837f6e7','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('6829f174-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('682a3c1d-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fd93b41b-cbcf-11e7-97a3-94de807a9669','Иванов Иван Иванович'),('6849a9a8-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fd97346f-cbcf-11e7-97a3-94de807a9669','М'),('6865018d-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fd9c98fa-cbcf-11e7-97a3-94de807a9669','+375-29-199-91-19'),('68657c92-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fda0bbe9-cbcf-11e7-97a3-94de807a9669','23.09.2006'),('6865c62a-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fda621dc-cbcf-11e7-97a3-94de807a9669','vanya@m.com'),('6865feae-cbd9-11e7-97a3-94de807a9669','12185792-5469-463b-bb2a-620546fd99df','fdad14d4-cbcf-11e7-97a3-94de807a9669','г. Минск'),('69daea1f-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('69db3272-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd87f935-cbcf-11e7-97a3-94de807a9669','PHONES'),('69db76a6-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fcae6055-cbcf-11e7-97a3-94de807a9669','С царапинками'),('69dbb20b-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Кирпич'),('69dbe933-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd377038-cbcf-11e7-97a3-94de807a9669','Nokia 3310'),('69ddca87-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd3ddaa2-cbcf-11e7-97a3-94de807a9669','2.4'),('69ea274e-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd80811d-cbcf-11e7-97a3-94de807a9669','100500 BYN'),('69ea6268-cbd8-11e7-97a3-94de807a9669','bdf6980e-a2d5-4ccb-add4-7a394de8ce8c','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('89e4dd6b-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('89e63d9e-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd87f935-cbcf-11e7-97a3-94de807a9669','PHONES'),('89e6ae39-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fcae6055-cbcf-11e7-97a3-94de807a9669','Новый'),('89e6e0ed-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Лопата'),('89e74ff1-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd377038-cbcf-11e7-97a3-94de807a9669','Huawei P8 max'),('89e783be-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd3ddaa2-cbcf-11e7-97a3-94de807a9669','6.8'),('89e7b498-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd80811d-cbcf-11e7-97a3-94de807a9669','300 BYN'),('89e80cd9-cbd8-11e7-97a3-94de807a9669','940366f5-8431-4909-a9f4-f020f9aac8fe','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('90c60aab-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('90c65449-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fd93b41b-cbcf-11e7-97a3-94de807a9669','Петров Петр Петрович'),('90c8bf62-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fd97346f-cbcf-11e7-97a3-94de807a9669','М'),('90c91314-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fd9c98fa-cbcf-11e7-97a3-94de807a9669','345-91-19'),('90c97053-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fda0bbe9-cbcf-11e7-97a3-94de807a9669','18.01.1990'),('90ca7097-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fda621dc-cbcf-11e7-97a3-94de807a9669','tnya@mail.ru'),('90d76842-cbd9-11e7-97a3-94de807a9669','34201e4c-efc3-44d6-bf84-b7b1e7ebfe68','fdad14d4-cbcf-11e7-97a3-94de807a9669','г. Борисов'),('9575e7bf-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('9577562f-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fd87f935-cbcf-11e7-97a3-94de807a9669','MEN_CLOTHING'),('95778c97-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fcce6802-cbcf-11e7-97a3-94de807a9669','35'),('95a2ce35-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fcae6055-cbcf-11e7-97a3-94de807a9669','Новое'),('95a33b36-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fcb5c185-cbcf-11e7-97a3-94de807a9669','Лето'),('95a39585-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fd80811d-cbcf-11e7-97a3-94de807a9669','35 BYN'),('95a58ce7-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Майка'),('95a5c43b-cbd5-11e7-97a3-94de807a9669','38d74a9d-be6d-4abd-987d-445648c43882','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('adcd1f30-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('adcd664f-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd87f935-cbcf-11e7-97a3-94de807a9669','PHONES'),('adcddad2-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fcae6055-cbcf-11e7-97a3-94de807a9669','Отличное'),('adce135d-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Бомба'),('adce50b1-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd377038-cbcf-11e7-97a3-94de807a9669','Samsung Galaxy Note7'),('adce83c1-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd3ddaa2-cbcf-11e7-97a3-94de807a9669','5.7'),('adcebcf8-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd80811d-cbcf-11e7-97a3-94de807a9669','750 BYN'),('adcf55f6-cbd8-11e7-97a3-94de807a9669','19f71a58-03f5-4083-a4c0-76264751ebcc','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('bb44b144-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('bb868539-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fd87f935-cbcf-11e7-97a3-94de807a9669','WOMEN_CLOTHING'),('bb86ba40-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fcce6802-cbcf-11e7-97a3-94de807a9669','24'),('bb8723fc-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fcae6055-cbcf-11e7-97a3-94de807a9669','Отличное'),('bb99d240-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fcb5c185-cbcf-11e7-97a3-94de807a9669','Круглый год'),('bb9a0574-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fd80811d-cbcf-11e7-97a3-94de807a9669','500 BYN'),('bb9a3761-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Блузка'),('bb9ba486-cbd6-11e7-97a3-94de807a9669','67dd8bff-1e04-40c1-913a-39cabcdef57c','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('bd4e9002-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('bd5f57ec-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fd93b41b-cbcf-11e7-97a3-94de807a9669','Навальная Надежда Надеждовна'),('bd703063-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fd97346f-cbcf-11e7-97a3-94de807a9669','Ж'),('bd705d2f-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fd9c98fa-cbcf-11e7-97a3-94de807a9669','066-33-22'),('bd708d0f-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fda0bbe9-cbcf-11e7-97a3-94de807a9669','13.05.1994'),('bd70bdd6-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fda621dc-cbcf-11e7-97a3-94de807a9669','nadya@gmail.by'),('bd70e5d3-cbd9-11e7-97a3-94de807a9669','62f75f36-1898-4fbb-85c0-e87c47132192','fdad14d4-cbcf-11e7-97a3-94de807a9669','д. Старинки'),('cd21c784-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Technics'),('cd220d4f-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd87f935-cbcf-11e7-97a3-94de807a9669','PHONES'),('cd224b48-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fcae6055-cbcf-11e7-97a3-94de807a9669','Работает'),('cd228a4f-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fcdbbf28-cbcf-11e7-97a3-94de807a9669','Обычный'),('cd307a40-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd377038-cbcf-11e7-97a3-94de807a9669','LG G2 mini'),('cd30b97e-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd3ddaa2-cbcf-11e7-97a3-94de807a9669','4.7'),('cd30ebe4-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd80811d-cbcf-11e7-97a3-94de807a9669','200 BYN'),('cd311ade-cbd8-11e7-97a3-94de807a9669','92610549-70d7-49f3-baf6-da0a28d3338d','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('d6ff3a07-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd8c09c4-cbcf-11e7-97a3-94de807a9669','House'),('d701d725-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd87f935-cbcf-11e7-97a3-94de807a9669','APARTMENTS'),('d7020fd6-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fcf27cb8-cbcf-11e7-97a3-94de807a9669','1'),('d7024e13-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fcfd9280-cbcf-11e7-97a3-94de807a9669','50 кв.м.'),('d702c4a6-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd033b20-cbcf-11e7-97a3-94de807a9669','5'),('d7031940-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fcae6055-cbcf-11e7-97a3-94de807a9669','После ремонта'),('d732c4c7-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd076387-cbcf-11e7-97a3-94de807a9669','2016'),('d733119b-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd80811d-cbcf-11e7-97a3-94de807a9669','50000 BYN'),('d73391e8-cbd7-11e7-97a3-94de807a9669','1022f51d-461a-4414-a972-369be658a018','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('e1fe2100-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fd8c09c4-cbcf-11e7-97a3-94de807a9669','Fashion'),('e1fe7b1d-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fd87f935-cbcf-11e7-97a3-94de807a9669','WOMEN_CLOTHING'),('e1fef08e-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fcce6802-cbcf-11e7-97a3-94de807a9669','Маленький'),('e1ff9eb6-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fcae6055-cbcf-11e7-97a3-94de807a9669','Прекрасное'),('e22766f6-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fcb5c185-cbcf-11e7-97a3-94de807a9669','Зима'),('e228066e-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fd80811d-cbcf-11e7-97a3-94de807a9669','13 BYN'),('e2288ac7-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fcbcd3df-cbcf-11e7-97a3-94de807a9669','Юбка'),('e228ce19-cbd6-11e7-97a3-94de807a9669','25b6afa2-a627-4af2-95eb-a0aca68089b3','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('e3d9f5b5-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fd8fc8a5-cbcf-11e7-97a3-94de807a9669','Скоро будет'),('e3da3796-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fd93b41b-cbcf-11e7-97a3-94de807a9669','Сидоров Алекс'),('e3da6da5-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fd97346f-cbcf-11e7-97a3-94de807a9669','М'),('e3daa0fd-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fd9c98fa-cbcf-11e7-97a3-94de807a9669','333-666-0'),('e3dae1b4-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fda0bbe9-cbcf-11e7-97a3-94de807a9669','01.01.1961'),('e3db1891-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fda621dc-cbcf-11e7-97a3-94de807a9669','bmw@x.xxx'),('e3f3dfd4-cbd9-11e7-97a3-94de807a9669','a7ffe52a-2361-475b-a994-363f3566a0c5','fdad14d4-cbcf-11e7-97a3-94de807a9669','г. Нью-Йорк'),('f4cd3e97-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd8c09c4-cbcf-11e7-97a3-94de807a9669','House'),('f4cf2443-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd87f935-cbcf-11e7-97a3-94de807a9669','APARTMENTS'),('f4cf76e5-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fcf27cb8-cbcf-11e7-97a3-94de807a9669','2'),('f4d00909-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fcfd9280-cbcf-11e7-97a3-94de807a9669','43 кв.м.'),('f4d0572e-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd033b20-cbcf-11e7-97a3-94de807a9669','7'),('f4ee699a-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fcae6055-cbcf-11e7-97a3-94de807a9669','Перед ремонтом'),('f4eea9b3-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd076387-cbcf-11e7-97a3-94de807a9669','1947'),('f4eed528-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd80811d-cbcf-11e7-97a3-94de807a9669','25000 $'),('f4eefe13-cbd7-11e7-97a3-94de807a9669','0f819b30-7712-4593-ba5d-c6a75e7ee3ae','fd846366-cbcf-11e7-97a3-94de807a9669','Скоро будет');
/*!40000 ALTER TABLE `values` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-17 23:11:15
