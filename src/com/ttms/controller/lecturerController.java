/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.lecturerDaoImpl;
import com.ttms.model.lecturer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class lecturerController {

    public static boolean addLecturer(String title, String name, String email, String contactNo, String detail) throws SQLException {
        lecturer lecturer = new lecturer();
        lecturer.setName(name);
        lecturer.setDetail(detail);
        lecturer.setContactNo(contactNo);
        lecturer.setEmail(email);
        lecturer.setStatus(lecturer.ACTIVE);
        lecturer.setTitle(title);
        return new lecturerDaoImpl().addLecturer(lecturer);
    }

    public static ResultSet getAllLecturers() throws SQLException {
        return new lecturerDaoImpl().getAlllecturers();
    }

}
