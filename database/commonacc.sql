-- MySQL dump 10.13  Distrib 5.1.36, for suse-linux-gnu (i686)
--
-- Host: 178.1.0.225    Database: commonacc
-- ------------------------------------------------------
-- Server version	5.0.45-log

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `mastercompany`
--

DROP TABLE IF EXISTS `mastercompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastercompany` (
  `id` int(11) NOT NULL auto_increment,
  `Company` varchar(20) NOT NULL default '',
  `Description` varchar(100) default NULL,
  `Database` varchar(30) NOT NULL default '',
  `Selected` int(1) default '0',
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
  `UserID` varchar(30) default NULL,
  PRIMARY KEY  (`Company`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastercompany`
--

LOCK TABLES `mastercompany` WRITE;
/*!40000 ALTER TABLE `mastercompany` DISABLE KEYS */;
INSERT INTO `mastercompany` VALUES (1,'Admin','admin','commonacc',0,NULL,NULL,NULL),(2,'Accapp','Accapp','accapp',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `mastercompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastergroup`
--

DROP TABLE IF EXISTS `mastergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastergroup` (
  `id` int(11) NOT NULL auto_increment,
  `KodeGroup` varchar(20) NOT NULL default '',
  `Keterangan` varchar(20) default NULL,
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`KodeGroup`),
  UNIQUE KEY `idxMasterGroup` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastergroup`
--

LOCK TABLES `mastergroup` WRITE;
/*!40000 ALTER TABLE `mastergroup` DISABLE KEYS */;
INSERT INTO `mastergroup` VALUES (1,'AdminMaster','Admin Master','2009-08-03 08:06:26','2010-07-14 07:42:59','');
/*!40000 ALTER TABLE `mastergroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastergroupdetail`
--

DROP TABLE IF EXISTS `mastergroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastergroupdetail` (
  `id` int(11) NOT NULL auto_increment,
  `KodeGroup` varchar(20) default NULL,
  `Module` varchar(40) default NULL,
  `Company` varchar(20) default NULL,
  `Read` int(1) default '0',
  `Confirm` int(1) default '0',
  `Entry` int(1) default '0',
  `Update` int(1) default '0',
  `Delete` int(1) default '0',
  `Print` int(1) default '0',
  `Export` int(1) default '0',
  `Import` int(1) default '0',
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `GroupModule` (`KodeGroup`,`Module`,`Company`)
) ENGINE=MyISAM AUTO_INCREMENT=244 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastergroupdetail`
--

LOCK TABLES `mastergroupdetail` WRITE;
/*!40000 ALTER TABLE `mastergroupdetail` DISABLE KEYS */;
INSERT INTO `mastergroupdetail` VALUES (216,'AdminMaster','FrmGenerateTable','Admin',1,0,0,0,0,0,0,0,'2010-09-20 10:45:28','2010-08-05 05:27:29',NULL),(202,'AdminMaster','FrmMasteruser','Admin',1,1,1,1,1,1,0,0,'2010-09-20 10:45:31','2010-07-14 07:42:59',NULL),(203,'AdminMaster','FrmMastergroup','Admin',1,1,1,1,1,1,0,0,'2010-09-20 10:45:33','2010-07-14 07:42:59',NULL),(204,'AdminMaster','FrmMastermodule','Admin',1,1,1,1,1,1,0,0,'2010-09-20 10:45:36','2010-07-14 07:42:59',NULL),(217,'AdminMaster','FrmMasterCompany','Admin',1,1,1,1,1,1,0,0,'2010-09-20 11:00:51','0000-00-00 00:00:00',NULL),(219,'AdminMaster','FrmGenerateTable','Accapp',1,0,0,0,0,0,0,0,'2010-09-21 04:42:20','2010-09-21 01:43:29',NULL),(221,'AdminMaster','FrmCb_bank','Accapp',1,1,1,1,1,1,0,0,'2010-09-21 08:32:46','2010-09-23 10:32:00',NULL),(222,'AdminMaster','FrmGl_currency','Accapp',1,1,1,1,1,1,1,1,'2010-09-23 08:58:33','2010-09-23 10:32:00',NULL),(223,'AdminMaster','FrmGl_account','Accapp',1,1,1,1,1,1,1,1,'2010-09-23 08:58:17','2010-09-23 10:32:00','Admin'),(224,'AdminMaster','FrmGl_sourcelgr','Accapp',1,1,1,1,1,1,1,1,'2010-09-23 11:23:42','0000-00-00 00:00:00','Admin'),(225,'AdminMaster','FrmGl_batchlist','Accapp',1,1,1,1,1,1,1,1,'2010-09-24 06:58:08','0000-00-00 00:00:00','Admin'),(226,'AdminMaster','FrmCb_batchcontrol','Accapp',1,1,1,1,1,1,0,0,'2010-10-01 10:24:03','0000-00-00 00:00:00',NULL),(227,'AdminMaster','FrmCb_batchentry','Accapp',1,1,1,1,1,1,0,0,'2010-10-01 10:24:02','0000-00-00 00:00:00',NULL),(228,'AdminMaster','FrmCb_source','Accapp',1,1,1,1,1,1,0,0,'2010-10-01 10:24:02','0000-00-00 00:00:00',NULL),(229,'AdminMaster','FrmAr_accset','Accapp',1,1,1,1,1,0,0,0,'2010-10-06 10:12:46','0000-00-00 00:00:00',NULL),(230,'AdminMaster','FrmAr_custgrp','AccApp',1,1,1,1,1,0,0,0,'2010-10-06 12:52:11','0000-00-00 00:00:00',NULL),(231,'AdminMaster','FrmAr_billcycl','AccApp',1,1,1,1,1,0,0,0,'2010-10-06 13:06:48','0000-00-00 00:00:00',NULL),(232,'AdminMaster','FrmAr_interest','AccApp',1,1,1,1,1,0,0,0,'2010-10-06 13:20:58','0000-00-00 00:00:00',NULL),(233,'AdminMaster','FrmOp_paymentterm','AccApp',1,1,1,1,1,0,0,0,'2010-10-06 13:33:47','0000-00-00 00:00:00',NULL),(234,'AdminMaster','FrmAr_custnat','AccApp',1,1,1,1,1,1,1,1,'2010-10-11 09:26:42','0000-00-00 00:00:00','admin'),(235,'AdminMaster','FrmAr_customer','AccApp',1,1,1,1,1,1,0,0,'2010-10-11 11:11:23','0000-00-00 00:00:00',NULL),(236,'AdminMaster','FrmOp_phonetype','AccApp',1,1,1,1,1,0,0,0,'2010-10-11 11:17:09','0000-00-00 00:00:00',NULL),(237,'AdminMaster','FrmOp_addrtype','AccApp',1,1,1,1,1,0,0,0,'2010-10-11 11:18:11','0000-00-00 00:00:00',NULL),(238,'AdminMaster','FrmOp_tax','AccApp',1,1,1,1,1,0,0,0,'2010-10-14 07:13:54','0000-00-00 00:00:00',NULL),(239,'AdminMaster','FrmAr_distcode','AccApp',1,1,1,1,1,1,1,1,'2010-10-28 02:53:44','0000-00-00 00:00:00','Admin'),(240,'AdminMaster','FrmAr_invbatchlist','AccApp',1,1,1,1,1,1,1,1,'2010-10-29 07:22:42','0000-00-00 00:00:00','admin'),(241,'AdminMaster','FrmAr_optiionaldetail1','AccApp',1,1,1,1,1,1,1,1,'2010-11-09 04:08:33','0000-00-00 00:00:00','Admin'),(242,'AdminMaster','FrmAr_invh','AccApp',1,1,1,1,1,1,1,1,'2010-11-12 10:14:55','0000-00-00 00:00:00','Admin'),(243,'AdminMaster','FrmAr_rcpbatchlist','AccApp',1,1,1,1,1,1,1,1,'2010-12-02 03:37:56','0000-00-00 00:00:00','Admin');
/*!40000 ALTER TABLE `mastergroupdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterkodesetting`
--

DROP TABLE IF EXISTS `masterkodesetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterkodesetting` (
  `id` int(11) NOT NULL auto_increment,
  `Owner` varchar(5) NOT NULL default '',
  `KodeSetting` varchar(10) NOT NULL default '',
  `Description` varchar(30) default NULL,
  `SessionId` varchar(50) default NULL,
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserID` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idxOwnerSetting` (`Owner`,`KodeSetting`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterkodesetting`
--

LOCK TABLES `masterkodesetting` WRITE;
/*!40000 ALTER TABLE `masterkodesetting` DISABLE KEYS */;
INSERT INTO `masterkodesetting` VALUES (48,'RPT','HEADERRPT','Pt. NGetest',NULL,'2010-07-26 08:14:04','2010-07-26 08:14:04',NULL);
/*!40000 ALTER TABLE `masterkodesetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastermodule`
--

DROP TABLE IF EXISTS `mastermodule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastermodule` (
  `id` int(11) NOT NULL auto_increment,
  `Module` varchar(40) NOT NULL default '',
  `Description` varchar(50) NOT NULL default '',
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`Module`),
  UNIQUE KEY `idModule` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=283 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastermodule`
--

LOCK TABLES `mastermodule` WRITE;
/*!40000 ALTER TABLE `mastermodule` DISABLE KEYS */;
INSERT INTO `mastermodule` VALUES (1,'FrmGenerateTable','Generate Table','2010-07-26 08:14:04','2009-10-30 10:36:57','Admin'),(4,'FrmMastergroup','Group','2010-07-26 08:14:04','2009-10-30 10:36:58','Admin'),(253,'FrmMastermodule','Module','2010-07-26 08:14:04','2009-10-30 10:36:58','Admin'),(2,'FrmMasteruser','User','2010-07-26 08:14:04','2009-10-30 10:36:57','Admin'),(259,'FrmMasterCompany','Master Company','2010-09-20 11:00:10','0000-00-00 00:00:00',NULL),(260,'FrmCb_bank','Master Bank','2010-09-21 08:32:59','0000-00-00 00:00:00',NULL),(261,'FrmGl_currency','Master Currency','2010-09-21 08:33:18','0000-00-00 00:00:00',NULL),(262,'FrmGl_account','Master Account','2010-09-23 08:00:42','0000-00-00 00:00:00','Admin'),(263,'FrmGl_sourcelgr','Master Source Codes','2010-09-23 11:22:09','0000-00-00 00:00:00','Admin'),(264,'FrmGl_batchlist','Transaksi Jurnal Entry','2010-09-24 06:57:07','0000-00-00 00:00:00','Admin'),(265,'FrmCb_batchcontrol','Batch Control','2010-09-28 04:01:29','0000-00-00 00:00:00',NULL),(266,'FrmCb_batchentry','Batch Entry','2010-09-29 04:43:45','0000-00-00 00:00:00',NULL),(267,'FrmCb_source','CB Source','2010-10-01 10:23:26','0000-00-00 00:00:00',NULL),(268,'FrmAr_accset','AR Account Set','2010-10-06 10:12:00','0000-00-00 00:00:00',NULL),(269,'FrmAr_custgrp','AR Customer Group','2010-10-06 12:51:46','0000-00-00 00:00:00',NULL),(270,'FrmAr_billcycl','AR Bill Cycle','2010-10-06 13:19:38','0000-00-00 00:00:00',NULL),(271,'FrmAr_interest','AR Interest','2010-10-06 13:19:45','0000-00-00 00:00:00',NULL),(272,'FrmOp_paymentterm','OP Payment Term','2010-10-06 13:32:39','0000-00-00 00:00:00',NULL),(273,'FrmAr_custnat','AR National Account','2010-10-11 09:25:19','0000-00-00 00:00:00','admin'),(274,'FrmAr_customer','AR Customer','2010-10-11 11:10:30','0000-00-00 00:00:00',NULL),(275,'FrmOp_phonetype','OP Phone Type','2010-10-11 11:17:27','0000-00-00 00:00:00',NULL),(276,'FrmOp_addrtype','AR Address Type','2010-10-14 07:13:17','0000-00-00 00:00:00',NULL),(277,'FrmOp_tax','OP Tax','2010-10-14 07:13:28','0000-00-00 00:00:00',NULL),(278,'FrmAr_distcode','AR Distribution Code','2010-10-28 02:51:20','0000-00-00 00:00:00','Admin'),(279,'FrmAr_invbatchlist','AR Invoice Entry','2010-10-28 07:56:27','0000-00-00 00:00:00','Admin'),(280,'FrmAr_optiionaldetail1','AR Optional Detail','2010-11-09 04:07:25','0000-00-00 00:00:00','Admin'),(281,'FrmAr_invh','AR Invoice Batch List','2010-11-12 10:13:27','0000-00-00 00:00:00','Admin'),(282,'FrmAr_rcpbatchlist','AR Batch Maintenance','2010-12-02 03:36:36','0000-00-00 00:00:00','Admin');
/*!40000 ALTER TABLE `mastermodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masteruser`
--

DROP TABLE IF EXISTS `masteruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masteruser` (
  `id` int(11) NOT NULL auto_increment,
  `User` varchar(30) NOT NULL default '',
  `Password` varchar(10) default NULL,
  `Nama` varchar(50) NOT NULL default '',
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`User`),
  UNIQUE KEY `iduser` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masteruser`
--

LOCK TABLES `masteruser` WRITE;
/*!40000 ALTER TABLE `masteruser` DISABLE KEYS */;
INSERT INTO `masteruser` VALUES (4,'Admin','admin','admin','2009-09-02 10:08:37','2009-09-02 10:08:37','admin');
/*!40000 ALTER TABLE `masteruser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masteruserdetail`
--

DROP TABLE IF EXISTS `masteruserdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masteruserdetail` (
  `id` int(11) NOT NULL auto_increment,
  `User` varchar(30) default NULL,
  `KodeGroup` varchar(20) default NULL,
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `usergroup` (`User`,`KodeGroup`)
) ENGINE=MyISAM AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masteruserdetail`
--

LOCK TABLES `masteruserdetail` WRITE;
/*!40000 ALTER TABLE `masteruserdetail` DISABLE KEYS */;
INSERT INTO `masteruserdetail` VALUES (95,'Admin','AdminMaster','2009-10-29 10:36:50','2010-07-14 11:08:59',NULL);
/*!40000 ALTER TABLE `masteruserdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-12-06 20:04:30
