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
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class deliveryPlanDaoImpl implements deliveryPlanDao {

    private String selectQuery = "select delivery_plan_id, delivery_plan_level_id, delivery_plan_module_id, "
            + " delivery_plan_repeat_students_available, delivery_plan_week_begining_date, delivery_plan_calender_week, "
            + " delivery_plan_class_contact_week, delivery_plan_year, delivery_plan_type, delivery_plan_lecturer_id, "
            + " delivery_plan_lecture_hours, delivery_plan_room_id, delivery_plan_remark from delivery_plan";

    @Override
    public boolean addDeliveryPlan(deliveryPlan plan) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into delivery_plan (delivery_plan_level_id, delivery_plan_module_id,"
                + " delivery_plan_repeat_students_available, delivery_plan_week_begining_date, delivery_plan_calender_week, "
                + "delivery_plan_class_contact_week, delivery_plan_year, delivery_plan_type, delivery_plan_lecturer_id, "
                + "delivery_plan_lecture_hours, delivery_plan_room_id, delivery_plan_remark) values(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, plan.getLevelId());
        ps.setInt(2, plan.getModuleId());
        ps.setBoolean(3, plan.isRepeatStudentsAvailable());
        ps.setDate(4, plan.getWeekBeginingDate());
        ps.setString(5, plan.getCalenderWeek());
        ps.setString(6, plan.getClassContactWeek());
        ps.setInt(7, plan.getYear());
        ps.setString(8, plan.getType());
        ps.setInt(9, plan.getLecturerId());
        ps.setBigDecimal(10, plan.getLectureHours());
        ps.setInt(11, plan.getRoomId());
        ps.setString(12, plan.getRemark());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getDeliveryPlanByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateDeliveryPlan(deliveryPlan plan) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update delivery_plan set delivery_plan_level_id=?, delivery_plan_module_id=?, "
                + "delivery_plan_repeat_students_available=?, delivery_plan_week_begining_date=?, delivery_plan_calender_week=?, "
                + "delivery_plan_class_contact_week=?, delivery_plan_year=?, delivery_plan_type=?, delivery_plan_lecturer_id=?, "
                + "delivery_plan_lecture_hours=?, delivery_plan_room_id=?, delivery_plan_remark=? where delivery_plan_id=?");
        ps.setInt(1, plan.getLevelId());
        ps.setInt(2, plan.getModuleId());
        ps.setBoolean(3, plan.isRepeatStudentsAvailable());
        ps.setDate(4, plan.getWeekBeginingDate());
        ps.setString(5, plan.getCalenderWeek());
        ps.setString(6, plan.getClassContactWeek());
        ps.setInt(7, plan.getYear());
        ps.setString(8, plan.getType());
        ps.setInt(9, plan.getLecturerId());
        ps.setBigDecimal(10, plan.getLectureHours());
        ps.setInt(11, plan.getRoomId());
        ps.setString(12, plan.getRemark());
        ps.setInt(13, plan.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllDeliveryPlanDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getDeliveryPlanByMoreAttributes(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        return new commonDaoImpl().getResultByAttributesWithJoinOperator(selectQuery, attributeConditionValueList, operator);
    }

    @Override
    public boolean deleteDeliveryPlan(int deliveryPlanId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from delivery_plan where delivery_plan_id=?");
        ps.executeUpdate();
        return true;
    }

}
