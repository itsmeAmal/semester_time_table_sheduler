/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.holidayDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.holiday;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class holidayDaoImpl implements holidayDao {

    private String selectQuery = "select holiday_id, holiday_date_from, holiday_date_to, holiday_detail, holiday_status from holiday";

    @Override
    public boolean addHoliday(holiday holiday) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into holiday (holiday_date_from, holiday_date_to, "
                + "holiday_detail) values (?,?,?)");
        ps.setDate(1, holiday.getFromDate());
        ps.setDate(2, holiday.getToDate());
        ps.setString(3, holiday.getDetail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateHoliday(holiday holiday) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllHolidays() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getHolidayByOneAttribute(String attribute, String condition, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getHolidayByMoreAttributes(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteHoliday(int holidayId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
