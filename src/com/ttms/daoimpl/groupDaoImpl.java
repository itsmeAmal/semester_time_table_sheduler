/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.groupDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class groupDaoImpl implements groupDao {

    private String selectQuery = "select group_id, group_name, group_batch_id, group_type, group_detail, group_status from group_info";

    @Override
    public boolean addGroup(group group) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into group_info (group_name, group_batch_id, group_type, group_detail, group_status) values (?,?,?,?,?)");
        ps.setString(1, group.getName());
        ps.setInt(2, group.getBatchId());
        ps.setInt(3, group.getType());
        ps.setString(4, group.getDetail());
        ps.setInt(5, group.getStatus());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllGroups() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getGroupByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateGroup(group group) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update group_info set group_name=?, group_batch_id=?, group_type=?, group_detail=?, group_status=? where group_id=?");
        ps.setString(1, group.getName());
        ps.setInt(2, group.getBatchId());
        ps.setInt(3, group.getType());
        ps.setString(4, group.getDetail());
        ps.setInt(5, group.getStatus());
        ps.setInt(6, group.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteGroup(int groupId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from group_info where group_id=?");
        ps.setInt(1, groupId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public ResultSet getAllNormalGroups() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select group_id, group_name, group_batch_id, group_type, "
                + "group_detail, group_status from group_info where group_type=1");
        return ps.executeQuery();
    }

    public ResultSet getAllSpecialGroups() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select group_id, group_name, group_batch_id, group_type, "
                + "group_detail, group_status from group_info where group_type=1");
        return ps.executeQuery();
    }

}
