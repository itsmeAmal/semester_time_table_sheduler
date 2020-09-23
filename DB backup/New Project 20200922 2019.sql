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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`,`course_name`,`course_type`,`course_detail`,`course_satus`) VALUES 
 (1,'Electrical & Electronics Engineering','EEE','',1),
 (2,'Electronics & Communication Engineering','ECME','',1),
 (3,'Electronics & Computer Engineering','ECE','',1),
 (4,'EEE / ECME','EEE / ECME','Merged Course',0),
 (5,'EEE / ECE','EEE / ECE','Merged Course',0),
 (6,'ECME / ECE','ECME / ECE','Merged Course',0);
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
  PRIMARY KEY (`delivery_plan_id`),
  KEY `FK_delivery_plan_1` (`delivery_plan_lecturer_id`),
  KEY `FK_delivery_plan_2` (`delivery_plan_room_id`),
  CONSTRAINT `FK_delivery_plan_1` FOREIGN KEY (`delivery_plan_lecturer_id`) REFERENCES `lecturer` (`lecturer_id`),
  CONSTRAINT `FK_delivery_plan_2` FOREIGN KEY (`delivery_plan_room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_plan`
--

/*!40000 ALTER TABLE `delivery_plan` DISABLE KEYS */;
INSERT INTO `delivery_plan` (`delivery_plan_id`,`delivery_plan_level_str`,`delivery_plan_module_id`,`delivery_plan_repeat_students_available`,`delivery_plan_week_begining_date`,`delivery_plan_calender_week`,`delivery_plan_class_contact_week`,`delivery_plan_year`,`delivery_plan_type`,`delivery_plan_lecturer_id`,`delivery_plan_lecture_hours`,`delivery_plan_room_id`,`delivery_plan_remark`,`delivery_plan_day_1`,`delivery_plan_day_2`,`delivery_plan_day_3`,`delivery_plan_day_4`,`delivery_plan_day_5`) VALUES 
 (1,'Level 4',3,0,'2020-09-10','CW 37','Week 4',2020,'Lecture',6,'0.00',9,'test remark','2020-09-22','Level 4','','',''),
 (2,'Level 4',4,0,'2020-09-18','CW 38','Week 4',2020,'Tutorial',5,'0.00',5,'test remark','2020-09-30','Level 4','','',''),
 (3,'Level 5',2,0,'2020-09-03','CW 36','Week 4',2020,'Lab',6,'0.00',4,'test remark','2020-09-10','Level 5','','',''),
 (4,'Level 5',3,0,'2020-09-06','CW 37','Week 5',2020,'Revision',5,'0.00',3,'','2020-09-07','Level 5','09:00:00','',''),
 (5,'Level 5',1,0,'2020-09-06','CW 37','Week 3',2020,'Examination',4,'0.00',3,'','2020-09-07','Level 5','11:00:00','','');
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
  `delivery_plan_details_level` varchar(45) DEFAULT NULL,
  `delivery_plan_details_module_name` varchar(450) DEFAULT NULL,
  `delivery_plan_details_module_code` varchar(450) DEFAULT NULL,
  `delivery_plan_details_type` varchar(45) DEFAULT NULL,
  `delivery_plan_details_lecturer_name` varchar(450) DEFAULT NULL,
  `delivery_plan_details_room_name` varchar(150) DEFAULT NULL,
  `delivery_plan_details_course_name` varchar(150) DEFAULT NULL,
  `delivery_plan_details_group_name` varchar(150) DEFAULT NULL,
  `delivery_plan_details_start_time` time DEFAULT NULL,
  `delivery_plan_details_lecture_duration` varchar(45) DEFAULT NULL,
  `delivery_plan_details_end_time` time DEFAULT NULL,
  PRIMARY KEY (`delivery_plan_details_id`),
  KEY `FK_delivery_plan_details_1` (`delivery_plan_details_delivery_plan_id`),
  CONSTRAINT `FK_delivery_plan_details_1` FOREIGN KEY (`delivery_plan_details_delivery_plan_id`) REFERENCES `delivery_plan` (`delivery_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_plan_details`
--

/*!40000 ALTER TABLE `delivery_plan_details` DISABLE KEYS */;
INSERT INTO `delivery_plan_details` (`delivery_plan_details_id`,`delivery_plan_details_delivery_plan_id`,`delivery_plan_details_date`,`delivery_plan_details_time`,`delivery_plan_details_time_order_no`,`delivery_plan_details_status`,`delivery_plan_details_remark`,`delivery_plan_details_day`,`delivery_plan_details_level`,`delivery_plan_details_module_name`,`delivery_plan_details_module_code`,`delivery_plan_details_type`,`delivery_plan_details_lecturer_name`,`delivery_plan_details_room_name`,`delivery_plan_details_course_name`,`delivery_plan_details_group_name`,`delivery_plan_details_start_time`,`delivery_plan_details_lecture_duration`,`delivery_plan_details_end_time`) VALUES 
 (1,4,'2020-09-06','09:00:00',1,1,'','','Level 5','Introduction to Electronic Systems','4FTC1180','Revision','Umesha Sandarenu','Lecture Room 3','Course Name','Group Name','09:00:00','01:30:00','10:30:00'),
 (2,5,'2020-09-06','15:00:00',3,1,'','','Level 5','Career Skils Development','4FTC1178','Lab','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','15:00:00','01:30:00','16:30:00'),
 (3,5,'2020-09-06','11:00:00',5,1,'','','Level 5','Career Skils Development','4FTC1178','Examination','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','11:00:00','01:30:00','12:30:00'),
 (4,5,'2020-09-06','13:00:00',6,1,'','','Level 5','Career Skils Development','4FTC1178','Examination','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','13:00:00','01:30:00','14:30:00'),
 (5,5,'2020-09-07','15:00:00',9,1,'','','Level 5','Career Skils Development','4FTC1180','Examination','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','15:00:00','01:30:00','16:30:00'),
 (6,5,'2020-09-07','11:00:00',13,1,'','','Level 5','Career Skils Development','4FTC1178','Lab','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','11:00:00','02:00:00','13:00:00'),
 (7,5,'2020-09-06','15:00:00',3,1,'','','Level 5','Career Skils Development','4FTC1178','Lecture','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','15:00:00','01:30:00','16:30:00'),
 (8,5,'2020-09-06','11:00:00',5,1,'','','Level 5','Career Skils Development','4FTC1180','Tutorial','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','11:00:00','01:30:00','12:30:00'),
 (9,5,'2020-09-06','13:00:00',6,1,'','','Level 5','Career Skils Development','4FTC1178','Tutorial','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','13:00:00','01:30:00','14:30:00'),
 (10,5,'2020-09-07','15:00:00',9,1,'','','Level 5','Career Skils Development','4FTC1180','Tutorial','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','15:00:00','01:30:00','16:30:00'),
 (11,5,'2020-09-07','11:00:00',13,1,'','','Level 5','Career Skils Development','4FTC1178','Examination','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','11:00:00','02:00:00','13:00:00'),
 (12,5,'2020-09-07','11:00:00',15,1,'','','Level 6','Career Skils Development','4FTC1178','Induction Week','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','11:00:00','01:00:00','12:00:00'),
 (13,5,'2020-09-07','09:00:00',17,1,'','','Level 6','Career Skils Development','4FTC1178','Induction Week','Harshana Ranmuthugala','Lecture Room 3','Course Name','Group Name','09:00:00','01:00:00','10:00:00');
/*!40000 ALTER TABLE `delivery_plan_details` ENABLE KEYS */;


--
-- Definition of table `group_info`
--

DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(150) DEFAULT NULL,
  `group_batch_id` int(10) unsigned DEFAULT NULL,
  `group_type` varchar(150) DEFAULT NULL,
  `group_detail` varchar(450) DEFAULT NULL,
  `group_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_info`
--

/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `holiday`
--

/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` (`holiday_id`,`holiday_date_from`,`holiday_date_to`,`holiday_detail`,`holiday_status`) VALUES 
 (3,'2020-04-07','2020-04-07','Bak Full Moon Poya Day',1),
 (4,'2020-04-10','2020-04-10','Good Friday',1),
 (5,'2020-04-12','2020-04-26','New Year Holiday',1),
 (6,'2020-05-01','2020-05-01','May Day',1),
 (7,'2020-05-07','2020-05-08','Vesak Full Moon Poya Day',1),
 (8,'2020-05-25','2020-05-25','Eid al-Fitr Holiday',1),
 (9,'2020-06-04','2020-06-04','Public Holiday',1),
 (10,'2020-06-05','2020-06-05','Poson Full Moon Poya Day',1),
 (11,'2020-07-04','2020-07-04','Esala Full Moon Poya Day',1),
 (12,'2020-08-01','2020-08-01','Eid al-Adha',1),
 (13,'2020-08-03','2020-08-03','Nikini Full Moon Poya Day',1),
 (14,'2020-09-01','2020-09-01','Binara Full Moon Poya Day',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

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
 (6,'Mr','Naleen Jayasuriya','nj@gmail.com','0111111111','',1),
 (7,'Mr','Darshana Bandara','db@gmail.com','0111111111','',1),
 (8,'Mr','Prashad Bandara','pb@gmail.com','0111111111','',1),
 (9,'Mr','P.W.Sarath','pw@gmil.com','0111111111','',1),
 (10,'Mr','Yasith Ganeaarachchi','yg@gmail.com','0111111111','',1),
 (11,'Mr','Dilan Sooriyamudalige','ds@gmail.com','0111111111','',1),
 (12,'Mr','Lalinda  Liyanage','ll@gmail.com','0111111111','',1);
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
  PRIMARY KEY (`lecturer_availablity_id`),
  KEY `FK_lecturer_availablity_1` (`lecturer_availablity_lec_id`),
  CONSTRAINT `FK_lecturer_availablity_1` FOREIGN KEY (`lecturer_availablity_lec_id`) REFERENCES `lecturer` (`lecturer_id`)
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
  PRIMARY KEY (`lecturer_subject_id`),
  KEY `FK_lecturer_subject_1` (`lecturer_subject_lecturer_id`),
  CONSTRAINT `FK_lecturer_subject_1` FOREIGN KEY (`lecturer_subject_lecturer_id`) REFERENCES `lecturer` (`lecturer_id`),
  CONSTRAINT `FK_lecturer_subject_2` FOREIGN KEY (`lecturer_subject_id`) REFERENCES `subject` (`subject_id`)
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
  PRIMARY KEY (`preference_date_id`),
  KEY `FK_preference_date_1` (`preference_date_delivery_plan_id`),
  CONSTRAINT `FK_preference_date_1` FOREIGN KEY (`preference_date_delivery_plan_id`) REFERENCES `delivery_plan` (`delivery_plan_id`)
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
  PRIMARY KEY (`room_activity_id`),
  KEY `FK_room_activity_1` (`room_activity_room_id`),
  KEY `FK_room_activity_2` (`room_activity_lecturer_id`),
  CONSTRAINT `FK_room_activity_1` FOREIGN KEY (`room_activity_room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FK_room_activity_2` FOREIGN KEY (`room_activity_lecturer_id`) REFERENCES `lecturer` (`lecturer_id`)
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
  PRIMARY KEY (`student_id`),
  KEY `FK_student_1` (`student_batch_id`),
  KEY `FK_student_2` (`student_group_id`),
  KEY `FK_student_3` (`student_special_id`),
  CONSTRAINT `FK_student_1` FOREIGN KEY (`student_batch_id`) REFERENCES `batch` (`batch_id`),
  CONSTRAINT `FK_student_2` FOREIGN KEY (`student_group_id`) REFERENCES `group_info` (`group_id`),
  CONSTRAINT `FK_student_3` FOREIGN KEY (`student_special_id`) REFERENCES `group_info` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_details`
--

/*!40000 ALTER TABLE `subject_details` DISABLE KEYS */;
INSERT INTO `subject_details` (`subject_id`,`subject_name`,`subject_module_code`,`subject_detail`,`subject_status`,`subject_course_id`,`subject_course_level`,`subject_semester`) VALUES 
 (38,'Mobile & Digital Communication Networks','6FTC1158','',1,6,'Level 6','Semester B'),
 (39,'Intelligent Systems and Robotics','6FTC1159','',1,5,'Level 6','Semester B'),
 (40,'Advanced Power Conversion and Control','6FTC1160','',1,1,'Level 6','Semester B'),
 (41,'Satellite & Terrestrial Communication Systems','6FTC1162','',1,2,'Level 6','Semester B'),
 (42,'Telecommunication Systems','6FTC1165','',1,4,'Level 6','Semester B'),
 (43,'Real-time Systems & Programming','5FTC1212','',1,0,'Level 5','Semester B'),
 (44,'Project Management & Product Developnemt','5FTC1214','',1,0,'Level 5','Semester B'),
 (45,'Mechatronic Systems Modelling and Control','5FTC1266','',1,0,'Level 5','Semester B'),
 (46,'Engineering Applications of Mathematics','4FTC1183','',1,0,'Level 4','Semester B'),
 (47,'Electrical and Electronic Theory','4FTC1184','',1,0,'Level 4','Semester B'),
 (48,'Electronic Engineering Practice','4FTC1185','',1,0,'Level 4','Semester B');
/*!40000 ALTER TABLE `subject_details` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_pw` varchar(450) DEFAULT NULL,
  `user_type` varchar(45) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_status` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`user_name`,`user_pw`,`user_type`,`user_email`,`user_password`,`user_status`) VALUES 
 (1,'admin','1234','1','232amal@gmail.com','1234',1),
 (1003,'','','Admin',NULL,NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;