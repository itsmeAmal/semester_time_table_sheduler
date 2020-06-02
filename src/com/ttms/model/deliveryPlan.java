/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.model;

import java.sql.Date;

/**
 *
 * @author Amal
 */
public class deliveryPlan {
    
    private int id;
    private String calenderWeek;
    private String classContactWeek;
    private Date weekBegining;
    private String lecture3Hours;
    private String tutorial2Hours;
    private String lab2HoursCl03;
    private String remarks;
    private String detail;
    private int status;

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
     * @return the calenderWeek
     */
    public String getCalenderWeek() {
        return calenderWeek;
    }

    /**
     * @param calenderWeek the calenderWeek to set
     */
    public void setCalenderWeek(String calenderWeek) {
        this.calenderWeek = calenderWeek;
    }

    /**
     * @return the classContactWeek
     */
    public String getClassContactWeek() {
        return classContactWeek;
    }

    /**
     * @param classContactWeek the classContactWeek to set
     */
    public void setClassContactWeek(String classContactWeek) {
        this.classContactWeek = classContactWeek;
    }

    /**
     * @return the weekBegining
     */
    public Date getWeekBegining() {
        return weekBegining;
    }

    /**
     * @param weekBegining the weekBegining to set
     */
    public void setWeekBegining(Date weekBegining) {
        this.weekBegining = weekBegining;
    }

    /**
     * @return the lecture3Hours
     */
    public String getLecture3Hours() {
        return lecture3Hours;
    }

    /**
     * @param lecture3Hours the lecture3Hours to set
     */
    public void setLecture3Hours(String lecture3Hours) {
        this.lecture3Hours = lecture3Hours;
    }

    /**
     * @return the tutorial2Hours
     */
    public String getTutorial2Hours() {
        return tutorial2Hours;
    }

    /**
     * @param tutorial2Hours the tutorial2Hours to set
     */
    public void setTutorial2Hours(String tutorial2Hours) {
        this.tutorial2Hours = tutorial2Hours;
    }

    /**
     * @return the lab2HoursCl03
     */
    public String getLab2HoursCl03() {
        return lab2HoursCl03;
    }

    /**
     * @param lab2HoursCl03 the lab2HoursCl03 to set
     */
    public void setLab2HoursCl03(String lab2HoursCl03) {
        this.lab2HoursCl03 = lab2HoursCl03;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
    
}
