/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.subjectDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class subjectDaoImpl implements subjectDao {

    private String selectQuery = "select subject_id, subject_name, subject_module_code, subject_detail, subject_status from subject";

    @Override
    public boolean addSubject(subject subject) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into subject (subject_name, subject_module_code, subject_detail, "
                + " subject_status) values (?,?,?,?)");
        ps.setString(1, subject.getName());
        ps.setString(2, subject.getModuleCode());
        ps.setString(3, subject.getDetail());
        ps.setInt(4, subject.getStatus());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllSubject() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getSubjectByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateSubject(subject subject) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update subject set subject_name=?, subject_module_code=?, "
                + " subject_detail=?, subject_status=? where subject_id=?");
        ps.setString(1, subject.getName());
        ps.setString(2, subject.getModuleCode());
        ps.setString(3, subject.getDetail());
        ps.setInt(4, subject.getStatus());
        ps.setInt(5, subject.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteSubject(int subjectId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from subject where subject_id=?");
        ps.setInt(1, subjectId);
        ps.executeQuery();
        ps.close();
        return true;
    }

}
