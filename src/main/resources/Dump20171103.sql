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
  `attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `Value` varchar(45) NOT NULL,
  `Object_type_id` int(11) NOT NULL,
  PRIMARY KEY (`attr_id`,`Object_type_id`),
  KEY `fk_Attributes_Object_type1_idx` (`Object_type_id`),
  CONSTRAINT `fk_Attributes_Object_type1` FOREIGN KEY (`Object_type_id`) REFERENCES `object_type` (`Object_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributes`
--

LOCK TABLES `attributes` WRITE;
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` VALUES (1,'Состояние',1),(2,'Сезон',1),(3,'Вид одежды',1),(4,'Размер',1),(5,'Цена',1),(6,'Пользователь',1),(7,'Состояние',2),(8,'Сезон',2),(9,'Вид одежды',2),(10,'Размер',2),(11,'Цена',2),(12,'Пользователь',2),(13,'Состояние',3),(14,'Сезон',3),(15,'Вид обуви',3),(16,'Размер',3),(17,'Цена',3),(18,'Пользователь',3),(19,'Состояние',4),(20,'Сезон',4),(21,'Вид обуви',4),(22,'Размер',4),(23,'Цена',4),(24,'Пользователь',4),(25,'Состояние',5),(26,'Тип',5),(27,'Цена',5),(28,'Пользователь',5),(29,'Состояние',6),(30,'Тип аксессуара',6),(31,'Для кого (М / Ж)',6),(32,'Цена',6),(33,'Пользователь',6),(34,'Состояние',7),(35,'Тип',7),(36,'Гарантийный срок',7),(37,'Производитель/импортер',7),(38,'Цена',7),(39,'Пользователь',7),(40,'Состояние',8),(41,'Цена',8),(42,'Пользователь',8),(43,'Состояние',9),(44,'Цена',9),(45,'Пользователь',9),(46,'Высота',10),(47,'Цена',10),(48,'Пользователь',10),(49,'Состояние',11),(50,'Тип',11),(51,'Вид',11),(52,'Гарантийный срок',11),(53,'Цена',11),(54,'Пользователь',11),(55,'Количество комнат',12),(56,'Общая площадь',12),(57,'Этаж',12),(58,'Состояние',12),(59,'Год постройки',12),(60,'Цена',12),(61,'Пользователь',12),(62,'Состояние',13),(63,'Наличие балктна',13),(64,'Наличие  мебели',13),(65,'Тип аренды',13),(66,'Цена',13),(67,'Пользователь',13),(68,'Количество комнат',14),(69,'Общая площадь',14),(70,'Состояние',14),(71,'Адрес',14),(72,'Год постройки',14),(73,'Материал стен',14),(74,'Цена',14),(75,'Пользователь',14),(76,'Наличие охраны',15),(77,'Адрес',15),(78,'Цена',15),(79,'Пользователь',15),(80,'Площадь',16),(81,'Местонахождение',16),(82,'Цена',16),(83,'Пользователь',16),(84,'Состояние',17),(85,'Производитель',17),(86,'Тип',17),(87,'Цена',17),(88,'Пользователь',17),(89,'Состояние',18),(90,'Тип',18),(91,'Разрешение',18),(92,'Производитель',18),(93,'Цена',18),(94,'Пользователь',18),(95,'Состояние',19),(96,'Тип',19),(97,'Процессор',19),(98,'Разрешение экрана',19),(99,'Производитель',19),(100,'Оперативная память',19),(101,'Цена',19),(102,'Пользователь',19),(103,'Состояние',20),(104,'Тип',20),(105,'Марка',20),(106,'Диагональ экрана',20),(107,'Цена',20),(108,'Пользователь',20),(109,'Состояние',21),(110,'Тип',21),(111,'Производитель',21),(112,'Выход HDMI',21),(113,'USB',21),(114,'Цена',21),(115,'Пользователь',21),(116,'Марка',22),(117,'Модель',22),(118,'Год',22),(119,'Пробег',22),(120,'Тип кузова',22),(121,'Тип двигателя',22),(122,'Цвет',22),(123,'Цена',22),(124,'Пользователь',22),(125,'Марка',23),(126,'Год',23),(127,'Пробег',23),(128,'Цвет',23),(129,'Цена',23),(130,'Пользователь',23),(131,'Тип',24),(132,'Год',24),(133,'Состояние',24),(134,'Цена',24),(135,'Пользователь',24),(136,'Тип',25),(137,'Состояние',25),(138,'Диаметр',25),(139,'Цена',25),(140,'Пользователь',25),(141,'Тип',26),(142,'Состояние',26),(143,'Цена',26),(144,'Пользователь',26),(145,'Состояние',27),(146,'Длина',27),(147,'Ширина',27),(148,'Высота',27),(149,'Цена',27),(150,'Пользователь',27),(151,'Масса',28),(152,'Цена',28),(153,'Пользователь',28),(154,'Количество',29),(155,'Цена',29),(156,'Пользователь',29),(157,'Тип',30),(158,'Состояние',30),(159,'Гарантия',30),(160,'Цена',30),(161,'Пользователь',30),(162,'Тип',31),(163,'Состояние',31),(164,'Цена',31),(165,'Пользователь',31),(166,'Вид',32),(167,'Пол',32),(168,'Возраст',32),(169,'Цена',32),(170,'Пользователь',32),(171,'Вид',33),(172,'Цена',33),(173,'Пользователь',33),(174,'Тип',34),(175,'Состояние',34),(176,'Цена',34),(177,'Пользователь',34),(178,'ID',35),(179,'ФИО',35),(180,'Телефон',35),(181,'Электронная почта',35),(182,'Дата рождения',35),(183,'Местоположение',35),(184,'Пол',35);
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object`
--

DROP TABLE IF EXISTS `object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object` (
  `Object_id` int(11) NOT NULL AUTO_INCREMENT,
  `Object_type_id` int(11) NOT NULL,
  PRIMARY KEY (`Object_id`,`Object_type_id`),
  KEY `fk_Object_Object_type1_idx` (`Object_type_id`),
  CONSTRAINT `fk_Object_Object_type1` FOREIGN KEY (`Object_type_id`) REFERENCES `object_type` (`Object_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object`
--

LOCK TABLES `object` WRITE;
/*!40000 ALTER TABLE `object` DISABLE KEYS */;
INSERT INTO `object` VALUES (7,1),(8,1),(9,1),(10,2),(11,2),(12,2),(13,12),(14,12),(20,17),(15,20),(16,20),(17,20),(18,20),(19,20),(1,35),(2,35),(3,35),(4,35),(5,35),(6,35);
/*!40000 ALTER TABLE `object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_type`
--

DROP TABLE IF EXISTS `object_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_type` (
  `Object_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `Value` varchar(45) NOT NULL,
  `Supercategory` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Object_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_type`
--

LOCK TABLES `object_type` WRITE;
/*!40000 ALTER TABLE `object_type` DISABLE KEYS */;
INSERT INTO `object_type` VALUES (1,'Мужская одежда','Мода и стиль'),(2,'Женская одежда','Мода и стиль'),(3,'Мужская обувь','Мода и стиль'),(4,'Женская обувь','Мода и стиль'),(5,'Косметика и парфюмерия','Мода и стиль'),(6,'Аксессуары и часы','Мода и стиль'),(7,'Мебель и интерьер','Все для дома'),(8,'Хозяйственные товары','Все для дома'),(9,'Посуда и кухонные принадлежности','Все для дома'),(10,'Комнатные растения','Все для дома'),(11,'Бытовая техника','Все для дома'),(12,'Квартиры','Недвижимость'),(13,'Комнаты','Недвижимость'),(14,'Дома, дачи, коттеджи','Недвижимость'),(15,'Гаражи','Недвижимость'),(16,'Участки','Недвижимость'),(17,'Аудиотехника','Техника'),(18,'ТВ и видеотехника','Техника'),(19,'Компьютер и комплектующие','Техника'),(20,'Телефоны','Техника'),(21,'Игры и приставки','Техника'),(22,'Легковые авто','Авто и транспорт'),(23,'Мотоциклы','Авто и транспорт'),(24,'Тракторы и сельхозтехника','Авто и транспорт'),(25,'Шины и диски','Авто и транспорт'),(26,'Запчасти','Авто и транспорт'),(27,'Теплицы','Сад и огород'),(28,'Удобрения','Сад и огород'),(29,'Семена','Сад и огород'),(30,'Садовая техника и инвентарь','Сад и огород'),(31,'Садовая мебель и мангалы','Сад и огород'),(32,'Домашние питомцы','Животные'),(33,'Сельхоз животные','Животные'),(34,'Товары для животных','Животные'),(35,'Пользователь',NULL);
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
INSERT INTO `user_roles` VALUES (2,1),(1,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'IvanTkachev','$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'),(2,'nikak123','$2a$11$qWmKH9T0HbMGQu64hNnN/u.qkri75.mFLRqhgG9zOoEXKi6WA0kfe');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `values`
--

DROP TABLE IF EXISTS `values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `values` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `Object_id` int(11) NOT NULL,
  `Attributes_attr_id` int(11) NOT NULL,
  `Value` varchar(45) NOT NULL,
  PRIMARY KEY (`value_id`,`Object_id`,`Attributes_attr_id`),
  KEY `fk_Values_Object_idx` (`Object_id`),
  KEY `fk_Values_Attributes1_idx` (`Attributes_attr_id`),
  CONSTRAINT `fk_Values_Attributes1` FOREIGN KEY (`Attributes_attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Values_Object` FOREIGN KEY (`Object_id`) REFERENCES `object` (`Object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `values`
--

LOCK TABLES `values` WRITE;
/*!40000 ALTER TABLE `values` DISABLE KEYS */;
INSERT INTO `values` VALUES (1,1,178,'Еще нету'),(2,1,179,'Иванов Иван Иванович'),(3,1,180,'+375-29-199-91-19'),(4,1,181,'vanya@m.com'),(5,1,182,'23.09.2006'),(6,1,183,'г. Минск'),(7,1,184,'М'),(8,2,178,'Еще нету'),(9,2,179,'Петров Петр Петрович'),(10,2,180,'345-91-19'),(11,2,181,'tnya@mail.ru'),(12,2,182,'18.01.1990'),(13,2,183,'г. Борисов'),(14,2,184,'М'),(15,3,178,'Еще нету'),(16,3,179,'Навальная Надежда Надеждовна'),(17,3,180,'066-33-22'),(18,3,181,'nadya@gmail.by'),(19,3,182,'13.05.1994'),(20,3,183,'д. Старинки'),(21,3,184,'Ж'),(22,4,178,'Еще нету'),(23,4,179,'Сидоров Алекс'),(24,4,180,'333-666-0'),(25,4,181,'bmw@x.xxx'),(26,4,182,'01.01.1961'),(27,4,183,'г. Нью-Йорк'),(28,4,184,'М'),(29,5,178,'Еще нету'),(30,5,179,'Светланова Светлана'),(31,5,180,'Красненький'),(32,5,181,'220102'),(33,5,182,'28.02.1997'),(34,5,183,'г. Брест'),(35,5,184,'Ж'),(36,6,178,'Еще нету'),(37,6,179,'Старый Иван Федерович'),(38,6,180,'8 029 379 83 13'),(39,6,181,'Голубь Белый'),(40,6,182,'10.11.1834'),(41,6,183,'г. Менеск'),(42,6,184,'М'),(43,7,1,'Новове'),(44,7,2,'Лето'),(45,7,3,'Майка'),(46,7,4,'35'),(47,7,5,'35 BYN'),(48,7,6,'Еще нету'),(49,8,1,'Поношеное'),(50,8,2,'Весна-осень'),(51,8,3,'Куртка'),(52,8,4,'40'),(53,8,5,'60 BYN'),(54,8,6,'Еще нету'),(55,9,1,'Хорошее'),(56,9,2,'Круглый год'),(57,9,3,'Пуховик'),(58,9,4,'38'),(59,9,5,'5 BYN'),(60,9,6,'Еще нету'),(61,10,7,'Отличное'),(62,10,8,'Круглый год'),(63,10,9,'Блузка'),(64,10,10,'24'),(65,10,11,'500 BYN'),(66,10,12,'Еще нету'),(67,11,7,'Прекрасное'),(68,11,8,'Зима'),(69,11,9,'Юбка'),(70,11,10,'Маленький'),(71,11,11,'13 BYN'),(72,11,12,'Еще нету'),(73,12,7,'Замечательное'),(74,12,8,'Осень'),(75,12,9,'Колготки'),(76,12,10,'30'),(77,12,11,'8 $'),(78,12,12,'Еще нету'),(79,13,55,'1'),(80,13,56,'50 кв.м.'),(81,13,57,'5'),(82,13,58,'После ремонта'),(83,13,59,'2016'),(84,13,60,'50000 BYN'),(85,13,61,'Еще нету'),(86,14,55,'2'),(87,14,56,'43 кв.м.'),(88,14,57,'7'),(89,14,58,'Перед ремонтом'),(90,14,59,'1947'),(91,14,60,'25000 $'),(92,14,61,'Еще нету'),(93,15,103,'Побитый'),(94,15,104,'Слайдер'),(95,15,105,'BenQ-Siemens EL71'),(96,15,106,'2'),(97,15,107,'50 BYN'),(98,15,108,'Еще нету'),(99,16,103,'С царапинами'),(100,16,104,'Кирпич'),(101,16,105,'Nokia 3310'),(102,16,106,'2.4'),(103,16,107,'100500 BYN'),(104,16,108,'Еще нету'),(105,17,103,'Новый'),(106,17,104,'Лопата'),(107,17,105,'Huawei P8 max'),(108,17,106,'6.8'),(109,17,107,'3000 BYN'),(110,17,108,'Еще нету'),(111,18,103,'Отличное'),(112,18,104,'Бомба'),(113,18,105,'Samsung Galaxy Note7'),(114,18,106,'5.7'),(115,18,107,'750 BYN'),(116,18,108,'Еще нету'),(117,19,103,'Работает'),(118,19,104,'Обычный'),(119,19,105,'LG G2 mini'),(120,19,106,'4.7'),(121,19,107,'200 BYN'),(122,19,108,'Еще нету'),(123,20,84,'Хорошее'),(124,20,85,'Sven'),(125,20,86,'Акустика'),(126,20,87,'237 BYN'),(127,20,88,'Еще нету');
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

-- Dump completed on 2017-11-03 23:46:43
