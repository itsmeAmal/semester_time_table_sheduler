/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.preferenceDateDaoImpl;
import com.ttms.model.preferenceDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class preferenceDateController {

    public static boolean addPreferenceDate(String date1, String date2, String date3,
            String date4, String date5, int deliveryPlanId) throws SQLException {
        preferenceDate preferenceDate = new preferenceDate();
        preferenceDate.setDate1(date1);
        preferenceDate.setDate2(date2);
        preferenceDate.setDate3(date3);
        preferenceDate.setDate4(date4);
        preferenceDate.setDate5(date5);
        preferenceDate.setDeliveryPlanId(deliveryPlanId);
        return new preferenceDateDaoImpl().addPreferenceDate(preferenceDate);
    }

    public static ResultSet getAllPreferenceDates() throws SQLException {
        return new preferenceDateDaoImpl().getAllPreferenceDates();
    }

    public static ResultSet getPreferenceDateByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new preferenceDateDaoImpl().getPreferenceDateByAttribute(attribute, condition, value);
    }

    public static ResultSet getPreferenceDatesByMoreAttributes(ArrayList<String[]> attributeConditionvalueList,
            String operator) throws SQLException {
        return new preferenceDateDaoImpl().getPreferenceDateByMoreAttributes(attributeConditionvalueList, operator);
    }

    public static preferenceDate getPreferenceDateByDeleveryReportId(int deliveryReportId) throws SQLException {
        ResultSet rset = getPreferenceDateByOneAttribute("preference_date_delivery_plan_id", commonConstants.Sql.EQUAL,
                Integer.toString(deliveryReportId));
        preferenceDate preferenceDate = null;
        while (rset.next()) {
            preferenceDate = new preferenceDate();
            preferenceDate.setDate1(rset.getString("preference_date_1"));
            preferenceDate.setDate2(rset.getString("preference_date_2"));
            preferenceDate.setDate3(rset.getString("preference_date_3"));
            preferenceDate.setDate4(rset.getString("preference_date_4"));
            preferenceDate.setDate5(rset.getString("preference_date_5"));
            preferenceDate.setDeliveryPlanId(rset.getInt("preference_date_delivery_plan_id"));
            preferenceDate.setStatus(rset.getInt("preference_date_status"));
            preferenceDate.setRemark(rset.getString("preference_date_remark"));
            preferenceDate.setId(rset.getInt("preference_date_id"));
        }
        return preferenceDate;
    }

}
