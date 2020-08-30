/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.deliveryPlanDetailsDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.deliveryPlanDetails;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class deliveryPlanDetailDaoImpl implements deliveryPlanDetailsDao {

    private String selectQuery = "select delivery_plan_details_id, delivery_plan_details_delivery_plan_id, "
            + "delivery_plan_details_date, delivery_plan_details_time, delivery_plan_details_time_order_no, "
            + "delivery_plan_details_status, delivery_plan_details_remark, delivery_plan_details_day, "
            + "delivery_plan_details_level, delivery_plan_details_module_name, delivery_plan_details_module_code, "
            + "delivery_plan_details_type, delivery_plan_details_lecturer_name, delivery_plan_details_room_name, "
            + "delivery_plan_details_course_name, delivery_plan_details_group_name delivery_plan_details";

    private String selectQuery2 = "select delivery_plan_details_id, delivery_plan_details_delivery_plan_id, "
            + "delivery_plan_details_date, delivery_plan_details_time, delivery_plan_details_time_order_no, "
            + "delivery_plan_details_status, delivery_plan_details_remark, delivery_plan_details_day, "
            + "delivery_plan_details_level, delivery_plan_details_module_name, delivery_plan_details_module_code, "
            + "delivery_plan_details_type, delivery_plan_details_lecturer_name, delivery_plan_details_room_name, "
            + "delivery_plan_details_course_name, delivery_plan_details_group_name from "
            + "delivery_plan_details order by delivery_plan_details_date, delivery_plan_details_time_order_no";

    @Override
    public boolean addDeliveryPlanDetailRecord(deliveryPlanDetails planDetails) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into delivery_plan_details ("
                + "delivery_plan_details_delivery_plan_id, delivery_plan_details_date, delivery_plan_details_time, "
                + "delivery_plan_details_time_order_no, delivery_plan_details_status, delivery_plan_details_remark, "
                + "delivery_plan_details_day, delivery_plan_details_level, delivery_plan_details_module_name, "
                + "delivery_plan_details_module_code, delivery_plan_details_type, delivery_plan_details_lecturer_name, "
                + "delivery_plan_details_room_name, delivery_plan_details_course_name, delivery_plan_details_group_name) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
 
        
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateDeliveryPlanDetails(deliveryPlanDetails planDetails) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update delivery_plan_details set delivery_plan_details_delivery_plan_id=?, "
                + "delivery_plan_details_date=?, delivery_plan_details_time=?, delivery_plan_details_time_order_no=?, "
                + "delivery_plan_details_status=?, delivery_plan_details_remark=?, delivery_plan_details_day=? where delivery_plan_details_id=?");
    
        
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteDeliveryPlanDetails(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllDeliveryPlanDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    public ResultSet getAllOrderedDeliveryPlanDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery2);
    }

    @Override
    public ResultSet getDeliveryPlanDetailsByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public ResultSet getDeliveryPlanDetailsByMoreAttributes(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        return new commonDaoImpl().getResultByAttributesWithJoinOperator(selectQuery, attributeConditionValueList, operator);
    }

    public int getNextTimeOrderNo(Date date) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(delivery_plan_details_id) as "
                + "date_count from delivery_plan_details where delivery_plan_details_date=?");
        ResultSet rset = ps.executeQuery();
        int count = 0;
        while (rset.next()) {
            count = rset.getInt("date_count");
        }
        return ++count;
    }

}
