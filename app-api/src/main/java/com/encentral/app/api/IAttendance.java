package com.encentral.app.api;

import com.encentral.app.model.Attendance;
import com.encentral.app.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IAttendance {
    Attendance addAttendance(Attendance attendance);

    Optional<List<Attendance>> getAttendance(Employee employee);
}
