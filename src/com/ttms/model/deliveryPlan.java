/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author personal
 */
public class deliveryPlan {

    private int id;
    private String levelString;
    private int moduleId;
    private boolean repeatStudentsAvailable;
    private Date weekBeginingDate;
    private String calenderWeek;
    private String classContactWeek;
    private int year;
    private String type;
    private int lecturerId;
    private BigDecimal lectureHours;
    private int roomId;
    private String remark;

    @Override
    public String toString() {
        return "deliveryPlan{" + "id=" + id + ", levelId=" + getLevelString() + ", moduleId=" + moduleId
                + ", repeatStudentsAvailable=" + repeatStudentsAvailable + ", weekBeginingDate="
                + weekBeginingDate + ", calenderWeek=" + calenderWeek + ", classContactWeek="
                + classContactWeek + ", year=" + year + ", type=" + type + ", lecturerId="
                + lecturerId + ", lectureHours=" + lectureHours + ", roomId=" + roomId
                + ", remark=" + remark + '}';
    }

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
     * @return the moduleId
     */
    public int getModuleId() {
        return moduleId;
    }

    /**
     * @param moduleId the moduleId to set
     */
    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * @return the repeatStudentsAvailable
     */
    public boolean isRepeatStudentsAvailable() {
        return repeatStudentsAvailable;
    }

    /**
     * @param repeatStudentsAvailable the repeatStudentsAvailable to set
     */
    public void setRepeatStudentsAvailable(boolean repeatStudentsAvailable) {
        this.repeatStudentsAvailable = repeatStudentsAvailable;
    }

    /**
     * @return the weekBeginingDate
     */
    public Date getWeekBeginingDate() {
        return weekBeginingDate;
    }

    /**
     * @param weekBeginingDate the weekBeginingDate to set
     */
    public void setWeekBeginingDate(Date weekBeginingDate) {
        this.weekBeginingDate = weekBeginingDate;
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
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
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
     * @return the lecturerId
     */
    public int getLecturerId() {
        return lecturerId;
    }

    /**
     * @param lecturerId the lecturerId to set
     */
    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    /**
     * @return the lectureHours
     */
    public BigDecimal getLectureHours() {
        return lectureHours;
    }

    /**
     * @param lectureHours the lectureHours to set
     */
    public void setLectureHours(BigDecimal lectureHours) {
        this.lectureHours = lectureHours;
    }

    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
     * @return the levelString
     */
    public String getLevelString() {
        return levelString;
    }

    /**
     * @param levelString the levelString to set
     */
    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }
}
