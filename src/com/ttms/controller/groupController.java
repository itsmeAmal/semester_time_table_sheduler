/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.groupDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class groupController {

    public static ResultSet getAllGroups() throws SQLException {
        return new groupDaoImpl().getAllGroups();
    }

    public static ResultSet getGrroupByOneAttribute(String attribute,
            String condition, String value) throws SQLException {
        return new groupDaoImpl().getGroupByOneAttribute(attribute, condition, value);
    }
}
