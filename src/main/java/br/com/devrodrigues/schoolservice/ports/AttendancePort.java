package br.com.devrodrigues.schoolservice.ports;

import br.com.devrodrigues.schoolservice.core.Attendance;

import java.util.List;

public interface AttendancePort {
    Attendance store(Attendance attendance);
    List<Attendance> store(List<Attendance> attendanceToSave);
    Attendance getById(Integer attendanceId);
    List<Attendance> getAttendanceByStudentId(Integer student);
}
