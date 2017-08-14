CREATE DATABASE  IF NOT EXISTS `shslibrary` /*!40100 DEFAULT CHARACTER SET latin1 */;
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
  `title` varchar(255) NOT NULL,
  `booktype` int(11) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `location` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `returndate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  UNIQUE KEY `bookid_UNIQUE` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'The Rise of the Boy',0,'Magenta Black','The New Inc.',2000,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(2,'The Return of the Boy',0,'Magenta Black','The New Inc.',2001,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(3,'The Death of the Boy',0,'Magenta Black','The New Inc.',2002,'Shelf 101, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(4,'Mastering Dodgeball',0,'Barry Lock','Shoot Right Inc.',2008,'Shelf 21, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(5,'The Lion, the Witch and the Wardrobe ',0,'Clive Staples Lewis','HarperCollins',1950,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(6,'Prince Caspian: The Return to Narnia',0,'Clive Staples Lewis','HarperCollins',1951,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(7,'The Voyage of the Dawn Treader',0,'Clive Staples Lewis','HarperCollins',1952,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(8,'The Silver Chair',0,'Clive Staples Lewis','HarperCollins',1953,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(9,'The Horse and His Boy',0,'Clive Staples Lewis','HarperCollins',1954,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(10,'The Magician\'s Nephew',0,'Clive Staples Lewis','HarperCollins',1955,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(11,'The Last Battle',0,'Clive Staples Lewis','HarperCollins',1956,'Shelf 55, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(12,'Smaller and Smaller Circles',0,'Felisa Batacan','University of the Philippines Press ',2002,'Shelf 57, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(13,'The Philosopher\'s Stone',0,'J. K. Rowling','Bloomsbury Publishing',1997,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(14,'The Chamber of Secrets',0,'J. K. Rowling','Bloomsbury Publishing',1998,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(15,'The Prisoner of Azkaban',0,'J. K. Rowling','Bloomsbury Publishing',1999,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(16,'The Goblet of Fire',0,'J. K. Rowling','Bloomsbury Publishing',2000,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(17,'The Order of the Phoenix ',0,'J. K. Rowling','Bloomsbury Publishing',2003,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(18,'The Half-Blood Prince',0,'J. K. Rowling','Bloomsbury Publishing',2005,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(19,'The Deathly Hallows',0,'J. K. Rowling','Bloomsbury Publishing',2007,'Shelf 58, 7F (Circulation), Henry Sy Sr. Hall',0,NULL),(20,'Times Magazine:2016',2,'Nancy Gibbs','Time Inc',2016,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(21,'Times Magazine:2015',2,'Nancy Gibbs','Time Inc',2015,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(22,'Times Magazine:2014',2,'Nancy Gibbs','Time Inc',2014,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(23,'Times Magazine:2013',2,'Nancy Gibbs','Time Inc',2013,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(24,'Times Magazine:2012',2,'Nancy Gibbs','Time Inc',2012,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(25,'Times Magazine:2011',2,'Nancy Gibbs','Time Inc',2011,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(26,'Times Magazine:2010',2,'Nancy Gibbs','Time Inc',2010,'Shelf 100, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(27,'K-Zone Philippines:2001',2,'Daniel Findlay','Pacific Magazines',2001,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(28,'K-Zone Philippines:2002',2,'Daniel Findlay','Pacific Magazines',2002,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(29,'K-Zone Philippines:2003',2,'Daniel Findlay','Pacific Magazines',2003,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(30,'K-Zone Philippines:2004',2,'Daniel Findlay','Pacific Magazines',2004,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(31,'K-Zone Philippines:2005',2,'Daniel Findlay','Pacific Magazines',2005,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(32,'K-Zone Philippines:2006',2,'Daniel Findlay','Pacific Magazines',2006,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(33,'K-Zone Philippines:2007',2,'Daniel Findlay','Pacific Magazines',2007,'Shelf 102, 9F (Circulation), Henry Sy Sr. Hall',0,NULL),(34,'Effectiveness of EEG Signals in Detecting Stress Level While Sleeping',1,'Jonathan Campana','IEEE',2010,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(35,'Traffic Model Using CCTV Cameras',1,'Badjao Kalabiri','IEEE',2012,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(36,'Friction Resistant Bullets ',1,'Kamani Pataka','IEEE',2015,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(37,'Advantages of IoT Underwater',1,'Asamani Deku','IEEE',2016,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(38,'Disadvantages of Using Infrared During Blizzard',1,'Machu Piku','IEEE',2009,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(39,'Medical Use of Arwana Together With Ultra-Violet Lights',1,'Ariana Swert','IEEE',2001,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(40,'Summary of the Models in Predicting Nuclear Disasters',1,'Dishan Jikhama','IEEE',2008,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(41,'Zigzag Effects of Zigzag Lines in Engineering',1,'Zoro Ampato','IEEE',2003,'Shelf 200, 12F (Mezzanine), Henry Sy Sr. Hall',0,NULL),(42,'The Last Lecture',0,'Randy Pausch','Hyperion',2008,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(43,'Le Petit Prince',0,'Antoine de Saint-Exupéry','Gallimard',1943,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(44,'Tuesdays with Morrie',0,'Mitch Albom','Doubleday',1997,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(45,'Divergent',0,'Veronica Roth','Katherine Tegen Books',2011,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(46,'Insurgent ',0,'Veronica Roth','Katherine Tegen Books',2012,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(47,'Allegiant',0,'Veronica Roth','Katherine Tegen Books',2013,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(48,'Four: A Divergent Collection',0,'Veronica Roth','Katherine Tegen Books',2013,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(49,'Jonathan Livingston Seagull',0,'Richard Bach','Macmillan',1970,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL),(50,'The Catcher in the Rye',0,'Jerome David Salinger','Little, Brown and Company',1951,'Shelf 102, 8F (Circulation), Henry Sy Sr. Hall',0,NULL);
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
INSERT INTO `review` VALUES (1,1,'Cool Book',1,'0000-00-00'),(2,2,'Nice Book',1,'0000-00-00'),(3,3,'Great Book',1,'0000-00-00'),(4,1,'Can be Improved',5,'0000-00-00');
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_reservation`
--

LOCK TABLES `room_reservation` WRITE;
/*!40000 ALTER TABLE `room_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_reservation` ENABLE KEYS */;
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
  `usertype` int(1) NOT NULL COMMENT '0 - Admin\n1 - Manager\n2 - Staff\n3 - Professor\n4 - Student',
  `emailaddress` varchar(100) NOT NULL,
  `phonenumber` varchar(1000) NOT NULL,
  `lockstatus` int(1) NOT NULL DEFAULT '0' COMMENT '0 - unlocked\n1 - locked',
  `loginattempts` int(1) NOT NULL DEFAULT '0',
  `firstname` varchar(45) DEFAULT NULL,
  `middleinitial` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `secretquestion` varchar(100) DEFAULT NULL,
  `secretanswer` varchar(100) DEFAULT NULL,
  `datecreated` varchar(45) DEFAULT NULL,
  `validated` int(1) DEFAULT '0',
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
INSERT INTO `user` VALUES (1,11429395,'$2a$10$VQyv2DKaR4Jj58v.zcHlguwFGbUNe9ziMq4iWyq2bckfOrUTwLj.S',4,'jared_kabusuan@dlsu.edu.ph','09382904103',0,0,'Jared','L','Kabusuan','03/29/1997','What is your first pet\'s name?','Gorgos',NULL,0),(2,20092140,'$2a$10$nMKUIaqPKAp/9iTFzFNeReazSuw9sh0ehGxM95ncJUk74bTC/vFk2',3,'jerry.mangan@dlsu.edu.ph','09837548783',0,0,'Jerry','K.','Mangan','09/29/1989','Which street did you live in when you were 5 year old?','Maginhawa Street',NULL,0),(3,20013334,'$2a$10$NEs.2e0ehdIadBtXTXUSwuP6FpedRTowhNA7./KaTfXDbzRDJyrY6',2,'danny.lopez@dlsu.edu.ph','09299990987',0,0,'Danny','S.','Lopez','02/12/1979','How much is your first income?','5,432Pesos',NULL,0),(4,20038931,'$2a$10$lqxNhCN7J5NiyL3PaqVrseQQmRnbD8qNxLIbpeW.WLj7/DeCiylJS',1,'ogrim.manalo@dlsu.edu.ph','09339209399',0,0,'Ogrim','K.','Manalo','01/20/1990','What is the first console game that you played?','Sonic Adventure',NULL,0),(5,11354069,'$2a$10$lqxNhCN7J5NiyL3PaqVrseQQmRnbD8qNxLIbpeW.WLj7/DeCiylJS',4,'maria_karaga@dlsu.edu.pg','09253253554',0,0,'Maria','J.','Karaga','02/11/1996','What is your first pet\'s name?','Mandy',NULL,0),(6,11244567,'$2a$10$O/A/Rf/5QKRXp/X6pqQ5oO3vZQ5ZUL4eruOM9afK.JBNCP4eN8YCu',4,'dan_lo@dlsu.edu.ph','09346362621',0,0,'Dan','M.','Lo','09/20/1990','Favorite city','Seoul',NULL,0),(7,11263425,'$2a$10$J8AW.ziHFsy4SBupdBKGkOWCmfN80xn1.hFAJ/2YOdbRVvy6Sml9W',4,'alden_bitogo@dlsu.edu.ph','09238978452',0,0,'Alden','R.','Bitogo','04/09/1993','Where did I met her?','Milan',NULL,0),(9,11209584,'$2a$10$lfwDWKEbqweZH0Q3qCiIWeoF86swGgqhfz4O9Nuhkbu6p1ZQeVFqe',4,'ko_ea@dlsu.edu.ph','09247829000',0,1,'Ko','R.','Ea','09/20/1990','Where is he?','Korea',NULL,0),(10,11435864,'$2a$10$mTT80jfJCq548Ormr3dri.U.AZOm8IgHmRQqPm5ohn6uQYpTLFrF6',4,'alka_mani@dlsu.edu.ph','09235823952',0,0,'Alka','M.','Mani','06/10/1995','Where do you live before?','$2a$10$81sXDoz7p46EEkgSNUT2a..2ilkjRcsCoAiNX88b8voxFb2xpN/e6',NULL,0),(11,11209093,'$2a$10$jaS.mG06GSl7k6JLBg9p0O7RCW0jvN/bz4KD7UO7lWwxc4LXjcCYG',4,'bam_bi@dlsu.edu.ph','09285936929',0,0,'Bam','B.','Bi','01/01/1990','Place where I first went when I left home','$2a$10$Ut0/3k1OKqVwH6Z244LIa./U5tp4EoPsjE.19XpJYxpbDmAJ7L8Pe',NULL,0),(12,11209022,'$2a$10$gzOa6isKqPUwT4Sl5z8MnunmZR2lrBhK/yUt5QBmv5NzwmXOxEcbi',4,'bami_bim@dlsu.edu.ph','09285936929',0,0,'Bami','B.','Bim','01/30/1993','Place where I first went when I left home','$2a$10$ICv0NMBiyDLqtjvWVEcClecoBET0/skaOpwoLd5w7fBjECPf1XHAq',NULL,0),(13,11309098,'$2a$10$IHpYzkc3nBA1y3ihvXG8xO8wX02MsRs4JEIeQx8po3qsR8tDx4TRy',4,'am_de@dlsu.edu.ph','09999872692',0,0,'Am','P','De','09/01/1990','Who you','$2a$10$5jqECtHjzKENLr7y/1HqRONEIX68Tp9UupQffNo9D/4lQeeAuYIku',NULL,0),(14,11109021,'$2a$10$pM9F4cs5IhFnsKpf4ma0.e9Tz3YdRqH2dfT2bQFXKut6HM9LgWJQu',4,'da_da@dlsu.edu.ph','09289709101',0,0,'Da','D','Da','08/20/1993','Kong','$2a$10$rS1GXjYw3BDAbOaWOtbjDe8UpptgbEZuZVWMz80/1jGIKT1R0NgSu',NULL,0),(15,11202010,'$2a$10$IUbcSvO3wlv6hoVW6aJmxOZ/hVGHc20cYfwsaXrL24AE9vivzlJTi',4,'gary_oo@dlsu.edu.ph','09784567234',0,0,'Gary','O','Oo','03/08/1994','Beach','$2a$10$o.P0be5RHsb7N3quwWguD./y3Sw73DonFTeQplZHE.rYr0fGbbq6S',NULL,0),(16,11202228,'$2a$10$CX9AvbLMl.uzaina1mH9cOKlbirSfars0HxZVupdpStBn/E6GGu6G',4,'ga_so@dlsu.edu.ph','09784567333',0,0,'Ga','O','So','09/26/1994','Beach','$2a$10$gXVLJVJE.3Ri8LcSxe.0e.w0SZ7ryAg0IkO7vTZq4qbM2XWhAodj.',NULL,0),(17,11201128,'$2a$10$yj07fNQ3EvDEERHtVKwZHOci4t5yJ3m5lzQn.TdM2Qnu0/UzCLYqO',4,'lo_so@dlsu.edu.ph','09784567311',0,0,'Lo','O','So','08/10/1993','Beach','$2a$10$DMrQ3hsqF5ODLjIhzIT17e95VjIIfsB/98JaLHgdVhef24FM35Jny',NULL,0),(18,20093190,'$2a$10$ZokWRs/ufUG6yqo/j3Qu3.sshfBURjPjCTU95HhByaGwwnjG9a5Qe',3,'ko_lo@dlsu.edu.ph','09382910929',0,0,'Ko','M','Lo','02/26/1980','Home','$2a$10$aR7e3aKU0.xNtFDVD/V2P.jAWFPHpFQwg/DnjMsUO6iBwR8xE8l.C',NULL,0),(19,20049015,'$2a$10$DYoLcpMlr7CF.hWZMgDux.bIGxz.3XryVSw4/uWQmVJmQFaAyEcKW',3,'mo_mo@dlsu.edu.ph','09382789102',0,0,'Mo','M','Mo','12/01/1982','aaaa','$2a$10$OMgbdtTnYFUD1G2tpEq6XeSvC7OhXGbOAbQBqw/UFQc60M3xBMbaC',NULL,0),(20,20071928,'$2a$10$V50CJ8HcQu6tB1WxkiTfHeeOlR5NKlYAanhYn7EtsJ.pRJr/eyxyS',3,'an_an@dlsu.edu.ph','09880919203',0,0,'An','A','An','01/31/1990','asd','$2a$10$RX2DjwL/IMRO2NZ3OVHZLuVAZCGe1aFMWKwI1ChtSdLGZCq1koi1a',NULL,0),(21,11389201,'$2a$10$URA4ILHn7LynH2w.BxF1jeKUSpfbN5qntu2HapwV0udesD4amUxH.',4,'be@dlsu.edu.ph','09281920482',0,0,'<script>alert(\"1\");</script>','R.','Be','08/01/1990','Pizza','$2a$10$/CNS1H14.bOBbB7XqlDbFuvKTAfCEwrsUT6bjXdXnAP8z51NE34QO',NULL,0),(22,20019203,'$2a$10$sDPrAwLnBqMbwax47Yi71eONc1aVRiU96Wh3hlcgLXTdxjwjPmBvC',1,'me_me@dlsu.edu.ph','09281234954',0,0,'Me','M.','Me','08/02/1980','Dog','$2a$10$6heYV8AwHHqnSieRTOEWQucKj0qJGlyU6S8PF8x20OVDxynATYuuC',NULL,0);
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

-- Dump completed on 2017-08-14 19:57:41
