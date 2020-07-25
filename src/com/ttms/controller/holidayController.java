/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.holidayDaoImpl;
import com.ttms.model.holiday;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class holidayController {

    public static boolean addHolidayDetails(Date holidayFrom, Date holidayTo, String detail) throws SQLException {
        holiday holiday = new holiday();
        holiday.setFromDate(holidayFrom);
        holiday.setToDate(holidayTo);
        holiday.setDetail(detail);
        return new holidayDaoImpl().addHoliday(holiday);
    }

    public static ResultSet getAllHolidays() throws SQLException {
        return new holidayDaoImpl().getAllHolidays();
    }

    public static ResultSet getHolidayByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new holidayDaoImpl().getHolidayByOneAttribute(attribute, condition, value);
    }

    public static ResultSet getHolidayByMoreAttributes(ArrayList<String[]> attributeCOnditionValueList, String operator) throws SQLException {
        return new holidayDaoImpl().getHolidayByMoreAttributes(attributeCOnditionValueList, operator);
    }

    public static boolean updateHoliday(String detail, Date fromDate, Date toDate, int holidayId) throws SQLException {
        holiday holiday = new holiday();
        holiday.setDetail(detail);
        holiday.setFromDate(fromDate);
        holiday.setToDate(toDate);
        holiday.setId(holidayId);
        return new holidayDaoImpl().updateHoliday(holiday);
    }

    public static boolean deleteHoliday(int holidayId) throws SQLException {
        return new holidayDaoImpl().deleteHoliday(holidayId);
    }

}
