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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class deliveryPlanDetailDaoImpl implements deliveryPlanDetailsDao {

    private String selectQuery = "select delivery_plan_details_id, delivery_plan_details_delivery_plan_id,"
            + " delivery_plan_details_date, delivery_plan_details_time, delivery_plan_details_time_order_no,"
            + " delivery_plan_details_status, delivery_plan_details_remark, delivery_plan_details_day"
            + " from delivery_plan_details";

    @Override
    public boolean addDeliveryPlanId(deliveryPlanDetails planDetails) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into delivery_plan_details (delivery_plan_details_delivery_plan_id,"
                + " delivery_plan_details_date, delivery_plan_details_time, delivery_plan_details_time_order_no,"
                + " delivery_plan_details_status, delivery_plan_details_remark, delivery_plan_details_day) values (?,?,?,?,?,?,?)");
        ps.setInt(1, planDetails.getDeliveryPlanId());
        ps.setDate(2, planDetails.getTimeTableDate());
        ps.setString(3, planDetails.getTimeTableTime());
        ps.setInt(4, planDetails.getTimeOrderNo());
        ps.setInt(5, planDetails.getStatus());
        ps.setString(6, planDetails.getRemark());
        ps.setString(7, planDetails.getDay());
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
        ps.setInt(1, planDetails.getDeliveryPlanId());
        ps.setDate(2, planDetails.getTimeTableDate());
        ps.setString(3, planDetails.getTimeTableTime());
        ps.setInt(4, planDetails.getTimeOrderNo());
        ps.setInt(5, planDetails.getStatus());
        ps.setString(6, planDetails.getRemark());
        ps.setString(7, planDetails.getDay());
        ps.setInt(8, planDetails.getId());
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

    @Override
    public ResultSet getDeliveryPlanDetailsByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public ResultSet getDeliveryPlanDetailsByMoreAttributes(ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {
        return new commonDaoImpl().getResultByAttributesWithJoinOperator(selectQuery, attributeConditionValueList, operator);
    }

}
