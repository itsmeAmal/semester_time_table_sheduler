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
import java.util.ArrayList;

/**
 *
 * @author Amal
 */
public class subjectDaoImpl implements subjectDao {

    private String selectQuery = "select subject_id, subject_name, subject_module_code, subject_detail, subject_status, "
            + "subject_course_id, subject_course_level, subject_semester from subject";

    private String selectQuery2 = "SELECT subject_id, subject_name, subject_module_code, subject_detail, subject_status, "
            + "subject_course_id, if(subject_course_id=0, 'Common', course_type) as course_type, subject_course_level, "
            + "subject_semester FROM subject left join course on course_id=subject_course_id where subject_status=1";

    @Override

    public boolean addSubject(subject subject) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into subject (subject_name, subject_module_code, subject_detail, "
                + " subject_status, subject_course_id, subject_course_level, subject_semester) values (?,?,?,?,?,?,?)");
        ps.setString(1, subject.getName());
        ps.setString(2, subject.getModuleCode());
        ps.setString(3, subject.getDetail());
        ps.setInt(4, subject.getStatus());
        ps.setInt(5, subject.getCourseId());
        ps.setString(6, subject.getCourseLevel());
        ps.setString(7, subject.getSemester());
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
                + " subject_detail=?, subject_status=?, subject_course_id=?, subject_course_level=?, subject_semester=?"
                + " where subject_id=?");
        ps.setString(1, subject.getName());
        ps.setString(2, subject.getModuleCode());
        ps.setString(3, subject.getDetail());
        ps.setInt(4, subject.getStatus());
        ps.setInt(5, subject.getCourseId());
        ps.setString(6, subject.getCourseLevel());
        ps.setString(7, subject.getSemester());
        ps.setInt(8, subject.getId());
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

    public ResultSet getActiveAndCourseJoinedSubjectDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery2);
    }

    public ResultSet getSubjectByMoreAttributes(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        return new commonDaoImpl().getResultByAttributesWithJoinOperator(selectQuery, attributeConditionValueList, operator);
    }

}
