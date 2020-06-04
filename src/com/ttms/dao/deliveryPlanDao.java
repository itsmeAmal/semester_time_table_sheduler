/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.dao;

import com.ttms.model.deliveryPlan;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public interface deliveryPlanDao {

    boolean addDeliveryPlan(deliveryPlan deliveryPlan) throws SQLException;

    ResultSet getAllDeliveryPlans() throws SQLException;

    ResultSet getDeliveryPlanByOneAttribute(String attribute, String condition, String value) throws SQLException;

    boolean updateDeliveryPlan(deliveryPlan deliveryPlan) throws SQLException;

    boolean deleteDeliveryPlan(int deleveryPlanId) throws SQLException;

}
