package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.ports.AttendancePort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AttendanceUseCase {

    private final CheckIfIsStudentForAttendanceUseCase checkIfIsStudentForAttendanceUseCase;
    private final AttendancePort attendancePort;

    public AttendanceUseCase(CheckIfIsStudentForAttendanceUseCase checkIfIsStudentForAttendanceUseCase, AttendancePort attendancePort) {
        this.checkIfIsStudentForAttendanceUseCase = checkIfIsStudentForAttendanceUseCase;
        this.attendancePort = attendancePort;
    }

    public String execute(List<Attendance> attendance) {
        var studends = attendance.stream().map(it -> it.getStudent().getId()).collect(Collectors.toList());
        var result = checkIfIsStudentForAttendanceUseCase.execute(studends);

        var attendanceToSave = createAttendance(attendance, result.getLeft());
        var saved = attendancePort.store(attendanceToSave);

        if (!result.getRight().isEmpty()) {
            return  "Presença maracada. Os seguintes estudantes não foram encontrados: "
                    + result.getRight().stream().map(Object::toString).collect(Collectors.joining(", "));
        }

        return "Presença de estudantes registrada com sucesso";
    }

    private List<Attendance> createAttendance(List<Attendance> attendances, List<Student> students) {
        List<Attendance> response = new ArrayList<>();

        for (Attendance attendance : attendances) {
            for (Student studant : students) {
                if (Objects.equals(studant.getId(), attendance.getStudent().getId())) {
                    response.add(
                            new Attendance(
                                    attendance.getId(),
                                    studant,
                                    attendance.getStatus(),
                                    attendance.getDate(),
                                    attendance.getJustify()
                            )
                    );
                }
            }
        }
        return response;
    }
}
