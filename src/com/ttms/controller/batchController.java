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

    public static boolean updateAsDeleted(int batchId) throws SQLException {
        return new batchDaoImpl().updateBatchAsDeleted(batchId);
    }

    public static boolean updateBatch(batch batch) throws SQLException {
        return new batchDaoImpl().updateBatch(batch);
    }

    public static batch getBatchModelByBatchId(int batchId) throws SQLException {
        ResultSet rset = batchController.getBatchByOneAttribute("batch_id", commonConstants.Sql.EQUAL, Integer.toString(batchId));
        batch batch = null;
        while (rset.next()) {
            batch = new batch();
            batch.setDetail(rset.getString("batch_detail"));
            batch.setId(rset.getInt("batch_id"));
            batch.setLevel(rset.getString("batch_level"));
            batch.setYear(rset.getString("batch_year"));
            batch.setStatus(rset.getInt("batch_status"));
        }
        return batch;
    }

}
