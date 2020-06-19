/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.groupDaoImpl;
import com.ttms.model.group;
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

    public static ResultSet getGroupByOneAttribute(String attribute,
            String condition, String value) throws SQLException {
        return new groupDaoImpl().getGroupByOneAttribute(attribute, condition, value);
    }
    
    public static boolean addGroupDetail(String detail, int batchId, String name, int groupType)throws SQLException{
        group group = new group();
        group.setDetail(detail);
        group.setBatchId(batchId);
        group.setName(name);
        group.setStatus(group.ACTIVE_GROUP); 
        group.setType(batchId);
        return new groupDaoImpl().addGroup(group);
    }
}
