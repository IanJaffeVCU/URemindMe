package com.example.version3_355app.ui.to_do;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoModel {
    private String Assignment;
    private Date date;
    private Time time;
    private String course;

    public Date date(int m, int d, int y) {

        String M = String.valueOf(m);
        String D = String.valueOf(d);
        String Y = String.valueOf(y);
        String df = M.concat("/").concat(D).concat("/").concat(Y);
        Date dfinal = null;
        try {
            dfinal = new SimpleDateFormat("dd/MM/yyyy").parse(df);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dfinal;

    }

    public TodoModel(String Assignment, int month, int day, int year, Time time, String course) {
        this.Assignment = Assignment;
        Date d = date(month, day, year);
        this.time = time;
        this.course = course;

    }

    @Override
    public String toString() {
        return "TodoModel{" +
                "Assignment='" + Assignment + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", course='" + course + '\'' +
                '}';
    }

    public String getAssignment() {
        return Assignment;
    }

    public void setAssignment(String assignment) {
        Assignment = assignment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}


