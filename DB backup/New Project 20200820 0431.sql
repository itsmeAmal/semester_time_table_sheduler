-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.30-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ttms_uh
--

CREATE DATABASE IF NOT EXISTS ttms_uh;
USE ttms_uh;

--
-- Definition of table `batch`
--

DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `batch_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `batch_year` varchar(15) DEFAULT NULL,
  `batch_level` varchar(150) DEFAULT NULL,
  `batch_detail` varchar(450) DEFAULT NULL,
  `batch_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch`
--

/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` (`batch_id`,`batch_year`,`batch_level`,`batch_detail`,`batch_status`) VALUES 
 (1,'2018','Level 6','2020',1),
 (2,'2019','Level 5','2020',1),
 (3,'2020','Level 4','2020',1);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;


--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_name` varchar(150) DEFAULT NULL,
  `course_type` varchar(50) DEFAULT NULL,
  `course_detail` varchar(450) DEFAULT NULL,
  `course_satus` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`,`course_name`,`course_type`,`course_detail`,`course_satus`) VALUES 
 (1,'Electrical & Electronic Engineering','EEE','',1),
 (2,'Electronics & Communication Engineering','ECME','',1),
 (3,'Electronics &bComputer Engineering','ECE','',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `delivery_plan`
--

DROP TABLE IF EXISTS `delivery_plan`;
CREATE TABLE `delivery_plan` (
  `delivery_plan_id` int(10) unsigned NOT NULL,
  `delivery_plan_level_str` varchar(50) DEFAULT NULL,
  `delivery_plan_module_id` int(10) unsigned DEFAULT NULL,
  `delivery_plan_repeat_students_available` tinyint(1) NOT NULL DEFAULT '0',
  `delivery_plan_week_begining_date` date DEFAULT NULL,
  `delivery_plan_calender_week` varchar(150) DEFAULT NULL,
  `delivery_plan_class_contact_week` varchar(150) DEFAULT NULL,
  `delivery_plan_year` int(5) unsigned DEFAULT NULL,
  `delivery_plan_type` varchar(50) DEFAULT NULL,
  `delivery_plan_lecturer_id` int(10) unsigned DEFAULT NULL,
  `delivery_plan_lecture_hours` decimal(10,2) DEFAULT '0.00',
  `delivery_plan_room_id` int(10) unsigned DEFAULT NULL,
  `delivery_plan_remark` varchar(900) DEFAULT NULL,
  `delivery_plan_day_1` varchar(50) DEFAULT NULL,
  `delivery_plan_day_2` varchar(50) DEFAULT NULL,
  `delivery_plan_day_3` varchar(50) DEFAULT NULL,
  `delivery_plan_day_4` varchar(50) DEFAULT NULL,
  `delivery_plan_day_5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`delivery_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_plan`
--

/*!40000 ALTER TABLE `delivery_plan` DISABLE KEYS */;
INSERT INTO `delivery_plan` (`delivery_plan_id`,`delivery_plan_level_str`,`delivery_plan_module_id`,`delivery_plan_repeat_students_available`,`delivery_plan_week_begining_date`,`delivery_plan_calender_week`,`delivery_plan_class_contact_week`,`delivery_plan_year`,`delivery_plan_type`,`delivery_plan_lecturer_id`,`delivery_plan_lecture_hours`,`delivery_plan_room_id`,`delivery_plan_remark`,`delivery_plan_day_1`,`delivery_plan_day_2`,`delivery_plan_day_3`,`delivery_plan_day_4`,`delivery_plan_day_5`) VALUES 
 (1,'Level 4',1,0,'2020-08-05','CW 32','Week 2',2020,'Lecture',1,'1.30',1,'','Monday','Tuesday','Wednesday','Thursday','Friday'),
 (2,'Level 4',1,0,'2020-08-12','CW 33','Week 3',2020,'Lecture',1,'2.00',1,'','Monday','Tuesday','Wednesday','Thursday','Friday'),
 (3,'Level 6',1,0,'2020-08-12','CW 33','Week 3',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Thursday','Monday','Wednesday'),
 (4,'Level 5',2,0,'2020-08-17','CW 34','Week 5',2020,'Lecture',2,'3.00',1,'','Friday','Monday','Wednesday','Thursday','Tuesday'),
 (5,'Level 5',2,1,'2020-08-23','CW 35','Week 4',2020,'Holiday',2,'3.00',1,'','Monday','Tuesday','Thursday','Friday','Wednesday'),
 (6,'Level 4',6,0,'2020-06-01','CW 23','Week 1',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (7,'Level 4',6,0,'2020-06-01','CW 23','Week 1',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (8,'Level 4',6,0,'2020-06-08','CW 24','Week 2',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (9,'Level 4',6,0,'2020-06-08','CW 24','Week 2',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (10,'Level 4',6,0,'2020-06-08','CW 24','Week 2',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (11,'Level 4',6,0,'2020-06-15','CW 25','Week 3',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (12,'Level 4',6,0,'2020-06-15','CW 25','Week 3',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (13,'Level 4',6,0,'2020-06-22','CW 26','Week 4',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (14,'Level 4',6,0,'2020-06-22','CW 26','Week 4',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (15,'Level 4',6,0,'2020-06-22','CW 26','Week 4',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (16,'Level 4',6,0,'2020-06-29','CW 27','Week 5',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (17,'Level 4',6,0,'2020-06-29','CW 27','Week 5',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (18,'Level 4',6,0,'2020-07-06','CW 28','Week 6',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (19,'Level 4',6,0,'2020-07-06','CW 28','Week 6',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (20,'Level 4',6,0,'2020-07-06','CW 28','Week 6',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (21,'Level 4',6,0,'2020-07-13','CW 29','Week 7',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (22,'Level 4',6,0,'2020-07-13','CW 29','Week 7',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (23,'Level 4',6,0,'2020-07-20','CW 30','Week 8',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (24,'Level 4',6,0,'2020-07-20','CW 30','Week 8',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (25,'Level 4',6,0,'2020-07-20','CW 30','Week 8',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (26,'Level 4',6,0,'2020-07-27','CW 31','Week 9',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (27,'Level 4',6,0,'2020-07-27','CW 31','Week 9',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (28,'Level 4',6,0,'2020-07-27','CW 31','Week 9',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (29,'Level 4',6,0,'2020-08-03','CW 32','Week 10',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (30,'Level 4',6,0,'2020-08-03','CW 32','Week 10',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (31,'Level 4',6,0,'2020-08-03','CW 32','Week 10',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (32,'Level 4',6,0,'2020-08-10','CW 33','Week 11',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (33,'Level 4',6,0,'2020-08-10','CW 33','Week 11',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (34,'Level 4',6,0,'2020-08-17','CW 34','Week 12',2020,'Lecture',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (35,'Level 4',6,0,'2020-08-17','CW 34','Week 12',2020,'Tutorial',1,'1.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (36,'Level 4',6,0,'2020-08-17','CW 34','Week 12',2020,'Lab',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (37,'Level 4',6,0,'2020-08-24','CW 35','Week 13',2020,'Examination',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (38,'Level 4',6,0,'2020-08-24','CW 35','Week 13',2020,'Examination',1,'2.00',8,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (39,'Level 4',6,0,'2020-08-31','CW 36','Week 14',2020,'Examination',1,'2.00',1,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (40,'Level 4',6,0,'2020-09-07','CW 37','Week 15',2020,'Examination',1,'2.00',9,'','Friday','Tuesday','Monday','Wednesday','Thursday'),
 (41,'Level 4',7,0,'2020-06-01','CW 23','Week 1',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (42,'Level 4',7,0,'2020-06-08','CW 24','Week 2',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (43,'Level 4',7,0,'2020-06-08','CW 24','Week 2',2020,'Tutorial',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (44,'Level 4',7,0,'2020-06-15','CW 25','Week 3',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (45,'Level 4',7,0,'2020-06-22','CW 26','Week 4',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (46,'Level 4',7,0,'2020-06-22','CW 26','Week 4',2020,'Tutorial',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (47,'Level 4',7,0,'2020-06-29','CW 27','Week 5',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (48,'Level 4',7,0,'2020-06-29','CW 27','Week 5',2020,'Lab',2,'3.00',8,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (49,'Level 4',7,0,'2020-07-06','CW 28','Week 6',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (50,'Level 4',7,0,'2020-07-06','CW 28','Week 6',2020,'Tutorial',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (51,'Level 4',7,0,'2020-07-13','CW 29','Week 7',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (52,'Level 4',7,0,'2020-07-20','CW 30','Week 8',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (53,'Level 4',7,0,'2020-07-20','CW 30','Week 8',2020,'Tutorial',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (54,'Level 4',7,0,'2020-07-27','CW 31','Week 9',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (55,'Level 4',7,0,'2020-07-27','CW 31','Week 9',2020,'Lab',2,'3.00',8,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (56,'Level 4',7,0,'2020-08-03','CW 32','Week 10',2020,'Lecture',2,'3.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (57,'Level 4',7,0,'2020-08-03','CW 32','Week 10',2020,'Tutorial',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (58,'Level 4',7,0,'2020-08-17','CW 34','Week 12',2020,'Examination',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (59,'Level 4',7,0,'2020-08-24','CW 35','Week 13',2020,'Revision',2,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (60,'Level 4',7,0,'2020-08-31','CW 36','Week 14',2020,'Examination',2,'2.00',9,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (61,'Level 4',7,0,'2020-09-07','CW 37','Week 15',2020,'Examination',2,'2.00',9,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (62,'Level 5',12,1,'2020-06-01','CW 23','Week 1',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (63,'Level 5',12,1,'2020-06-08','CW 24','Week 2',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (64,'Level 5',12,1,'2020-06-15','CW 25','Week 3',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (65,'Level 5',12,1,'2020-06-22','CW 26','Week 4',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (66,'Level 5',12,1,'2020-06-29','CW 27','Week 5',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (67,'Level 5',12,1,'2020-07-06','CW 28','Week 6',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (68,'Level 5',12,1,'2020-07-13','CW 29','Week 7',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (69,'Level 5',12,1,'2020-07-20','CW 30','Week 8',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (70,'Level 5',12,1,'2020-07-27','CW 31','Week 9',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (71,'Level 5',12,1,'2020-07-20','CW 30','Week 8',2020,'Lab',5,'4.00',8,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (72,'Level 5',12,1,'2020-07-27','CW 31','Week 9',2020,'Lab',5,'4.00',8,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (73,'Level 5',12,1,'2020-08-03','CW 32','Week 10',2020,'Lecture',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (74,'Level 5',12,1,'2020-08-17','CW 34','Week 12',2020,'Revision',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (75,'Level 5',12,1,'2020-08-24','CW 35','Week 13',2020,'Revision',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (76,'Level 5',12,1,'2020-08-31','CW 36','Week 14',2020,'Examination',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (77,'Level 5',12,1,'2020-09-07','CW 37','Week 15',2020,'Examination',5,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (78,'Level 5',14,0,'2020-06-01','CW 23','Week 1',2020,'Lecture',6,'2.00',2,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (79,'Level 5',14,0,'2020-06-08','CW 24','Week 2',2020,'Lecture',6,'2.00',2,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (80,'Level 5',14,0,'2020-06-08','CW 24','Week 2',2020,'Lab',6,'3.00',8,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (81,'Level 5',14,0,'2020-06-15','CW 25','Week 3',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (82,'Level 5',14,0,'2020-06-22','CW 26','Week 4',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (83,'Level 5',14,0,'2020-06-22','CW 26','Week 4',2020,'Tutorial',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (84,'Level 5',14,0,'2020-06-29','CW 27','Week 5',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (85,'Level 5',14,0,'2020-07-06','CW 28','Week 6',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (86,'Level 5',14,0,'2020-07-06','CW 28','Week 6',2020,'Tutorial',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (87,'Level 5',14,0,'2020-07-13','CW 29','Week 7',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (88,'Level 5',14,0,'2020-07-20','CW 30','Week 8',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (89,'Level 5',14,0,'2020-07-20','CW 30','Week 8',2020,'Tutorial',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (90,'Level 5',14,0,'2020-07-27','CW 31','Week 9',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (91,'Level 5',14,0,'2020-08-03','CW 32','Week 10',2020,'Lecture',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (92,'Level 5',14,0,'2020-08-03','CW 32','Week 10',2020,'Tutorial',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (93,'Level 5',14,0,'2020-08-10','CW 33','Week 11',2020,'Tutorial',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (94,'Level 5',14,0,'2020-08-10','CW 33','Week 11',2020,'Lab',6,'3.00',8,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (95,'Level 5',14,0,'2020-08-17','CW 34','Week 12',2020,'Lab',6,'3.00',8,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (96,'Level 5',14,0,'2020-08-24','CW 35','Week 13',2020,'Revision',6,'2.00',2,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (97,'Level 5',14,0,'2020-08-31','CW 36','Week 14',2020,'Examination',6,'2.00',9,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (98,'Level 5',14,0,'2020-09-07','CW 37','Week 15',2020,'Examination',6,'2.00',9,'','Wednesday','Tuesday','Friday','Monday','Thursday'),
 (99,'Level 6',25,1,'2020-06-08','CW 24','Week 2',2020,'Lecture',7,'2.00',1,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (100,'Level 6',25,1,'2020-06-15','CW 25','Week 3',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (101,'Level 6',25,1,'2020-06-22','CW 26','Week 4',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (102,'Level 6',25,1,'2020-06-29','CW 27','Week 5',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (103,'Level 6',25,1,'2020-07-06','CW 28','Week 6',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (104,'Level 6',25,1,'2020-07-06','CW 28','Week 6',2020,'Lab',7,'4.00',10,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (105,'Level 6',25,1,'2020-07-13','CW 29','Week 7',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (106,'Level 6',25,1,'2020-07-20','CW 30','Week 8',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (107,'Level 6',25,1,'2020-07-20','CW 30','Week 8',2020,'Lab',7,'4.00',10,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (108,'Level 6',25,1,'2020-07-27','CW 31','Week 9',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (109,'Level 6',25,1,'2020-08-03','CW 32','Week 10',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (110,'Level 6',25,1,'2020-08-03','CW 32','Week 10',2020,'Tutorial',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (111,'Level 6',25,1,'2020-08-10','CW 33','Week 11',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (112,'Level 6',25,1,'2020-08-10','CW 33','Week 11',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (113,'Level 6',25,1,'2020-08-10','CW 33','Week 11',2020,'Lab',7,'4.00',10,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (114,'Level 6',25,1,'2020-08-17','CW 34','Week 12',2020,'Lecture',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (115,'Level 6',25,1,'2020-08-24','CW 35','Week 13',2020,'Revision',7,'2.00',5,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (116,'Level 6',25,1,'2020-08-31','CW 36','Week 14',2020,'Examination',7,'2.00',9,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (117,'Level 6',25,1,'2020-09-07','CW 37','Week 15',2020,'Examination',7,'2.00',9,'','Tuesday','Wednesday','Thursday','Friday','Monday'),
 (118,'Level 6',27,0,'2020-06-01','CW 23','Week 1',2020,'Induction Week',8,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (119,'Level 6',27,0,'2020-06-08','CW 24','Week 2',2020,'Lecture',8,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (120,'Level 6',27,0,'2020-06-15','CW 25','Week 3',2020,'Lecture',8,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (121,'Level 6',27,0,'2020-06-22','CW 26','Week 4',2020,'Lecture',8,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (122,'Level 6',27,0,'2020-06-29','CW 27','Week 5',2020,'Lecture',8,'2.00',1,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (123,'Level 6',27,0,'2020-07-06','CW 28','Week 6',2020,'Tutorial',8,'1.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (124,'Level 6',27,0,'2020-07-13','CW 29','Week 7',2020,'Tutorial',8,'1.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (125,'Level 6',27,0,'2020-07-20','CW 30','Week 8',2020,'Lecture',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (126,'Level 6',27,0,'2020-07-27','CW 31','Week 9',2020,'Lecture',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (127,'Level 6',27,0,'2020-07-27','CW 31','Week 9',2020,'Lab',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (128,'Level 6',27,0,'2020-08-03','CW 32','Week 10',2020,'Lecture',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (129,'Level 6',27,0,'2020-08-10','CW 33','Week 11',2020,'ICA',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (130,'Level 6',27,0,'2020-08-17','CW 34','Week 12',2020,'Lecture',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (131,'Level 6',27,0,'2020-08-24','CW 35','Week 13',2020,'Lecture',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (132,'Level 6',27,0,'2020-08-31','CW 36','Week 14',2020,'Revision',8,'2.00',5,'','Thursday','Monday','Wednesday','Tuesday','Friday'),
 (133,'Level 6',27,0,'2020-09-07','CW 37','Week 15',2020,'Examination',8,'2.00',9,'','Thursday','Monday','Wednesday','Tuesday','Friday');
/*!40000 ALTER TABLE `delivery_plan` ENABLE KEYS */;


--
-- Definition of table `delivery_plan_details`
--

DROP TABLE IF EXISTS `delivery_plan_details`;
CREATE TABLE `delivery_plan_details` (
  `delivery_plan_details_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `delivery_plan_details_delivery_plan_id` int(10) unsigned DEFAULT NULL,
  `delivery_plan_details_date` date DEFAULT NULL,
  `delivery_plan_details_time` varchar(100) DEFAULT NULL,
  `delivery_plan_details_time_order_no` int(10) unsigned DEFAULT NULL,
  `delivery_plan_details_status` tinyint(1) unsigned DEFAULT '1',
  `delivery_plan_details_remark` varchar(550) DEFAULT NULL,
  `delivery_plan_details_day` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`delivery_plan_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_plan_details`
--

/*!40000 ALTER TABLE `delivery_plan_details` DISABLE KEYS */;
INSERT INTO `delivery_plan_details` (`delivery_plan_details_id`,`delivery_plan_details_delivery_plan_id`,`delivery_plan_details_date`,`delivery_plan_details_time`,`delivery_plan_details_time_order_no`,`delivery_plan_details_status`,`delivery_plan_details_remark`,`delivery_plan_details_day`) VALUES 
 (1,1,'2020-10-01','9.00-11.00',1,1,NULL,NULL),
 (2,1,'2020-10-08','9.00-11.00',1,1,NULL,NULL),
 (3,1,'2020-10-15','9.00-11.00',1,1,NULL,NULL),
 (4,1,'2020-10-22','9.00-11.00',1,1,NULL,NULL),
 (5,1,'2020-10-22','9.00-11.00',1,1,NULL,NULL),
 (6,2,'2020-10-02','11.00-01.00',1,1,NULL,NULL),
 (7,2,'2020-10-09','11.00-01.00',1,1,NULL,NULL),
 (8,2,'2020-10-16','11.00-01.00',1,1,NULL,NULL),
 (9,2,'2020-10-23','11.00-01.00',1,1,NULL,NULL),
 (10,2,'2020-10-30','11.00-01.00',1,1,NULL,NULL),
 (11,2,'2020-11-06','11.00-01.00',1,1,NULL,NULL),
 (12,2,'2020-11-13','11.00-01.00',1,1,NULL,NULL),
 (13,3,'2020-10-01','11.00-01.00',2,1,NULL,NULL),
 (14,3,'2020-10-08','11.00-01.00',2,1,NULL,NULL),
 (15,3,'2020-10-15','11.00-01.00',2,1,NULL,NULL),
 (16,3,'2020-10-22','11.00-01.00',2,1,NULL,NULL),
 (17,4,'2020-10-01','06.00-09.00',0,1,NULL,NULL),
 (18,4,'2020-10-08','06.00-09.00',0,1,NULL,NULL),
 (19,4,'2020-10-15','06.00-09.00',0,1,NULL,NULL),
 (20,4,'2020-10-22','06.00-09.00',0,1,NULL,NULL);
/*!40000 ALTER TABLE `delivery_plan_details` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(450) NOT NULL,
  `employee_contactNo` varchar(45) DEFAULT NULL,
  `employee_address` varchar(450) DEFAULT NULL,
  `employee_detail` varchar(450) DEFAULT NULL,
  `employee_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `group`
--

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(150) DEFAULT NULL,
  `group_batch_id` int(10) unsigned DEFAULT NULL,
  `group_type` tinyint(1) unsigned DEFAULT NULL,
  `group_detail` varchar(450) DEFAULT NULL,
  `group_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group`
--

/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


--
-- Definition of table `group_info`
--

DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(150) DEFAULT NULL,
  `group_batch_id` int(10) unsigned DEFAULT NULL,
  `group_type` tinyint(1) unsigned DEFAULT NULL,
  `group_detail` varchar(450) DEFAULT NULL,
  `group_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_info`
--

/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
INSERT INTO `group_info` (`group_id`,`group_name`,`group_batch_id`,`group_type`,`group_detail`,`group_status`) VALUES 
 (4,'GR1',2018,1,'2020',1),
 (5,'GR2',2018,1,'2020',1),
 (6,'GR1_EEE',2018,2,'2020',1),
 (7,'GR2_EEE',2018,2,'2020',1),
 (8,'GR1_ECME',2018,2,'2020',1),
 (9,'GR1',2019,1,'2020',1),
 (10,'GR2',2019,1,'2020',1),
 (11,'GR1_EEE',2018,1,'2020',1),
 (12,'GR2_EEE',2018,1,'2020',1),
 (13,'GR1_ECME',2018,1,'2020',1),
 (14,'GR1',2020,1,'2020',1),
 (15,'GR2',2020,1,'2020',1);
/*!40000 ALTER TABLE `group_info` ENABLE KEYS */;


--
-- Definition of table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday` (
  `holiday_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `holiday_date_from` date DEFAULT NULL,
  `holiday_date_to` date DEFAULT NULL,
  `holiday_detail` varchar(600) DEFAULT NULL,
  `holiday_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `holiday`
--

/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` (`holiday_id`,`holiday_date_from`,`holiday_date_to`,`holiday_detail`,`holiday_status`) VALUES 
 (1,'2020-07-14','2020-07-29','poson poya day',1),
 (2,'2020-07-22','2020-07-12','wesak poya dey',1);
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;


--
-- Definition of table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
  `lecturer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lecturer_title` varchar(100) DEFAULT NULL,
  `lecturer_name` varchar(450) DEFAULT NULL,
  `lecturer_email` varchar(150) DEFAULT NULL,
  `lecturer_contact_no` varchar(45) DEFAULT NULL,
  `lecturer_detail` varchar(450) DEFAULT NULL,
  `lecturer_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`lecturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer`
--

/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` (`lecturer_id`,`lecturer_title`,`lecturer_name`,`lecturer_email`,`lecturer_contact_no`,`lecturer_detail`,`lecturer_status`) VALUES 
 (1,'Mr','Sameera Bandaranayaka','sb@gmail.com','0111111111','',1),
 (2,'Mr','Manoj Herath','mh@gmail.com','0117100100','',1),
 (3,'Mr','Dilan Fernando','df@gmail.com','0115533311','',1),
 (4,'Mr','Harshana Ranmuthugala','hr@gmail.com','0115566000','',1),
 (5,'Mrs','Umesha Sandarenu','us@gmail.com','0111111111','',1),
 (6,'Mr','Nalin Jayasooriya','nj@gmail.com','0111111111','',1),
 (7,'Mr','Darshana Bandara','db@gmail.com','0111111111','',1),
 (8,'Mr','Prashad Bandara','pb@gmail.com','0111111111','',1),
 (9,'Mr','P.W.Sarath','pw@gmil.com','0111111111','',1),
 (10,'Mr','Yasith Ganeaarachchi','yg@gmail.com','0111111111','',1),
 (11,'Mr','Dilan Sooriyamudalige','ds@gmail.com','0111111111','',1);
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;


--
-- Definition of table `lecturer_availablity`
--

DROP TABLE IF EXISTS `lecturer_availablity`;
CREATE TABLE `lecturer_availablity` (
  `lecturer_availablity_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lecturer_availablity_lec_id` int(10) unsigned DEFAULT NULL,
  `lecturer_availablity_unavailable_date` date DEFAULT NULL,
  `lecturer_availablity_unavailable_time_from` time DEFAULT NULL,
  `lecturer_availablity_unavailable_time_to` time DEFAULT NULL,
  `lecturer_availablity_status` tinyint(1) unsigned DEFAULT '1',
  `lecturer_availablity_detail` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`lecturer_availablity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lecturer_availablity`
--

/*!40000 ALTER TABLE `lecturer_availablity` DISABLE KEYS */;
INSERT INTO `lecturer_availablity` (`lecturer_availablity_id`,`lecturer_availablity_lec_id`,`lecturer_availablity_unavailable_date`,`lecturer_availablity_unavailable_time_from`,`lecturer_availablity_unavailable_time_to`,`lecturer_availablity_status`,`lecturer_availablity_detail`) VALUES 
 (1,NULL,NULL,'20:00:01',NULL,1,NULL),
 (2,1,'2020-07-15','07:00:00','14:30:00',1,''),
 (3,1,'2020-07-23','13:00:00','14:30:00',1,''),
 (4,1,'2020-07-18','18:00:00','06:00:00',1,''),
 (5,1,'2020-07-13','01:00:00','01:00:00',1,''),
 (6,1,'2020-07-22','01:00:00','05:00:00',1,'sss'),
 (7,1,'2020-07-08','01:00:00','01:00:00',1,'aaa'),
 (8,1,'2020-08-09','04:40:00','09:10:00',1,'');
/*!40000 ALTER TABLE `lecturer_availablity` ENABLE KEYS */;


--
-- Definition of table `lecturer_subject`
--

DROP TABLE IF EXISTS `lecturer_subject`;
CREATE TABLE `lecturer_subject` (
  `lecturer_subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lecturer_subject_lecturer_id` int(10) unsigned DEFAULT NULL,
  `lecturer_subject_subject_id` int(10) unsigned DEFAULT NULL,
  `lecturer_subject_detail_1` varchar(450) DEFAULT NULL,
  `lecturer_subject_detail_2` varchar(450) DEFAULT NULL,
  `lecturer_subject_detail_3` varchar(450) DEFAULT NULL,
  `lecturer_subject_satus_1` tinyint(1) unsigned DEFAULT '1',
  `lecturer_subject_satus_2` tinyint(1) unsigned DEFAULT '1',
  `lecturer_subject_satus_3` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`lecturer_subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer_subject`
--

/*!40000 ALTER TABLE `lecturer_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecturer_subject` ENABLE KEYS */;


--
-- Definition of table `preference_date`
--

DROP TABLE IF EXISTS `preference_date`;
CREATE TABLE `preference_date` (
  `preference_date_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `preference_date_1` varchar(90) DEFAULT NULL,
  `preference_date_2` varchar(90) DEFAULT NULL,
  `preference_date_3` varchar(90) DEFAULT NULL,
  `preference_date_4` varchar(90) DEFAULT NULL,
  `preference_date_5` varchar(90) DEFAULT NULL,
  `preference_date_status` tinyint(1) unsigned DEFAULT NULL,
  `preference_date_remark` varchar(450) DEFAULT NULL,
  `preference_date_delivery_plan_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`preference_date_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `preference_date`
--

/*!40000 ALTER TABLE `preference_date` DISABLE KEYS */;
/*!40000 ALTER TABLE `preference_date` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_name` varchar(150) DEFAULT NULL,
  `room_code` varchar(150) DEFAULT NULL,
  `room_detail` varchar(450) DEFAULT NULL,
  `room_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`room_id`,`room_name`,`room_code`,`room_detail`,`room_status`) VALUES 
 (1,'Lecture Room 1','LR1','',1),
 (2,'Lecture Room 2','LR2','',1),
 (3,'Lecture Room 3','LR3','',1),
 (4,'Lecture Room 4','LR4','',1),
 (5,'Lecture Room 5','LR5','',1),
 (6,'Computer Lab 1','CL1','',1),
 (7,'Computer Lab 2','CL2','',1),
 (8,'Computer Lab 3','CL3','',1),
 (9,'Auditorium','AUD','',1),
 (10,'CSP Lab','CSP','',1),
 (11,'DSM Lab','DSM','',1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `room_activity`
--

DROP TABLE IF EXISTS `room_activity`;
CREATE TABLE `room_activity` (
  `room_activity_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_activity_room_id` int(10) unsigned DEFAULT NULL,
  `room_activity_date` date DEFAULT NULL,
  `room_activity_time` time DEFAULT NULL,
  `room_activity_lecturer_id` int(10) unsigned DEFAULT NULL,
  `room_activity_detail` varchar(450) DEFAULT NULL,
  `room_activity_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`room_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_activity`
--

/*!40000 ALTER TABLE `room_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_activity` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `student_name` varchar(450) DEFAULT NULL,
  `student_email_1` varchar(150) DEFAULT NULL,
  `student_email_2` varchar(150) DEFAULT NULL,
  `student_reg_no` varchar(150) DEFAULT NULL,
  `student_contact_no` varchar(45) DEFAULT NULL,
  `student_detail` varchar(450) DEFAULT NULL,
  `student_status` tinyint(1) unsigned DEFAULT '1',
  `student_batch_id` int(10) unsigned DEFAULT NULL,
  `student_group_id` int(10) unsigned DEFAULT NULL,
  `student_special_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`student_id`,`student_name`,`student_email_1`,`student_email_2`,`student_reg_no`,`student_contact_no`,`student_detail`,`student_status`,`student_batch_id`,`student_group_id`,`student_special_id`) VALUES 
 (6,'amal','232amal@gmail.com','','reg001','119','test detail 1',1,1,5,6),
 (7,'viranga','viranga@gmail.com','','reg002','0117100100','test detail 2',1,2,5,6);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(450) DEFAULT NULL,
  `subject_module_code` varchar(100) DEFAULT NULL,
  `subject_detail` varchar(450) DEFAULT NULL,
  `subject_status` tinyint(1) unsigned DEFAULT '1',
  `subject_course_id` int(10) unsigned DEFAULT NULL,
  `subject_course_level` varchar(150) DEFAULT NULL,
  `subject_semester` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`subject_id`,`subject_name`,`subject_module_code`,`subject_detail`,`subject_status`,`subject_course_id`,`subject_course_level`,`subject_semester`) VALUES 
 (1,'Electronics','ECS-01','test detail',1,1,'Level 6','First Semester'),
 (2,'Information Technology','IT-02','test detail-001',1,0,'Level 5','Semester A'),
 (3,'Electrical','ELEC-03','test-01',1,0,'Level 6','First Semester');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;


--
-- Definition of table `subject_details`
--

DROP TABLE IF EXISTS `subject_details`;
CREATE TABLE `subject_details` (
  `subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(450) DEFAULT NULL,
  `subject_module_code` varchar(100) DEFAULT NULL,
  `subject_detail` varchar(450) DEFAULT NULL,
  `subject_status` tinyint(1) unsigned DEFAULT '1',
  `subject_course_id` int(10) unsigned DEFAULT NULL,
  `subject_course_level` varchar(150) DEFAULT NULL,
  `subject_semester` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_details`
--

/*!40000 ALTER TABLE `subject_details` DISABLE KEYS */;
INSERT INTO `subject_details` (`subject_id`,`subject_name`,`subject_module_code`,`subject_detail`,`subject_status`,`subject_course_id`,`subject_course_level`,`subject_semester`) VALUES 
 (1,'Career Skils Development','4FTC1178','',1,0,'Level 4','Semester A'),
 (2,'Engineering Mathematics','4FTC1179','',1,0,'Level 4','Semester A'),
 (3,'Introduction to Electronic Systems','4FTC1180','',1,0,'Level 4','Semester A'),
 (4,'Sustainable Business of Electronics','4FTC1181','',1,0,'Level 4','Semester A'),
 (5,'Digital Electronics & Computer Organization','4FTC1182','',1,0,'Level 4','Semester A'),
 (6,'Engineering Applications of Mathematics','4FTC1183','',1,0,'Level 4','Semester B'),
 (7,'Electrical and Electronic Theory','4FTC1184','',1,0,'Level 4','Semester B'),
 (8,'Electronic Engineering Practice','4FTC1185','',1,0,'Level 4','Semester B'),
 (9,'Computer Programming for Electronic Engineers','4FTC1186','',1,0,'Level 4','Semester A'),
 (10,'Further Engineering Mathematics','5FTC1210','',1,0,'Level 5','Semester A'),
 (11,'Digital Design & Embedded Systems','5FTC1211','',1,0,'Level 5','Semester A'),
 (12,'Real-time Systems & Programming','5FTC1212','',1,0,'Level 5','Semester B'),
 (13,'Electronic Communication Systems','5FTC1213','',1,0,'Level 5','Semester A'),
 (14,'Project Management & Product Developnemt','5FTC1214','',1,0,'Level 5','Semester B'),
 (15,'Electrical Engineering & Power Control','5FTC1215','',1,0,'Level 5','Semester A'),
 (16,'Mechatronic Systems Modelling and Control','5FTC1266','',1,0,'Level 5','Semester B'),
 (17,'Mini Projects (Electrical)','5FTC1217','',1,1,'Level 5','Semester B'),
 (18,'Mini Projects (Communications)','5FTC1218','',1,2,'Level 5','Semester B'),
 (19,'Mini Projects (Computer Enineering)','5FTC1219','',1,3,'Level 5','Semester B'),
 (20,'Carrer Planing','5FTC1220','',1,0,'Level 5','Semester A'),
 (21,'Careers Plortfoliyo','6FTC1154','',1,0,'Level 6','Semester A'),
 (22,'Microelectronics & VLSI','6FTC1155','',1,0,'Level 6','Semester A'),
 (23,'Digital Signal Processing','6FTC1156','',1,0,'Level 6','Semester A'),
 (24,'Power Systems','6FTC1157','',1,1,'Level 6','Semester A'),
 (25,'Mobile & Digital Communication Networks','6FTC1158','',1,2,'Level 6','Semester B'),
 (26,'Mobile & Digital Communication Networks','6FTC1158','',1,3,'Level 6','Semester B'),
 (27,'Intelligent Systems and Robotics','6FTC1159','',1,1,'Level 6','Semester B'),
 (28,'Intelligent Systems and Robotics','6FTC1159','',1,3,'Level 6','Semester B'),
 (29,'Advanced Power Conversion and Control','6FTC1160','',1,1,'Level 6','Semester B'),
 (30,'Optical Communication Systems','6FTC1161','',1,2,'Level 6','Semester A'),
 (31,'Satellite & Terrestrial Communication Systems','6FTC1162','',1,2,'Level 6','Semester B'),
 (32,'Computer Architecture','6FTC1163','',1,3,'Level 6','Semester B'),
 (33,'Operating Systems and Object Orianted Programming','6FTC1164','',1,3,'Level 6','Semester A'),
 (34,'Telecommunication Systems','6FTC1165','',1,1,'Level 6','Semester B'),
 (35,'Telecommunication Systems','6FTC1165','',1,2,'Level 6','Semester B'),
 (36,'Individual Major Project','6FTC1167','',1,0,'Level 6','Semester A'),
 (37,'Individual Major Project','6FTC1167','',1,0,'Level 6','Semester B');
/*!40000 ALTER TABLE `subject_details` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
