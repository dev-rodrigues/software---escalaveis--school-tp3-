package br.com.devrodrigues.schoolservice.input.api;

import br.com.devrodrigues.schoolservice.openapi.api.AttendanceApi;
import br.com.devrodrigues.schoolservice.openapi.model.Attendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateAttendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateStudenty;
import br.com.devrodrigues.schoolservice.openapi.model.Justify;
import br.com.devrodrigues.schoolservice.usecase.AttendanceUseCase;
import br.com.devrodrigues.schoolservice.usecase.MustProvideJustificationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

import static br.com.devrodrigues.schoolservice.input.api.mappers.AttendanceMapper.INSTANCE;
import static java.util.stream.Collectors.toList;

@RestController
public class AttendanceApiImpl implements AttendanceApi {

    private final AttendanceUseCase attendanceUseCase;
    private final MustProvideJustificationUseCase mustProvideJustificationUseCase;

    public AttendanceApiImpl(AttendanceUseCase useCase, MustProvideJustificationUseCase mustProvideJustificationUseCase) {
        this.attendanceUseCase = useCase;
        this.mustProvideJustificationUseCase = mustProvideJustificationUseCase;
    }

    @Override
    public ResponseEntity<Attendance> storeAttendance(
            String token,
            String function,
            List<CreateAttendance> createAttendance) {
        var attendance = createAttendance
                .stream()
                .map(INSTANCE::fromCreateAttendanceToAttendance).collect(toList());

        var result = attendanceUseCase.execute(attendance);

        var response = new Attendance();
        response.setStatus(result);
        response.setDate(OffsetDateTime.now());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Justify> attendanceJustifyAttendanceIdPost(String token,
                                                                     String function,
                                                                     Integer attendanceId,
                                                                     CreateStudenty createStudenty) {
        var result = mustProvideJustificationUseCase.execute(attendanceId, createStudenty.getName());
        var response = new Justify();
        response.setId(result.getJustify().getId());
        response.setAttendance(result.getId());
        response.setMessage(result.getJustify().getMessage());
        return ResponseEntity.ok(response);
    }
}
