package br.com.devrodrigues.schoolservice.output.database;

import br.com.devrodrigues.schoolservice.core.Attendance;
import br.com.devrodrigues.schoolservice.output.database.data.AttendanceData;
import br.com.devrodrigues.schoolservice.output.database.mappers.AttendanceEntityMapper;
import br.com.devrodrigues.schoolservice.ports.AttendancePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.devrodrigues.schoolservice.output.database.mappers.AttendanceEntityMapper.INSTANCE;

@Component
public class AttendancePortImpl implements AttendancePort {

    private final AttendanceData data;

    public AttendancePortImpl(AttendanceData data) {
        this.data = data;
    }

    @Override
    public Attendance store(Attendance attendance) {
        var attendanceEntity = INSTANCE.fromAttendanceToAttendanceEntity(attendance);
        var attendanceEntitySaved = data.save(attendanceEntity);
        return INSTANCE.fromAttendanceEntityToAttendance(attendanceEntitySaved);
    }

    @Override
    public List<Attendance> store(List<Attendance> attendanceToSave) {
        var attendanceEntity = attendanceToSave
                .stream()
                .map(INSTANCE::fromAttendanceToAttendanceEntity).collect(Collectors.toList());

        var saveds = data.saveAll(attendanceEntity);

        return saveds
                .stream()
                .map(INSTANCE::fromAttendanceEntityToAttendance).collect(Collectors.toList());
    }

    @Override
    public Attendance getById(Integer attendanceId) {
        return data.findById(attendanceId)
                .map(INSTANCE::fromAttendanceEntityToAttendance)
                .orElseThrow();
    }

    @Override
    public List<Attendance> getAttendanceByStudentId(Integer student) {
        var result = data.findAllByStudentId(student);
        return result
                .stream()
                .map(INSTANCE::fromAttendanceEntityToAttendance).collect(Collectors.toList());
    }
}
