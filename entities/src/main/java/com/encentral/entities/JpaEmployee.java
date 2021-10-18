package com.encentral.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "employee")
@Entity
public class JpaEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "last_attendance_date", nullable = true)
    private Date lastAttendanceDate;

    public Date getLastAttendanceDate() {
        return lastAttendanceDate;
    }

    public void setLastAttendanceDate(Date lastAttendanceDate) {
        this.lastAttendanceDate = lastAttendanceDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}