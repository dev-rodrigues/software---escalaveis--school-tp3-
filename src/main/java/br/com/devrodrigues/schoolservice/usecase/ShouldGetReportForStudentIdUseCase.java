package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.ports.AttendancePort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShouldGetReportForStudentIdUseCase {

    private final AttendancePort port;

    public ShouldGetReportForStudentIdUseCase(AttendancePort port) {
        this.port = port;
    }

    public List<Attendance> execute(Integer student) {
        return port.getAttendanceByStudentId(student);
    }
}
