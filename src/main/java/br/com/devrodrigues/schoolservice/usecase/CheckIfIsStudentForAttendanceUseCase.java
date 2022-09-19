package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.ports.StudentPort;
import com.nimbusds.jose.util.Pair;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class CheckIfIsStudentForAttendanceUseCase {

    private final StudentPort port;

    public CheckIfIsStudentForAttendanceUseCase(StudentPort port) {
        this.port = port;
    }

    public Pair<List<Student>, List<Integer>> execute(List<Integer> studends) {

        var localizedStudents = new ArrayList<Student>();
        var notStudents = new ArrayList<Integer>();

        studends.forEach(it -> {
            var result = port.getById(it);

            if (nonNull(result)) {
                localizedStudents.add(result);
            } else {
                notStudents.add(it);
            }
        });

        return Pair.of(
                localizedStudents,
                notStudents
        );
    }
}
