-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sql_resume
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `derection`
--

DROP TABLE IF EXISTS `derection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `derection` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `derection` varchar(10) NOT NULL,
  `info` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `derection`
--

LOCK TABLES `derection` WRITE;
/*!40000 ALTER TABLE `derection` DISABLE KEYS */;
INSERT INTO `derection` VALUES (1,'JAVA','java，很好的一种语言'),(2,'PYTHON','蟒蛇'),(3,'ART','美术'),(4,'Front-end','前端'),(5,'PM','产品经理'),(6,'GO','冲！'),(7,'UNITY','游戏');
/*!40000 ALTER TABLE `derection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `did` tinyint NOT NULL,
  `fileName` varchar(255) NOT NULL,
  `newFileName` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `uploadTime` date NOT NULL,
  `path` varchar(255) NOT NULL,
  `extension` varchar(255) NOT NULL,
  `ischeck` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,1,1,'test.docx','20210424101736505b7f245446405d9bf2e9ed70fcb876.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-04-24','D:\\IMGUPLOAD\\20210424101736505b7f245446405d9bf2e9ed70fcb876.docx','.docx',1),(2,1,1,'test.docx','202105072152444dea9dde51074761a33b9ae73049d2db.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-05-07','D:\\IMGUPLOAD\\202105072152444dea9dde51074761a33b9ae73049d2db.docx','.docx',0),(3,6,1,'test.docx','202105072157561eee830b5c7347fc97744b5628f6926b.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-05-07','D:\\IMGUPLOAD\\202105072157561eee830b5c7347fc97744b5628f6926b.docx','.docx',0),(4,6,1,'test.docx','20210507220426b2bb4a29d5f44cabb7451830d17f8f50.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-05-07','D:\\IMGUPLOAD\\20210507220426b2bb4a29d5f44cabb7451830d17f8f50.docx','.docx',0),(5,6,1,'test.docx','20210507220745701a0b0281e74c0b8b0d8b65d92bc4e0.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-05-07','D:\\IMGUPLOAD\\20210507220745701a0b0281e74c0b8b0d8b65d92bc4e0.docx','.docx',0),(6,6,2,'test.docx','202105072246464270ef99633c4597baf58ec7e573f7f4.docx','application/vnd.openxmlformats-officedocument.wordprocessingml.document','12248','2021-05-07','D:\\IMGUPLOAD\\202105072246464270ef99633c4597baf58ec7e573f7f4.docx','.docx',0);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL,
  `name` varchar(32) NOT NULL,
  `nameZH` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_boss','老板'),(2,'ROLE_admin','组长'),(3,'ROLE_user','学员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(255) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$NdC6vuBcypb00nJKIlesHu.yb2rWNATiLq6RGHOAhQV.FmuBHcv1e',1,0,'123456@qq.com','123456'),(2,'Doinb','$2a$10$2708rWdRqp9hcRkXfQv3Uu89Eysq6g7zOhEtDP6rM4NXXt4u2S77u',1,0,'123456@qq.com','123456'),(3,'lulu','$2a$10$GPxNOQZYspzX7IKBIKmvHudMRZKOoCCQ4YnXKkmY7.qjISlmup2E6',1,0,'123456@qq.com','123456'),(5,'xxxxxxx','$2a$10$VOA3siSkko6rSSg2g0E4WOIAdawhGddMCKmxbMSd/dKsG8BYFtcZm',1,0,'xxxxxxxxxxxx@qq.com','xxxxxxxxx'),(6,'xiaoming','$2a$10$Cxe9EvfOSP/O5kln0jDGUeC29kkxzC86ZXhULOqbrJT7pSGHdEOKW',1,0,'123456@qq.com','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_direction`
--

DROP TABLE IF EXISTS `user_direction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_direction` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `D1` varchar(45) NOT NULL,
  `D2` varchar(45) NOT NULL,
  `D3` varchar(45) NOT NULL,
  `D4` varchar(45) NOT NULL,
  `D5` varchar(45) NOT NULL,
  `D6` varchar(45) NOT NULL,
  `D7` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_direction`
--

LOCK TABLES `user_direction` WRITE;
/*!40000 ALTER TABLE `user_direction` DISABLE KEYS */;
INSERT INTO `user_direction` VALUES (6,'1','1','0','0','0','0','0');
/*!40000 ALTER TABLE `user_direction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `rid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(3,3,1),(4,4,3),(5,5,2),(6,6,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_uploadtime`
--

DROP TABLE IF EXISTS `user_uploadtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_uploadtime` (
  `uid` int NOT NULL,
  `D1` int NOT NULL,
  `D2` int NOT NULL DEFAULT '0',
  `D3` varchar(45) NOT NULL DEFAULT '0',
  `D4` varchar(45) NOT NULL DEFAULT '0',
  `D5` varchar(45) NOT NULL DEFAULT '0',
  `D6` varchar(45) NOT NULL DEFAULT '0',
  `D7` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_uploadtime`
--

LOCK TABLES `user_uploadtime` WRITE;
/*!40000 ALTER TABLE `user_uploadtime` DISABLE KEYS */;
INSERT INTO `user_uploadtime` VALUES (6,1,0,'0','0','0','0','0');
/*!40000 ALTER TABLE `user_uploadtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sql_resume'
--

--
-- Dumping routines for database 'sql_resume'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 22:22:29
