package br.com.devrodrigues.schoolservice.output.database.mappers;

import br.com.devrodrigues.schoolservice.core.Student;
import br.com.devrodrigues.schoolservice.output.database.models.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentEntityMapper {

    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);

    StudentEntity fromStudentToStudentEntity(Student student);

    Student fromStudentEntityToStudent(StudentEntity studentEntity);
}
