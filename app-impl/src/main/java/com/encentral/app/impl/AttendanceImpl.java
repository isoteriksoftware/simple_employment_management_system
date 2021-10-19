package com.encentral.app.impl;

import com.encentral.app.api.IAttendance;
import com.encentral.app.model.Attendance;
import com.encentral.app.model.AttendanceMapper;
import com.encentral.app.model.Employee;
import com.encentral.entities.JpaAttendance;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class AttendanceImpl implements IAttendance {
    private final JPAApi jpaApi;

    @Inject
    public AttendanceImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Attendance addAttendance(Attendance attendance) {
        JpaAttendance jpaAttendance = AttendanceMapper.attendanceToJpaAttendance(attendance);
        jpaApi.em().persist(jpaAttendance);

        return AttendanceMapper.jpaAttendanceToAttendance(jpaAttendance);
    }

    @Override
    public Optional<List<Attendance>> getAttendance(Employee employee) {
        try {
            List<JpaAttendance> jpaAttendance = jpaApi.withTransaction(em ->
                    em.createQuery("Select a From JpaAttendance a where a.employee_id = :employeeId", JpaAttendance.class)
                            .setParameter("employeeId", employee.getId())
                            .getResultList());
            return Optional.ofNullable(jpaAttendance).map(AttendanceMapper::jpaAttendancesToAttendances);
        } catch (Exception ignored) {}

        return Optional.empty();
    }
}
