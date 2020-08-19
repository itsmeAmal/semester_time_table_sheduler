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

    private int id;
    private int deliveryPlanId;
    private Date timeTableDate;
    private String timeTableTime;
    private int timeOrderNo;
    private int status;
    private String remark;
    private String day;

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
     * @return the deliveryPlanId
     */
    public int getDeliveryPlanId() {
        return deliveryPlanId;
    }

    /**
     * @param deliveryPlanId the deliveryPlanId to set
     */
    public void setDeliveryPlanId(int deliveryPlanId) {
        this.deliveryPlanId = deliveryPlanId;
    }

    /**
     * @return the timeTableDate
     */
    public Date getTimeTableDate() {
        return timeTableDate;
    }

    /**
     * @param timeTableDate the timeTableDate to set
     */
    public void setTimeTableDate(Date timeTableDate) {
        this.timeTableDate = timeTableDate;
    }

    /**
     * @return the timeTableTime
     */
    public String getTimeTableTime() {
        return timeTableTime;
    }

    /**
     * @param timeTableTime the timeTableTime to set
     */
    public void setTimeTableTime(String timeTableTime) {
        this.timeTableTime = timeTableTime;
    }

    /**
     * @return the timeOrderNo
     */
    public int getTimeOrderNo() {
        return timeOrderNo;
    }

    /**
     * @param timeOrderNo the timeOrderNo to set
     */
    public void setTimeOrderNo(int timeOrderNo) {
        this.timeOrderNo = timeOrderNo;
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

}
