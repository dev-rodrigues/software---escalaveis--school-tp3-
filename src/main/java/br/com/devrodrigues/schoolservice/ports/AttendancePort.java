package br.com.devrodrigues.schoolservice.ports;

import br.com.devrodrigues.schoolservice.core.Attendance;

import java.util.List;

public interface AttendancePort {
    List<Attendance> store(List<Attendance> attendanceToSave);
}
