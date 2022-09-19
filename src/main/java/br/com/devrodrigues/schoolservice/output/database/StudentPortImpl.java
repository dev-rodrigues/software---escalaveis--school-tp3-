package br.com.devrodrigues.schoolservice.output.database;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.output.database.data.StudentData;
import br.com.devrodrigues.schoolservice.ports.StudentPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.devrodrigues.schoolservice.output.database.mappers.StudentEntityMapper.INSTANCE;

@Component
public class StudentPortImpl implements StudentPort {

    private final StudentData data;

    public StudentPortImpl(StudentData data) {
        this.data = data;
    }

    @Override
    public Student create(Student student) {
        var studentEntity = INSTANCE.fromStudentToStudentEntity(student);
        var studentSaved = data.save(studentEntity);
        return INSTANCE.fromStudentEntityToStudent(studentSaved);
    }

    @Override
    public List<Student> list() {
        return data.findAll().stream().map(INSTANCE::fromStudentEntityToStudent).collect(Collectors.toList());
    }

    @Override
    public Student getById(Integer id) {
        return data.findById(id).map(INSTANCE::fromStudentEntityToStudent).orElse(null);
    }
}