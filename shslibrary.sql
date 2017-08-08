CREATE DATABASE  IF NOT EXISTS `shslibrary` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shslibrary`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: shslibrary
-- ------------------------------------------------------
-- Server version	5.7.13

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
  `admin_type` int(11) NOT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_initial` varchar(255) DEFAULT NULL,
  `secret_answer` varchar(255) DEFAULT NULL,
  `secret_question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
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
  `author` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroom`
--

DROP TABLE IF EXISTS `meetingroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroom` (
  `meetingroomid` int(11) NOT NULL AUTO_INCREMENT,
  `roomname` varchar(45) NOT NULL,
  `roomstatus` int(1) NOT NULL COMMENT '0 - Free\n1 - Reserved\n2 - Under Maintenance',
  PRIMARY KEY (`meetingroomid`),
  UNIQUE KEY `meetingroomid_UNIQUE` (`meetingroomid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroom`
--

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
INSERT INTO `meetingroom` VALUES (1,'G301',0);
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroomreservation`
--

DROP TABLE IF EXISTS `meetingroomreservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroomreservation` (
  `mrresid` int(11) NOT NULL AUTO_INCREMENT,
  `endtime` varchar(255) NOT NULL,
  `mrid` int(11) NOT NULL,
  `resdate` varchar(255) NOT NULL,
  `starttime` varchar(255) NOT NULL,
  `usagedate` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`mrresid`),
  UNIQUE KEY `mrresid_UNIQUE` (`mrresid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroomreservation`
--

LOCK TABLES `meetingroomreservation` WRITE;
/*!40000 ALTER TABLE `meetingroomreservation` DISABLE KEYS */;
INSERT INTO `meetingroomreservation` VALUES (1,'sad',3,'asd','asd','asd',1);
/*!40000 ALTER TABLE `meetingroomreservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `booktype` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`bookid`),
  UNIQUE KEY `bookid_UNIQUE` (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourcereservation`
--

DROP TABLE IF EXISTS `resourcereservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourcereservation` (
  `resid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `userid` int(8) NOT NULL,
  `reservationdate` varchar(100) NOT NULL,
  `borrowdate` varchar(100) NOT NULL,
  `returndate` varchar(100) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0 - returned\n1 - not returned\n2- reserved',
  PRIMARY KEY (`resid`),
  UNIQUE KEY `resid_UNIQUE` (`resid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourcereservation`
--

LOCK TABLES `resourcereservation` WRITE;
/*!40000 ALTER TABLE `resourcereservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `resourcereservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `reviewid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `reviewcontent` varchar(300) NOT NULL,
  `userid` int(11) NOT NULL,
  `reviewdate` date NOT NULL,
  PRIMARY KEY (`reviewid`),
  UNIQUE KEY `review_id_UNIQUE` (`reviewid`),
  KEY `bookId_idx` (`bookid`)
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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomreservation`
--

DROP TABLE IF EXISTS `roomreservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomreservation` (
  `mrresid` int(11) NOT NULL AUTO_INCREMENT,
  `endtime` varchar(255) NOT NULL,
  `mrid` int(11) NOT NULL,
  `resdate` varchar(255) NOT NULL,
  `starttime` varchar(255) NOT NULL,
  `usagedate` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`mrresid`),
  UNIQUE KEY `mrresid_UNIQUE` (`mrresid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomreservation`
--

LOCK TABLES `roomreservation` WRITE;
/*!40000 ALTER TABLE `roomreservation` DISABLE KEYS */;
INSERT INTO `roomreservation` VALUES (1,'asd',2,'sad','asd','asd',2);
/*!40000 ALTER TABLE `roomreservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '0 - Admin\n1 - Customer',
  `idnumber` int(8) NOT NULL,
  `password` varchar(100) NOT NULL,
  `usertype` int(1) NOT NULL COMMENT '0 - Admin\n1 - Customer\n',
  `emailaddress` varchar(100) NOT NULL,
  `phonenumber` varchar(1000) NOT NULL,
  `lockstatus` int(1) NOT NULL DEFAULT '0' COMMENT '0 - unlocked\n1 - locked',
  `loginattempts` int(1) NOT NULL DEFAULT '0',
  `firstname` varchar(1000) DEFAULT NULL,
  `middleinitial` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `secretquestion` varchar(45) DEFAULT NULL,
  `secretanswer` varchar(45) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `id_number` int(11) DEFAULT NULL,
  `lock_status` int(11) DEFAULT NULL,
  `login_attempts` int(11) DEFAULT NULL,
  `phone_number` varchar(1000) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`,`idnumber`),
  UNIQUE KEY `idnumber_UNIQUE` (`idnumber`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  KEY `userId_idx` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,20092140,'Re5+0',1,'gon.trax@dlsu.edu.ph','09338899209',0,0,'1','1','1','1','1',NULL,0,NULL,0,0,0,NULL,0),(2,11209039,'Stegosaurus1!',1,'arnold_tan@dlsu.edu.ph','09235023592',0,4,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(3,20080908,'K@bay0',0,'jack.gil@dlsu.edu.ph','09501492900',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(4,20082918,'Und0rGround$',1,'jen.posh@dlsu.edu.ph','09235230928',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(5,11325536,'B@dB0yZ',1,'mario_mayaboy@dlsu.edu.ph','09233333334',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(6,11423532,'C@m1ll3',1,'camille_leon@dlsu.edu.ph','09534399300',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(7,11290909,'PocariSwe@7',1,'dan_masa@dlsu.edu.ph','09235902339',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(8,20024030,'Mech@n!cz',0,'tracey.maximillian@dlsu.edu.ph','09253533332',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(9,20050404,'amB@h0',1,'peter.pandacan@dlsu.edu.ph','09435443222',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(10,20113939,'m@d!liM',0,'madie.lim@dlsu.edu.ph','09245421800',0,0,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,NULL,0),(13,23434,'2F6CQN7QOP',3,'dsf@sf.com','123',0,0,'asdf','20092140','sdf','20080908','K@bay0','asd',0,NULL,0,0,0,NULL,0),(14,3234,'H3Q1VCSQE6',3,'asd@sdf.com','12312',0,0,'sdf','sdj','asd','20080908','K@bay0','asd',0,NULL,0,0,0,NULL,0),(15,32343,'R3ZX2CTDFH',3,'asd@sdf.com','12312',0,0,'sdf','sdj','asd','20080908','K@bay0','asd',0,NULL,0,0,0,NULL,0),(17,82103,'FEN6VR5IDN',2,'asd@sd.com','13',0,0,'ada','j','j','20080908','K@bay0','s',0,NULL,0,0,0,NULL,0),(18,3,'AEGRNVHPRI',4,'sdf@asd.com','ad',0,0,'ds','df','sdf','20080908','K@bay0','fs',0,NULL,0,0,0,NULL,0),(19,8,'E190J6JLLS',3,'k@ds.com','kasd',0,0,'da','sad','k','20080908','K@bay0','j',0,NULL,0,0,0,NULL,0),(20,888,'7Z9IZFEIFG',3,'k@sd.com','23',0,0,'fd','sd','k','20080908','K@bay0','k',0,NULL,0,0,0,NULL,0),(21,345345,'MVXNCIG90E',2,'sf@casdf.com','345435',0,0,'<img src=\"https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg\">','adsf','dsf','20080908','K@bay0','sdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,123,'8YJCG91SM1',3,'asdf@asdf.com','<img src=\"https://upload.wikimedia.org/wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg\">',0,0,'sdaf','sadf','saf','20080908','K@bay0','sdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2017-08-08 17:06:22
