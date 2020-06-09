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

    public static boolean addStudent(String name, String email1, String email2, String regNo, String contactNo, String detail,
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

}
