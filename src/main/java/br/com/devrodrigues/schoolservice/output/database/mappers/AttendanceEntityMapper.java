package br.com.devrodrigues.schoolservice.output.database.mappers;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.output.database.models.AttendanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttendanceEntityMapper {

    AttendanceEntityMapper INSTANCE = Mappers.getMapper(AttendanceEntityMapper.class);


    AttendanceEntity fromAttendanceToAttendanceEntity(Attendance it);

    Attendance fromAttendanceEntityToAttendance(AttendanceEntity attendanceEntity);
}
