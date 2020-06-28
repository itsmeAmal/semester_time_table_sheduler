/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.roomDaoImpl;
import com.ttms.model.room;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class roomController {

    public static boolean addRoomDetails(String roomCode, String detail, String roomName) throws SQLException {
        room room = new room();
        room.setCode(roomCode);
        room.setDetail(detail);
        room.setName(roomName);
        room.setStatus(room.ACTIVE_ROOM);
        return new roomDaoImpl().addRoom(room);
    }

    public static ResultSet getAllRoomDetails() throws SQLException {
        return new roomDaoImpl().getAllRooms();
    }

    public static ResultSet getRoomByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new roomDaoImpl().getRoomByOneAttribute(attribute, condition, value);
    }

    public static boolean updateRoomDetails(room room) throws SQLException {
        return new roomDaoImpl().updateRoom(room);
    }

    public static room getRoomByRoomId(int roomId) throws SQLException {
        ResultSet rset = getRoomByOneAttribute("room_id", commonConstants.Sql.EQUAL, Integer.toString(roomId));
        room room = null;
        while (rset.next()) {
            room = new room();
            room.setCode(rset.getString("room_code"));
            room.setDetail(rset.getString("room_detail"));
            room.setName(rset.getString("room_name"));
            room.setId(rset.getInt("room_id"));
            room.setStatus(rset.getInt("room_status"));
        }
        return room;
    }

}
