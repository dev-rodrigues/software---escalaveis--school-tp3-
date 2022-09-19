package br.com.devrodrigues.schoolservice.ports;

import br.com.devrodrigues.schoolservice.core.Student;

import java.util.List;

public interface StudentPort {
    Student create(Student student);

    List<Student> list();

    Student getById(Integer it);
}
