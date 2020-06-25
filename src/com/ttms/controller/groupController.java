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

    public static boolean addGroupDetail(String detail, int batchId, String name, int groupType) throws SQLException {
        group group = new group();
        group.setDetail(detail);
        group.setBatchId(batchId);
        group.setName(name);
        group.setStatus(group.ACTIVE_GROUP);
        group.setType(groupType);
        return new groupDaoImpl().addGroup(group);
    }

    public static group getGroupByGroupId(int groupId) throws SQLException {
        ResultSet rset = getGroupByOneAttribute("group_id", commonConstants.Sql.EQUAL, Integer.toString(groupId));
        group group = null;
        while (rset.next()) {
            group = new group();
            group.setId(rset.getInt("group_id"));
            group.setName(rset.getString("group_name"));
            group.setBatchId(rset.getInt("group_batch_id"));
            group.setType(rset.getInt("group_type"));
            group.setDetail(rset.getString("group_detail"));
            group.setStatus(rset.getInt("group_status"));
        }
        return group;
    }

    public static boolean updateGroup(group group) throws SQLException {
        return new groupDaoImpl().updateGroup(group);
    }
}
