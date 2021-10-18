package com.encentral.app.model;

import java.sql.Date;

public class Employee {
    private int id;
    private String email;
    private String password;
    private String token;
    private Date lastAttendanceDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastAttendanceDate() {
        return lastAttendanceDate;
    }

    public void setLastAttendanceDate(Date lastAttendanceDate) {
        this.lastAttendanceDate = lastAttendanceDate;
    }
}
