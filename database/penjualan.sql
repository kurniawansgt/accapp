-- MySQL dump 10.13  Distrib 5.1.36, for suse-linux-gnu (i686)
--
-- Host: 178.1.0.211    Database: penjualan
-- ------------------------------------------------------
-- Server version	5.0.45

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
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `id` int(11) NOT NULL auto_increment,
  `KodeBarang` varchar(5) NOT NULL,
  `NamaBarang` varchar(30) default NULL,
  `Stok` double default NULL,
  `Harga` double default NULL,
  PRIMARY KEY  (`KodeBarang`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES (2,'asdff','sadfsdf',1,10000),(1,'assss','sadfffff',2,20000);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barangbackup071510142430`
--

DROP TABLE IF EXISTS `barangbackup071510142430`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barangbackup071510142430` (
  `id` int(11) NOT NULL default '0',
  `KodeBarang` varchar(5) NOT NULL,
  `NamaBarang` varchar(30) default NULL,
  `Stok` double default NULL,
  `Harga` double default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barangbackup071510142430`
--

LOCK TABLES `barangbackup071510142430` WRITE;
/*!40000 ALTER TABLE `barangbackup071510142430` DISABLE KEYS */;
INSERT INTO `barangbackup071510142430` VALUES (1,'B0001','1111111',100,10000),(2,'B0002','Barang 02',50,200000),(3,'B0006','Barang 06',50,10000);
/*!40000 ALTER TABLE `barangbackup071510142430` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastergroup`
--

DROP TABLE IF EXISTS `mastergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastergroup` (
  `id` int(11) NOT NULL auto_increment,
  `KodeGroup` varchar(20) NOT NULL,
  `Keterangan` varchar(20) default NULL,
  `TanggalEntry` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`KodeGroup`),
  UNIQUE KEY `idxMasterGroup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastergroup`
--

LOCK TABLES `mastergroup` WRITE;
/*!40000 ALTER TABLE `mastergroup` DISABLE KEYS */;
INSERT INTO `mastergroup` VALUES (1,'AdminMaster','Admin Master','2009-08-03 08:06:26','2010-07-16 11:09:47','');
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
  `Read` int(1) default '0',
  `Confirm` int(1) default '0',
  `Entry` int(1) default '0',
  `Update` int(1) default '0',
  `Delete` int(1) default '0',
  `Print` int(1) default '0',
  `Export` int(1) default '0',
  `Import` int(1) default '0',
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `GroupModule` (`KodeGroup`,`Module`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastergroupdetail`
--

LOCK TABLES `mastergroupdetail` WRITE;
/*!40000 ALTER TABLE `mastergroupdetail` DISABLE KEYS */;
INSERT INTO `mastergroupdetail` VALUES (201,'AdminMaster','FrmGenerateTable',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:47',NULL),(202,'AdminMaster','FrmMasteruser',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:47',NULL),(203,'AdminMaster','FrmMastergroup',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:47',NULL),(204,'AdminMaster','FrmMastermodule',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:48',NULL),(205,'AdminMaster','LogOut',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:47',NULL),(206,'AdminMaster','Exit',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:48',NULL),(208,'AdminMaster','FrmBarang',1,1,1,1,1,1,0,0,NULL,'2010-07-16 11:09:48',NULL),(209,'AdminMaster','Reset Password',1,0,0,0,0,0,0,0,NULL,NULL,NULL),(210,'AdminMaster','FrmSupplier',1,1,1,1,1,1,0,0,NULL,NULL,NULL),(211,'AdminMaster','FrmPenjualan',1,1,1,1,1,1,0,0,NULL,NULL,NULL);
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
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
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
INSERT INTO `masterkodesetting` VALUES (48,'RPT','HEADERRPT','Pt. NGetest',NULL,NULL,NULL,NULL);
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
  `Module` varchar(40) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`Module`),
  UNIQUE KEY `idModule` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastermodule`
--

LOCK TABLES `mastermodule` WRITE;
/*!40000 ALTER TABLE `mastermodule` DISABLE KEYS */;
INSERT INTO `mastermodule` VALUES (252,'Exit','Exit',NULL,'2010-07-14 11:21:03','Admin'),(254,'FrmBarang','Barang',NULL,'2009-10-30 10:36:58','Admin'),(1,'FrmGenerateTable','Generate Table',NULL,'2009-10-30 10:36:57','Admin'),(4,'FrmMastergroup','Group',NULL,'2009-10-30 10:36:58','Admin'),(253,'FrmMastermodule','Module',NULL,'2009-10-30 10:36:58','Admin'),(2,'FrmMasteruser','User',NULL,'2009-10-30 10:36:57','Admin'),(257,'FrmPenjualan','Form Penjualan',NULL,NULL,''),(256,'FrmSupplier','Form Supplier',NULL,NULL,''),(6,'LogOut','Log Out',NULL,'2009-10-30 10:36:58','Admin'),(3,'Reset Password','Reset Password',NULL,'2009-10-30 10:36:58','Admin');
/*!40000 ALTER TABLE `mastermodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastermodulebackup071610155332`
--

DROP TABLE IF EXISTS `mastermodulebackup071610155332`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastermodulebackup071610155332` (
  `id` int(11) NOT NULL default '0',
  `Module` varchar(40) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
  `UserId` varchar(30) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastermodulebackup071610155332`
--

LOCK TABLES `mastermodulebackup071610155332` WRITE;
/*!40000 ALTER TABLE `mastermodulebackup071610155332` DISABLE KEYS */;
INSERT INTO `mastermodulebackup071610155332` VALUES (252,'Exit','Exit',NULL,'2010-07-14 11:21:03','Admin'),(254,'FrmBarang','Barang',NULL,'2009-10-30 10:36:58','Admin'),(1,'FrmGenerateTable','Generate Table',NULL,'2009-10-30 10:36:57','Admin'),(4,'FrmMastergroup','Group',NULL,'2009-10-30 10:36:58','Admin'),(253,'FrmMastermodule','Module',NULL,'2009-10-30 10:36:58','Admin'),(2,'FrmMasteruser','User',NULL,'2009-10-30 10:36:57','Admin'),(6,'LogOut','Log Out',NULL,'2009-10-30 10:36:58','Admin'),(3,'Reset Password','Reset Password',NULL,'2009-10-30 10:36:58','Admin');
/*!40000 ALTER TABLE `mastermodulebackup071610155332` ENABLE KEYS */;
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
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`User`),
  UNIQUE KEY `iduser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masteruser`
--

LOCK TABLES `masteruser` WRITE;
/*!40000 ALTER TABLE `masteruser` DISABLE KEYS */;
INSERT INTO `masteruser` VALUES (4,'Admin','admin','admin','2009-09-02 10:08:37','2010-07-14 11:28:59','admin');
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
INSERT INTO `masteruserdetail` VALUES (95,'Admin','AdminMaster','2009-10-29 10:36:50','2010-07-14 11:28:59',NULL);
/*!40000 ALTER TABLE `masteruserdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penjualan`
--

DROP TABLE IF EXISTS `penjualan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL auto_increment,
  `NomorPenjualan` varchar(10) NOT NULL,
  `TanggalPenjualan` date default NULL,
  `KodeSupplier` varchar(5) default NULL,
  PRIMARY KEY  (`NomorPenjualan`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_penjualan` (`KodeSupplier`),
  CONSTRAINT `FK_penjualan` FOREIGN KEY (`KodeSupplier`) REFERENCES `supplier` (`KodeSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penjualan`
--

LOCK TABLES `penjualan` WRITE;
/*!40000 ALTER TABLE `penjualan` DISABLE KEYS */;
INSERT INTO `penjualan` VALUES (1,'aaaa','2010-07-23','S0002');
/*!40000 ALTER TABLE `penjualan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penjualandetail`
--

DROP TABLE IF EXISTS `penjualandetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penjualandetail` (
  `id` int(11) NOT NULL auto_increment,
  `NomorPenjualan` varchar(10) default NULL,
  `KodeBarang` varchar(5) default NULL,
  `Qty` double default NULL,
  `Harga` double default NULL,
  PRIMARY KEY  (`id`),
  KEY `NomorPenjualanDetail` (`NomorPenjualan`),
  KEY `KodeBarangPenjualanDetail` (`KodeBarang`),
  CONSTRAINT `FK_penjualandetailtomaster` FOREIGN KEY (`NomorPenjualan`) REFERENCES `penjualan` (`NomorPenjualan`),
  CONSTRAINT `FK_penjualandetail` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penjualandetail`
--

LOCK TABLES `penjualandetail` WRITE;
/*!40000 ALTER TABLE `penjualandetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `penjualandetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sqlcommandlogs`
--

DROP TABLE IF EXISTS `sqlcommandlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sqlcommandlogs` (
  `cmdid` int(11) NOT NULL default '0',
  `cmdsql` text NOT NULL,
  `cmdsyncsts` char(1) NOT NULL default '',
  `auditdate` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `audituser` varchar(15) default NULL,
  `TanggalEntry` timestamp NULL default NULL,
  `TanggalUpdate` timestamp NULL default NULL,
  `UserId` varchar(30) default NULL,
  PRIMARY KEY  (`cmdid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sqlcommandlogs`
--

LOCK TABLES `sqlcommandlogs` WRITE;
/*!40000 ALTER TABLE `sqlcommandlogs` DISABLE KEYS */;
/*!40000 ALTER TABLE `sqlcommandlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL auto_increment,
  `KodeSupplier` varchar(5) NOT NULL,
  `NamaSupplier` varchar(20) default NULL,
  `Alamat` varchar(40) default NULL,
  PRIMARY KEY  (`KodeSupplier`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'S0001','s111','sa'),(2,'S0002','s222','SB');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-07-23 17:22:08
