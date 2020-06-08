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
    private String lectureHours;
    private String tutorialHours;
    private String labHours;
    private String remarks;
    private String detail;
    private int status;
    private String location;
    private String lecturName;
    private String tutorialName;
    private String labName;

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
     * @return the lectureHours
     */
    public String getLectureHours() {
        return lectureHours;
    }

    /**
     * @param lectureHours the lectureHours to set
     */
    public void setLectureHours(String lectureHours) {
        this.lectureHours = lectureHours;
    }

    /**
     * @return the tutorialHours
     */
    public String getTutorialHours() {
        return tutorialHours;
    }

    /**
     * @param tutorialHours the tutorialHours to set
     */
    public void setTutorialHours(String tutorialHours) {
        this.tutorialHours = tutorialHours;
    }

    /**
     * @return the labHours
     */
    public String getLabHours() {
        return labHours;
    }

    /**
     * @param labHours the labHours to set
     */
    public void setLabHours(String labHours) {
        this.labHours = labHours;
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

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the lecturName
     */
    public String getLecturName() {
        return lecturName;
    }

    /**
     * @param lecturName the lecturName to set
     */
    public void setLecturName(String lecturName) {
        this.lecturName = lecturName;
    }

    /**
     * @return the tutorialName
     */
    public String getTutorialName() {
        return tutorialName;
    }

    /**
     * @param tutorialName the tutorialName to set
     */
    public void setTutorialName(String tutorialName) {
        this.tutorialName = tutorialName;
    }

    /**
     * @return the labName
     */
    public String getLabName() {
        return labName;
    }

    /**
     * @param labName the labName to set
     */
    public void setLabName(String labName) {
        this.labName = labName;
    }

}

