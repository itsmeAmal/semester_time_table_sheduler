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
 (2,'Telecommiunication2','TC','detail 2',1);
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
 (4,'Level 5',2,0,'2020-08-17','CW 34','Week 5',2020,'Lecture',2,'3.00',1,'','Friday','Monday','Wednesday','Thursday','Tuesday');
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
 (2,'2020-07-22','2020-07-12','wesak poya day',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
 (7,1,'2020-07-08','01:00:00','01:00:00',1,'aaa');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`room_id`,`room_name`,`room_code`,`room_detail`,`room_status`) VALUES 
 (1,'Lecture Room ','LR1',NULL,1),
 (2,'Computer Lab 1','CL-1','',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_details`
--

/*!40000 ALTER TABLE `subject_details` DISABLE KEYS */;
INSERT INTO `subject_details` (`subject_id`,`subject_name`,`subject_module_code`,`subject_detail`,`subject_status`,`subject_course_id`,`subject_course_level`,`subject_semester`) VALUES 
 (1,'Electronics','ECS-01','test detail',1,1,'Level 6','First Semester'),
 (2,'Information Technology','IT-02','test detail-001',1,0,'Level 5','Semester A'),
 (3,'Electrical','ELEC-03','test-01',1,0,'Level 6','First Semester');
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
