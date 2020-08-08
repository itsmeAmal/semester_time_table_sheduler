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
    public int addDeliveryPlan(deliveryPlan plan) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into delivery_plan (delivery_plan_id, delivery_plan_level_str, delivery_plan_module_id,"
                + " delivery_plan_repeat_students_available, delivery_plan_week_begining_date, delivery_plan_calender_week, "
                + "delivery_plan_class_contact_week, delivery_plan_year, delivery_plan_type, delivery_plan_lecturer_id, "
                + "delivery_plan_lecture_hours, delivery_plan_room_id, delivery_plan_remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        int nextId = getNextDeliveryPlanId();
        ps.setInt(1, nextId);
        ps.setString(2, plan.getLevelString());
        ps.setInt(3, plan.getModuleId());
        ps.setBoolean(4, plan.isRepeatStudentsAvailable());
        ps.setDate(5, plan.getWeekBeginingDate());
        ps.setString(6, plan.getCalenderWeek());
        ps.setString(7, plan.getClassContactWeek());
        ps.setInt(8, plan.getYear());
        ps.setString(9, plan.getType());
        ps.setInt(10, plan.getLecturerId());
        ps.setBigDecimal(11, plan.getLectureHours());
        ps.setInt(12, plan.getRoomId());
        ps.setString(13, plan.getRemark());
        ps.executeUpdate();
        ps.close();
        return nextId;
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
        ps.setString(1, plan.getLevelString());
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

    @Override
    public int getNextDeliveryPlanId() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select max(delivery_plan_id) from delivery_plan");
        ResultSet rset = ps.executeQuery();
        int maxId = 0;
        while (rset.next()) {
            maxId = rset.getInt(1);
        }
        return ++maxId;
    }

    public ResultSet getAllDeliveryPlansWithJoinTables() throws SQLException {
        return new commonDaoImpl().getAllRecords("SELECT delivery_plan_id, delivery_plan_level_str, "
                + " delivery_plan_module_id, delivery_plan_repeat_students_available, "
                + " delivery_plan_week_begining_date, delivery_plan_calender_week, "
                + " delivery_plan_class_contact_week, delivery_plan_year, delivery_plan_type, "
                + " delivery_plan_lecturer_id, delivery_plan_lecture_hours, delivery_plan_room_id, "
                + " delivery_plan_remark, lecturer_name, room_name FROM delivery_plan left join lecturer "
                + " on delivery_plan_lecturer_id=lecturer_id left join room on delivery_plan_room_id=room_id");
    }

}
