package br.com.devrodrigues.schoolservice.input.api.mappers;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateAttendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    @Mapping(source = "student", target = "student.id")
    @Mapping(source = "status", target = "status")
    Attendance fromCreateAttendanceToAttendance(CreateAttendance createAttendance);
}
