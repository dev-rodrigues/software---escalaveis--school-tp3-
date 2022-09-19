package br.com.devrodrigues.schoolservice.input.api.mappers;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.openapi.model.CreateStudenty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "id", ignore = true)
    Student fromCreateStudentyToStudent(CreateStudenty student);

    br.com.devrodrigues.schoolservice.openapi.model.Student fromStudentToStudent(Student student);
}
