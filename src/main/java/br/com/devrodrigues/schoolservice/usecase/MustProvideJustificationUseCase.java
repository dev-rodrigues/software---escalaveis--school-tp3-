package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.core.Justify;
import br.com.devrodrigues.schoolservice.core.exceptions.AttendanceNotJustifiableException;
import br.com.devrodrigues.schoolservice.ports.AttendancePort;
import org.springframework.stereotype.Component;

@Component
public class MustProvideJustificationUseCase {

    private final AttendancePort attendancePort;

    public MustProvideJustificationUseCase(AttendancePort attendancePort) {
        this.attendancePort = attendancePort;
    }

    public Attendance execute(Integer attendanceId, String name) {
        var attendance = attendancePort.getById(attendanceId);

        if (attendance.getStatus().equalsIgnoreCase("present")) {
            throw new AttendanceNotJustifiableException("You can't justify a present student");
        }

        attendance.setJustify(
                new Justify(null, name)
        );

        return attendancePort.store(attendance);
    }
}
