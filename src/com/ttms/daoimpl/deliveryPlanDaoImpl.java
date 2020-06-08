/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.deliveryPlanDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.deliveryPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class deliveryPlanDaoImpl implements deliveryPlanDao {

    private String selectQuery = "select delivery_plan_id, delivery_plan_calender_week, delivery_plan_class_contact_week, "
            + " delivery_plan_week_begining, delivery_plan_lecture_hours, delivery_plan_tutorial_hours, delivery_plan_lab_hours, "
            + " delivery_plan_remarks, delivery_plan_detail, delivery_plan_status, delivery_plan_location,"
            + " delivery_plan_lecture_name, delivery_plan_tutorial_name, delivery_plan_lab_name from delivery_plan";

    @Override
    public boolean addDeliveryPlan(deliveryPlan deliveryPlan) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into delivery_plan (delivery_plan_calender_week, "
                + " delivery_plan_class_contact_week, delivery_plan_week_begining, delivery_plan_lecture_hours, "
                + " delivery_plan_tutorial_hours, delivery_plan_lab_hours, delivery_plan_remarks, delivery_plan_detail, "
                + " delivery_plan_status, delivery_plan_location, delivery_plan_lecture_name, delivery_plan_tutorial_name, "
                + " delivery_plan_lab_name) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, deliveryPlan.getCalenderWeek());
        ps.setString(2, deliveryPlan.getClassContactWeek());
        ps.setDate(3, deliveryPlan.getWeekBegining());
        ps.setString(4, deliveryPlan.getLectureHours());
        ps.setString(5, deliveryPlan.getTutorialHours());
        ps.setString(6, deliveryPlan.getLabHours());
        ps.setString(7, deliveryPlan.getRemarks());
        ps.setString(8, deliveryPlan.getDetail());
        ps.setInt(9, deliveryPlan.getStatus());
        ps.setString(10, deliveryPlan.getLocation());
        ps.setString(11, deliveryPlan.getLecturName());
        ps.setString(12, deliveryPlan.getTutorialName());
        ps.setString(13, deliveryPlan.getLabName());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllDeliveryPlans() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getDeliveryPlanByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateDeliveryPlan(deliveryPlan deliveryPlan) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update delivery_plan set delivery_plan_calender_week=?, "
                + "delivery_plan_class_contact_week=?, delivery_plan_week_begining=?, delivery_plan_lecture_hours=?, "
                + "delivery_plan_tutorial_hours=?, delivery_plan_lab_hours=?, delivery_plan_remarks=?, delivery_plan_detail=?, "
                + "delivery_plan_status=?, delivery_plan_location=?, delivery_plan_lecture_name=?, delivery_plan_tutorial_name=?, "
                + "delivery_plan_lab_name=? where delivery_plan_id=?");
        ps.setString(1, deliveryPlan.getCalenderWeek());
        ps.setString(2, deliveryPlan.getClassContactWeek());
        ps.setDate(3, deliveryPlan.getWeekBegining());
        ps.setString(4, deliveryPlan.getLectureHours());
        ps.setString(5, deliveryPlan.getTutorialHours());
        ps.setString(6, deliveryPlan.getLabHours());
        ps.setString(7, deliveryPlan.getRemarks());
        ps.setString(8, deliveryPlan.getDetail());
        ps.setInt(9, deliveryPlan.getStatus());
        ps.setString(10, deliveryPlan.getLocation());
        ps.setString(11, deliveryPlan.getLecturName());
        ps.setString(12, deliveryPlan.getTutorialName());
        ps.setString(13, deliveryPlan.getLabName());
        ps.setInt(14, deliveryPlan.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteDeliveryPlan(int deleveryPlanId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from delivery_plan where delivery_plan_id=?");
        ps.setInt(1, deleveryPlanId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

}
