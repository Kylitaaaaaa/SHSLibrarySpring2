CREATE DATABASE  IF NOT EXISTS `shslibrary` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shslibrary`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: shslibrary
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `middle_initial` varchar(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `secret_question` varchar(200) DEFAULT NULL,
  `secret_answer` varchar(50) DEFAULT NULL,
  `admin_type` int(1) DEFAULT NULL COMMENT '0 - Administrator\n1 - Library Manager\n2 - Library Staff',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Gon','Trax','T.','1979-04-02','Which hospital were you born?','St. Luke',1),(3,'Jack','Gil','C.','1990-01-20','What is your first pet\'s name?','Doggo',0),(8,'Tracey','Maximillian','R.','1975-03-03','What is your favorite food?','PishBulz',2),(10,'Madie','Lim','H.','1970-05-04','What is your first pet\'s name?','Cate',0);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '0 - Book\n1 - Thesis\n2 - Magazines',
  `author` varchar(90) DEFAULT NULL,
  `publisher` varchar(60) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0 - Available\n1 - Reserved\n2 - Borrowed',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'The Rise of the Boy',0,'Magenta Black','The New Inc.',2000,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0),(2,'The Return of the Boy',0,'Magenta Black','The New Inc.',2001,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0),(3,'The Death of the Boy',0,'Magenta Black','The New Inc.',2002,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0),(4,'Mastering Dodgeball',0,'Barry Lock','Shoot Right Inc.',2008,'Shelf 21, 7F (Circulation), Henry Sy Sr. Hall',0),(5,'The Lion, the Witch and the Wardrobe ',0,'Clive Staples Lewis','HarperCollins',1950,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(6,'Prince Caspian: The Return to Narnia',0,'Clive Staples Lewis','HarperCollins',1951,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(7,'The Voyage of the Dawn Treader',0,'Clive Staples Lewis','HarperCollins',1952,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(8,'The Silver Chair',0,'Clive Staples Lewis','HarperCollins',1953,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(9,'The Horse and His Boy',0,'Clive Staples Lewis','HarperCollins',1954,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(10,'The Magician\'s Nephew',0,'Clive Staples Lewis','HarperCollins',1955,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(11,'The Last Battle',0,'Clive Staples Lewis','HarperCollins',1956,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0),(12,'Smaller and Smaller Circles',0,'Felisa Batacan','University of the Philippines Press ',2002,'Shelf 57, 7F (Circulation), Henry Sy Sr. Hall',0),(13,'The Philosopher\'s Stone',0,'J. K. Rowling','Bloomsbury Publishing',1997,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(14,'The Chamber of Secrets',0,'J. K. Rowling','Bloomsbury Publishing',1998,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(15,'The Prisoner of Azkaban',0,'J. K. Rowling','Bloomsbury Publishing',1999,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(16,'The Goblet of Fire',0,'J. K. Rowling','Bloomsbury Publishing',2000,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(17,'The Order of the Phoenix ',0,'J. K. Rowling','Bloomsbury Publishing',2003,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(18,'The Half-Blood Prince',0,'J. K. Rowling','Bloomsbury Publishing',2005,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(19,'The Deathly Hallows',0,'J. K. Rowling','Bloomsbury Publishing',2007,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0),(20,'Times Magazine:2016',2,'Nancy Gibbs','Time Inc',2016,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(21,'Times Magazine:2015',2,'Nancy Gibbs','Time Inc',2015,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(22,'Times Magazine:2014',2,'Nancy Gibbs','Time Inc',2014,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(23,'Times Magazine:2013',2,'Nancy Gibbs','Time Inc',2013,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(24,'Times Magazine:2012',2,'Nancy Gibbs','Time Inc',2012,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(25,'Times Magazine:2011',2,'Nancy Gibbs','Time Inc',2011,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(26,'Times Magazine:2010',2,'Nancy Gibbs','Time Inc',2010,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0),(27,'K-Zone Philippines:2001',2,'Daniel Findlay','Pacific Magazines',2001,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(28,'K-Zone Philippines:2002',2,'Daniel Findlay','Pacific Magazines',2002,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(29,'K-Zone Philippines:2003',2,'Daniel Findlay','Pacific Magazines',2003,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(30,'K-Zone Philippines:2004',2,'Daniel Findlay','Pacific Magazines',2004,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(31,'K-Zone Philippines:2005',2,'Daniel Findlay','Pacific Magazines',2005,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(32,'K-Zone Philippines:2006',2,'Daniel Findlay','Pacific Magazines',2006,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(33,'K-Zone Philippines:2007',2,'Daniel Findlay','Pacific Magazines',2007,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0),(34,'Effectiveness of EEG Signals in Detecting Stress Level While Sleeping',1,'Jonathan Campana','IEEE',2010,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(35,'Traffic Model Using CCTV Cameras',1,'Badjao Kalabiri','IEEE',2012,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(36,'Friction Resistant Bullets ',1,'Kamani Pataka','IEEE',2015,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(37,'Advantages of IoT Underwater',1,'Asamani Deku','IEEE',2016,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(38,'Disadvantages of Using Infrared During Blizzard',1,'Machu Piku','IEEE',2009,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(39,'Medical Use of Arwana Together With Ultra-Violet Lights',1,'Ariana Swert','IEEE',2001,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(40,'Summary of the Models in Predicting Nuclear Disasters',1,'Dishan Jikhama','IEEE',2008,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(41,'Zigzag Effects of Zigzag Lines in Engineering',1,'Zoro Ampato','IEEE',2003,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0),(42,'The Last Lecture',0,'Randy Pausch','Hyperion',2008,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(43,'Le Petit Prince',0,'Antoine de Saint-Exupéry','Gallimard',1943,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(44,'Tuesdays with Morrie',0,'Mitch Albom','Doubleday',1997,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(45,'Divergent',0,'Veronica Roth','Katherine Tegen Books',2011,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(46,'Insurgent ',0,'Veronica Roth','Katherine Tegen Books',2012,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(47,'Allegiant',0,'Veronica Roth','Katherine Tegen Books',2013,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(48,'Four: A Divergent Collection',0,'Veronica Roth','Katherine Tegen Books',2013,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(49,'Jonathan Livingston Seagull',0,'Richard Bach','Macmillan',1970,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0),(50,'The Catcher in the Rye',0,'Jerome David Salinger','Little, Brown and Company',1951,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_log`
--

DROP TABLE IF EXISTS `book_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_log` (
  `book_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `borrow_id` int(8) DEFAULT NULL,
  `reservation_date` date NOT NULL,
  `borrow_date` date NOT NULL,
  `expected_return_date` date NOT NULL,
  `actual_return_date` date DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0 - Not Yet Returned\n1 - Returned\n2 - Overdue\n3 - Reserved',
  PRIMARY KEY (`book_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_log`
--

LOCK TABLES `book_log` WRITE;
/*!40000 ALTER TABLE `book_log` DISABLE KEYS */;
INSERT INTO `book_log` VALUES (1,1,4,'2010-03-02','2010-03-03','2010-04-02','2010-03-20',1),(2,1,5,'2010-03-21','2010-03-22','2010-03-29','2010-03-30',2),(3,2,7,'2010-03-03','2010-03-04','2010-03-11','2010-03-09',1);
/*!40000 ALTER TABLE `book_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `middle_initial` varchar(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `secret_question` varchar(200) DEFAULT NULL,
  `secret_answer` varchar(50) DEFAULT NULL,
  `customer_type` int(1) DEFAULT NULL COMMENT '0 - Professor\n1 - Student',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (2,'Arnold','Tan','G.','1999-02-20','What animal do you like the most?','Elephant',1),(4,'Jen','Posh','K.','1970-03-12','What is your mother\'s maiden name?','Kabanalan',0),(5,'Mario','Mayaboy','L.','1999-03-09','What is your mother\'s maiden name?','Magtago',1),(6,'Camille','Leon','K.','2000-09-10','What animal do you like the most?','Ant',1),(7,'Dan','Masa','L.','2000-09-03','What is your favorite food?','Porkchop',1),(9,'Peter','Pandacan','Q.','1980-07-04','What is your first pet\'s name?','Burrito',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting_room`
--

DROP TABLE IF EXISTS `meeting_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting_room` (
  `meeting_room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(45) DEFAULT NULL,
  `room_status` int(1) DEFAULT NULL COMMENT '0 - Free\n1 - Reserved\n2 - Under Maintenance',
  PRIMARY KEY (`meeting_room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting_room`
--

LOCK TABLES `meeting_room` WRITE;
/*!40000 ALTER TABLE `meeting_room` DISABLE KEYS */;
INSERT INTO `meeting_room` VALUES (1,'G301',NULL);
/*!40000 ALTER TABLE `meeting_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `review_content` varchar(300) NOT NULL,
  `user_id` int(11) NOT NULL,
  `review_date` date NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `bookId_idx` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,1,'Cool Book',4,'0000-00-00'),(2,1,'Nice Book',5,'0000-00-00'),(3,2,'Great Book',7,'0000-00-00'),(4,1,'Can be Improved',4,'0000-00-00');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_log`
--

DROP TABLE IF EXISTS `room_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_log` (
  `room_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `reservation_date` datetime DEFAULT NULL,
  `status` varchar(45) CHARACTER SET big5 DEFAULT NULL COMMENT '0 - No Show\n1 - Facility Used',
  `date_reserved` datetime DEFAULT NULL,
  PRIMARY KEY (`room_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_log`
--

LOCK TABLES `room_log` WRITE;
/*!40000 ALTER TABLE `room_log` DISABLE KEYS */;
INSERT INTO `room_log` VALUES (1,1,'1:00:00','2:00:00','2001-09-20 00:00:00','1','2001-09-20 00:00:00'),(2,1,'3:00:00','4:00:00','2001-09-20 00:00:00','1','2001-09-20 00:00:00');
/*!40000 ALTER TABLE `room_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_reservation`
--

DROP TABLE IF EXISTS `room_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_reservation` (
  `room_reservation_id` varchar(255) NOT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `meeting_room_id` int(11) NOT NULL,
  `reservation_date` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `usage_date` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`room_reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_reservation`
--

LOCK TABLES `room_reservation` WRITE;
/*!40000 ALTER TABLE `room_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '0 - Admin\n1 - Customer',
  `id_number` int(8) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_type` int(1) NOT NULL COMMENT '0 - Admin\n1 - Customer\n',
  `email_address` varchar(100) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `lock_status` int(1) NOT NULL DEFAULT '0' COMMENT '0 - unlocked\n1 - locked',
  `login_attempts` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`id_number`,`email_address`,`phone_number`),
  KEY `userId_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,20092140,'Re5+0',0,'gon.trax@dlsu.edu.ph','09338899209',0,0),(2,11209039,'Stegosaurus1!',1,'arnold_tan@dlsu.edu.ph','09235023592',1,4),(3,20080908,'K@bay0',0,'jack.gil@dlsu.edu.ph','09501492900',0,0),(4,20082918,'Und0rGround$',1,'jen.posh@dlsu.edu.ph','09235230928',0,0),(5,11325536,'B@dB0yZ',1,'mario_mayaboy@dlsu.edu.ph','09233333334',0,0),(6,11423532,'C@m1ll3',1,'camille_leon@dlsu.edu.ph','09534399300',0,0),(7,11290909,'PocariSwe@7',1,'dan_masa@dlsu.edu.ph','09235902339',0,0),(8,20024030,'Mech@n!cz',0,'tracey.maximillian@dlsu.edu.ph','09253533332',0,0),(9,20050404,'amB@h0',1,'peter.pandacan@dlsu.edu.ph','09435443222',0,0),(10,20113939,'m@d!liM',0,'madie.lim@dlsu.edu.ph','09245421800',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'shslibrary'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-30  2:14:25
