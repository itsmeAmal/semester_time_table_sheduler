/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.deliveryPlanDetailDaoImpl;
import com.ttms.model.deliveryPlanDetails;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class deliveryPlanDetailsController {

    public static ResultSet getAllDeliveryPlanDetails() throws SQLException {
        return new deliveryPlanDetailDaoImpl().getAllDeliveryPlanDetails();
    }

    public static ResultSet getAllOrderedDeliveryPlanDetails() throws SQLException {
        return new deliveryPlanDetailDaoImpl().getAllOrderedDeliveryPlanDetails();
    }

    public static ResultSet getDeliveryPlanDetailByOneAttribute(String attribute,
            String condition, String value) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getDeliveryPlanDetailsByOneAttribute(attribute, condition, value);
    }

    public static ResultSet getDeliveryPlanDetailsByMoreAttributes(ArrayList<String[]> attributeConditionValueList,
            String operator) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getDeliveryPlanDetailsByMoreAttributes(
                attributeConditionValueList, operator);
    }

    public static boolean addDeliveryPlanDetailRecord(String day, int deliveryPlanId,
            String remark, int timeOrderNo, Date timeTableDate, String time) throws SQLException {
        deliveryPlanDetails planDetails = new deliveryPlanDetails();
        planDetails.setDay(day);
        planDetails.setDeliveryPlanId(deliveryPlanId);
        planDetails.setRemark(remark);
        planDetails.setTimeOrderNo(timeOrderNo);
        planDetails.setTimeTableDate(timeTableDate);
        planDetails.setTimeTableTime(time);
        return new deliveryPlanDetailDaoImpl().addDeliveryPlanDetailRecord(planDetails);
    }

    public static int getNextTimeOrderNo(Date date) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getNextTimeOrderNo(date);
    }

}
