/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.courseDaoImpl;
import com.ttms.model.course;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class courseController {

    public static boolean addCourse(String name, String detail, String courseType) throws SQLException {
        course course = new course();
        course.setName(name);
        course.setDetail(detail);
        course.setType(courseType);
        return new courseDaoImpl().addCourse(course);
    }

    public static ResultSet getAllCourses() throws SQLException {
        return new courseDaoImpl().getAllCourses();
    }

    public static ResultSet getCourseByOneAttribute(String attribute, String condition,
            String value) throws SQLException {
        return new courseDaoImpl().getCourseByOneAttribute(attribute, condition, value);
    }

    public static course getCourseByCourseId(int courseId) throws SQLException {
        ResultSet rset = getCourseByOneAttribute("course_id", commonConstants.Sql.EQUAL, Integer.toString(courseId));
        course course = null;
        while (rset.next()) {
            course = new course();
            course.setDetail(rset.getString("course_detail"));
            course.setId(rset.getInt("course_id"));
            course.setName(rset.getString("course_name"));
            course.setType(rset.getString("course_type"));
            course.setStatus(rset.getInt("course_satus"));
        }
        return course;
    }

    public static boolean updateCourse(course course) throws SQLException {
        return new courseDaoImpl().updateCourse(course);
    }

}
