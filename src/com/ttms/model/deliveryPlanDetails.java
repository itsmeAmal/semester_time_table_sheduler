/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.model;

import java.sql.Date;

/**
 *
 * @author personal
 */
public class deliveryPlanDetails {

    //delivery_plan_details_id, delivery_plan_details_delivery_plan_id,
    //delivery_plan_details_date, delivery_plan_details_time, 
    //delivery_plan_details_time_order_no, delivery_plan_details_status, 
    //delivery_plan_details_remark, delivery_plan_details_day,
    //delivery_plan_details_level, delivery_plan_details_module_name, 
    //delivery_plan_details_module_code, delivery_plan_details_type, 
    //delivery_plan_details_lecturer_name, delivery_plan_details_room_name, 
    //delivery_plan_details_course_name, delivery_plan_details_group_name
    private int id;
    private int deliveryPlanid;
    private Date date;
    private String timeString;
    private int timeOrder;
    private int status;
    private String remark;
    private String day;
    private String level;
    private String modueName;
    private String moduleCode;
    private String type;
    private String lecturerName;
    private String roomName;
    private String courseName;
    private String groupName;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the deliveryPlanid
     */
    public int getDeliveryPlanid() {
        return deliveryPlanid;
    }

    /**
     * @param deliveryPlanid the deliveryPlanid to set
     */
    public void setDeliveryPlanid(int deliveryPlanid) {
        this.deliveryPlanid = deliveryPlanid;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the timeString
     */
    public String getTimeString() {
        return timeString;
    }

    /**
     * @param timeString the timeString to set
     */
    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    /**
     * @return the timeOrder
     */
    public int getTimeOrder() {
        return timeOrder;
    }

    /**
     * @param timeOrder the timeOrder to set
     */
    public void setTimeOrder(int timeOrder) {
        this.timeOrder = timeOrder;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the modueName
     */
    public String getModueName() {
        return modueName;
    }

    /**
     * @param modueName the modueName to set
     */
    public void setModueName(String modueName) {
        this.modueName = modueName;
    }

    /**
     * @return the moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode the moduleCode to set
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the lecturerName
     */
    public String getLecturerName() {
        return lecturerName;
    }

    /**
     * @param lecturerName the lecturerName to set
     */
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    

}
