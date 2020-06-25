/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.studentDaoImpl;
import com.ttms.model.student;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class studentController {

    public static boolean addStudent(String name, String email1, String email2,
            String regNo, String contactNo, String detail,
            int groupId, int batchId, int specialGroupId) throws SQLException {
        student student = new student();
        student.setName(name);
        student.setEmail1(email1);
        student.setEmail2(email2);
        student.setRegNo(regNo);
        student.setContactNo(contactNo);
        student.setDetail(detail);
        student.setGroupId(groupId);
        student.setBatchId(batchId);
        student.setSpecialId(specialGroupId);
        student.setStatus(student.ACTIVE_STUDENT);
        return new studentDaoImpl().addStudent(student);
    }

    public static ResultSet getAllStudents() throws SQLException {
        return new studentDaoImpl().getAllStudents();
    }

    public static ResultSet getStudentResultSetByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new studentDaoImpl().getStudentByOneAttribute(attribute, condition, value);
    }

    public static boolean updateStudentDetails(student student) throws SQLException {
        return new studentDaoImpl().updateStudent(student);
    }

    public static student getStudentByStudentId(int studentId) throws SQLException {
        ResultSet rset = getStudentResultSetByOneAttribute("student_id", commonConstants.Sql.EQUAL, Integer.toString(studentId));
        student student = null;
        while (rset.next()) {
            student = new student();
            student.setId(rset.getInt("student_id"));
            student.setName(rset.getString("student_name"));
            student.setEmail1(rset.getString("student_email_1"));
            student.setEmail2(rset.getString("student_email_2"));
            student.setRegNo(rset.getString("student_reg_no"));
            student.setContactNo(rset.getString("student_contact_no"));
            student.setDetail(rset.getString("student_detail"));
            student.setStatus(rset.getInt("student_status"));
            student.setBatchId(rset.getInt("student_batch_id"));
            student.setGroupId(rset.getInt("student_group_id"));
            student.setSpecialId(rset.getInt("student_special_id"));
        }
        return student;
    }

    public static ResultSet getAllStudentsWithOtherJoinDetails() throws SQLException {
        return new studentDaoImpl().getAllStudentsWithOtherJoinDetails();
    }

}
