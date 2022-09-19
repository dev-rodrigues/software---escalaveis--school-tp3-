package br.com.devrodrigues.schoolservice.output.database;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.output.database.data.AttendanceData;
import br.com.devrodrigues.schoolservice.output.database.mappers.AttendanceEntityMapper;
import br.com.devrodrigues.schoolservice.ports.AttendancePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendancePortImpl implements AttendancePort {

    private final AttendanceData data;

    public AttendancePortImpl(AttendanceData data) {
        this.data = data;
    }

    @Override
    public List<Attendance> store(List<Attendance> attendanceToSave) {
        var attendanceEntity = attendanceToSave
                .stream()
                .map(AttendanceEntityMapper.INSTANCE::fromAttendanceToAttendanceEntity).collect(Collectors.toList());

        var saveds = data.saveAll(attendanceEntity);

        return saveds
                .stream()
                .map(AttendanceEntityMapper.INSTANCE::fromAttendanceEntityToAttendance).collect(Collectors.toList());
    }
}
