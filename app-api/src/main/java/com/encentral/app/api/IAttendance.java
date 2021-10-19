package com.encentral.app.api;

import com.encentral.app.model.Attendance;
import com.encentral.app.model.Employee;

import java.util.Optional;

public interface IAttendance {
    Attendance addAttendance(Attendance attendance);

    Optional<Attendance> getAttendance(Employee employee);
}
