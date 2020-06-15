/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.batchDaoImpl;
import com.ttms.model.batch;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class batchController {

    public static ResultSet getAllBatches() throws SQLException {
        return new batchDaoImpl().getAllBatches();
    }

    public static ResultSet getBatchByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new batchDaoImpl().getBatchByOneAttribute(attribute, condition, value);
    }

    public static boolean addBatch(String year, String level, String detail) throws SQLException {
        batch batch = new batch();
        batch.setYear(year);
        batch.setLevel(level);
        batch.setDetail(detail);
        batch.setStatus(batch.ACTIVE_BATCH);
        return new batchDaoImpl().addBatch(batch);
    }

}
