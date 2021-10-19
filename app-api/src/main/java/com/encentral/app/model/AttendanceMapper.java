package com.encentral.app.model;

import com.encentral.entities.JpaAttendance;

public class AttendanceMapper {
    public static Attendance jpaAttendanceToAttendance(JpaAttendance jpaAttendance) {
        Attendance attendance = new Attendance();
        attendance.setId(jpaAttendance.getId());
        attendance.setDate(jpaAttendance.getDate());
        attendance.setEmployee(EmployeeMapper.jpaEmployeeToEmployee(jpaAttendance.getEmployee()));

        return attendance;
    }

    public static JpaAttendance attendanceToJpaAttendance(Attendance attendance) {
        JpaAttendance jpaAttendance = new JpaAttendance();
        jpaAttendance.setId(attendance.getId());
        jpaAttendance.setDate(attendance.getDate());
        jpaAttendance.setEmployee(EmployeeMapper.employeeToJpaEmployee(attendance.getEmployee()));

        return jpaAttendance;
    }
}
