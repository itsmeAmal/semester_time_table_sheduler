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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch`
--

/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` (`batch_id`,`batch_year`,`batch_level`,`batch_detail`,`batch_status`) VALUES 
 (1,'2017','e-0011','test',1),
 (2,'2016','e-003','test 2',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`,`course_name`,`course_type`,`course_detail`,`course_satus`) VALUES 
 (1,'Electrical','EEE','detail 1',1),
 (2,'Telecommiunication','TC','detail 2',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `delivery_plan`
--

DROP TABLE IF EXISTS `delivery_plan`;
CREATE TABLE `delivery_plan` (
  `delivery_plan_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `delivery_plan_calender_week` varchar(150) DEFAULT NULL,
  `delivery_plan_class_contact_week` varchar(150) DEFAULT NULL,
  `delivery_plan_week_begining` date DEFAULT NULL,
  `delivery_plan_lecture_hours` varchar(150) DEFAULT NULL,
  `delivery_plan_tutorial_hours` varchar(150) DEFAULT NULL,
  `delivery_plan_lab_hours` varchar(150) DEFAULT NULL,
  `delivery_plan_remarks` varchar(450) DEFAULT NULL,
  `delivery_plan_detail` varchar(450) DEFAULT NULL,
  `delivery_plan_status` tinyint(1) unsigned DEFAULT '1',
  `delivery_plan_location` varchar(150) DEFAULT NULL,
  `delivery_plan_lecture_name` varchar(150) DEFAULT NULL,
  `delivery_plan_tutorial_name` varchar(150) DEFAULT NULL,
  `delivery_plan_lab_name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`delivery_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_plan`
--

/*!40000 ALTER TABLE `delivery_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_plan` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_info`
--

/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
INSERT INTO `group_info` (`group_id`,`group_name`,`group_batch_id`,`group_type`,`group_detail`,`group_status`) VALUES 
 (4,'group one 2019',2017,1,'test detail',1),
 (5,'group two 2020',2016,1,'test',1),
 (6,'group three 2020',2017,2,'test detail 2',1);
/*!40000 ALTER TABLE `group_info` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer`
--

/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` (`lecturer_id`,`lecturer_title`,`lecturer_name`,`lecturer_email`,`lecturer_contact_no`,`lecturer_detail`,`lecturer_status`) VALUES 
 (1,'Mr','amal','amal@test.com','0117100100','test detail',1),
 (2,'Mr','viranga','viranga@gmail.com','0117100100','remark-2',1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lecturer_availablity`
--

/*!40000 ALTER TABLE `lecturer_availablity` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`room_id`,`room_name`,`room_code`,`room_detail`,`room_status`) VALUES 
 (1,'LECTURE ROOM 1','LR1',NULL,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
