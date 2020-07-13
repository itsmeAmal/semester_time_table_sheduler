/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.lecturerAvailabilityDaoImpl;
import com.ttms.model.lecturerAvailability;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class lecturerUnavailabilityController {

    public static boolean addLecturerUnavailability(int lecturerId, Date unavailableDate,
            String unavailableTimeFrom, String unavailableTimeTo, String detail) throws SQLException {
        lecturerAvailability availability = new lecturerAvailability();
        availability.setLecturerId(lecturerId);
        availability.setUnavailableDate(unavailableDate);
        availability.setUnavailableTimeFrom(unavailableTimeFrom);
        availability.setUnavailableTimeTo(unavailableTimeTo);
        availability.setDetail(detail);
        availability.setStatus(lecturerAvailability.ACTIVE_AVAILABILITY_RECORD);
        return new lecturerAvailabilityDaoImpl().addLecturerAvailability(availability);
    }

    public static ResultSet getAllLecturerAvailableRecord() throws SQLException {
        return new lecturerAvailabilityDaoImpl().getAllUnavailableLecturerRecords();
    }

    public static ResultSet getLecturerAvailability(String attribute, String condition, String value)
            throws SQLException {
        return new lecturerAvailabilityDaoImpl().getAvailableLectureByOneAttribute(attribute, condition, value);
    }

    public static lecturerAvailability getLecturerUnavailabilityByLecturerUnavailabilityId(int unavailabilityId)
            throws SQLException {
        ResultSet rset = getLecturerAvailability("lecturer_availablity_id", commonConstants.Sql.EQUAL, Integer.toString(unavailabilityId));
        lecturerAvailability availability = null;
        while (rset.next()) {
            availability = new lecturerAvailability();
            availability.setDetail(rset.getString("lecturer_availablity_detail"));
            availability.setStatus(rset.getInt("lecturer_availablity_status"));
            availability.setUnavailableDate(rset.getDate("lecturer_availablity_unavailable_date"));
            availability.setUnavailableTimeFrom(rset.getString("lecturer_availablity_unavailable_time_from"));
            availability.setUnavailableTimeTo(rset.getString("lecturer_availablity_unavailable_time_to"));
            availability.setId(rset.getInt("lecturer_availablity_id"));
            availability.setLecturerId(rset.getInt("lecturer_availablity_lec_id"));
        }
        return availability;
    }

    public static boolean updateLecturerUnavailability(lecturerAvailability availability) throws SQLException {
        return new lecturerAvailabilityDaoImpl().updateAvailableLecture(availability);
    }

    public static ResultSet getLecUnavaDetailsWithJoinQuery() throws SQLException {
        return new lecturerAvailabilityDaoImpl().getLecUnavaDetailsWithJoinQuery();
    }

    public static ResultSet getAvailableLectureByOneAttributeWithJoinQuery(String attribute, String condition, String value) throws SQLException {
        return new lecturerAvailabilityDaoImpl().getAvailableLectureByOneAttributeWithJoinQuery(attribute, condition, value);
    }

}
