package br.com.devrodrigues.schoolservice.usecase;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.ports.StudentPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShouldGetStudents {

    private final StudentPort port;

    public ShouldGetStudents(StudentPort port) {
        this.port = port;
    }

    public List<Student> getAll() {
        return port.list();
    }
}
