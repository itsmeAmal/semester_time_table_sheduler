/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.controller.commonConstants;
import com.ttms.dao.commonDao;
import com.ttms.databaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chamalki Madushika
 */
public class commonDaoImpl implements commonDao {

    @Override
    public ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery + commonConstants.Sql.WHERE + attribute + condition
                + commonConstants.Sql.PARAMETER);

        ps.setString(1, value);
        ResultSet rst = ps.executeQuery();
        return rst;
    }

    @Override
    public ResultSet getAllRecords(String selectQuery) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rst = ps.executeQuery();
        return rst;
    }

    public ResultSet getResultByAttributesWithJoinOperator(String selectQuery,
            ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {

        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps;
        int noOfConditions = attributeConditionValueList.size();
        if (noOfConditions == 0) {
            ps = con.prepareStatement(selectQuery);
        } else {
            String query = selectQuery + commonConstants.Sql.WHERE + attributeConditionValueList.get(0)[0]
                    + attributeConditionValueList.get(0)[1] + commonConstants.Sql.PARAMETER;

            for (int i = 1; i < noOfConditions; i++) {
                query = query + operator + attributeConditionValueList.get(i)[0]
                        + attributeConditionValueList.get(i)[1] + commonConstants.Sql.PARAMETER;
            }
            ps = con.prepareStatement(query);

            for (int i = 0; i < noOfConditions; i++) {
                ps.setString(i + 1, attributeConditionValueList.get(i)[2]);
            }
        }
        ResultSet rst = ps.executeQuery();
        return rst;
    }

    public boolean isNotAvailableTime() throws SQLException {
        boolean status = false;
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select * from delivery_plan_details "
                + "where delivery_plan_details_start_time "
                + "between delivery_plan_details_start_time "
                + "and delivery_plan_details_end_time");
        ResultSet rset = ps.executeQuery();
        if (rset.next()) {
            status = true;
        }
        return status;
    }

    public int GetLectureCountByDateAndCoduleCode(Date Date, String ModeuleCode) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(delivery_plan_details_module_code) as lecture_count "
                + "from delivery_plan_details where delivery_plan_details_module_code=? and delivery_plan_details_date>=? "
                + "and delivery_plan_details_type='Lecture'");
        ps.setString(1, ModeuleCode);
        ps.setDate(2, Date);
        int count = 0;
        ResultSet rset = ps.executeQuery();
        while (rset.next()) {            
            count = rset.getInt("lecture_count");
        }
        return count;
    }
    public int GetTutorialCountByDateAndCoduleCode(Date Date, String ModeuleCode) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(delivery_plan_details_module_code) as lecture_count "
                + "from delivery_plan_details where delivery_plan_details_module_code=? and delivery_plan_details_date>=? "
                + "and delivery_plan_details_type='Tutorial'");
        ps.setString(1, ModeuleCode);
        ps.setDate(2, Date);
        int count = 0;
        ResultSet rset = ps.executeQuery();
        while (rset.next()) {            
            count = rset.getInt("lecture_count");
        }
        return count;
    }
    public int GetLabCountByDateAndCoduleCode(Date Date, String ModeuleCode) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(delivery_plan_details_module_code) as lecture_count "
                + "from delivery_plan_details where delivery_plan_details_module_code=? and delivery_plan_details_date>=? "
                + "and delivery_plan_details_type='Lab'");
        ps.setString(1, ModeuleCode);
        ps.setDate(2, Date);
        int count = 0;
        ResultSet rset = ps.executeQuery();
        while (rset.next()) {            
            count = rset.getInt("lecture_count");
        }
        return count;
    }
}
