package br.com.devrodrigues.schoolservice.input.api;

import br.com.devrodrigues.schoolservice.openapi.api.StudentApi;
import br.com.devrodrigues.schoolservice.openapi.model.CreateStudenty;
import br.com.devrodrigues.schoolservice.openapi.model.Student;
import br.com.devrodrigues.schoolservice.usecase.CreateStudentUseCase;
import br.com.devrodrigues.schoolservice.usecase.ShouldGetStudents;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.devrodrigues.schoolservice.input.api.mappers.StudentMapper.INSTANCE;

@RestController
public class StudentApiImpl implements StudentApi {

    private final CreateStudentUseCase createStudentUseCase;
    private final ShouldGetStudents listStudentsUseCase;

    public StudentApiImpl(CreateStudentUseCase createStudentUseCase, ShouldGetStudents listStudentsUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.listStudentsUseCase = listStudentsUseCase;
    }

    @Override
    public ResponseEntity<List<Student>> listAll(String token, String function) {
        var result = listStudentsUseCase.getAll();
        var response  = result.stream().map(INSTANCE::fromStudentToStudent).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Student> store(CreateStudenty createStudenty) {
        var student = INSTANCE.fromCreateStudentyToStudent(createStudenty);
        var createdUser = createStudentUseCase.execute(student);

        var response = new Student();
        response.setId(createdUser.getId());
        response.setName(createdUser.getName());
        return ResponseEntity.ok(response);
    }
}
