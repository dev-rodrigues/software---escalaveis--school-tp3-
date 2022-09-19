package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.ports.StudentPort;
import org.springframework.stereotype.Component;

@Component
public class CreateStudentUseCase {

    private final StudentPort studentPort;

    public CreateStudentUseCase(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    public Student execute(Student student) {
        return studentPort.create(student);
    }
}
