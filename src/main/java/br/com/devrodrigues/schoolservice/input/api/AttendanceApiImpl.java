package br.com.devrodrigues.schoolservice.input.api;

import br.com.devrodrigues.schoolservice.openapi.api.AttendanceApi;
import br.com.devrodrigues.schoolservice.openapi.model.Attendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateAttendance;
import br.com.devrodrigues.schoolservice.usecase.AttendanceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.devrodrigues.schoolservice.input.api.mappers.AttendanceMapper.INSTANCE;

@RestController
public class AttendanceApiImpl implements AttendanceApi {

    private final AttendanceUseCase useCase;

    public AttendanceApiImpl(AttendanceUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public ResponseEntity<Attendance> storeAttendance(String token, List<CreateAttendance> createAttendance) {
        var attendance = createAttendance
                .stream()
                .map(
                        INSTANCE::fromCreateAttendanceToAttendance).collect(Collectors.toList()
                );

        var result = useCase.execute(attendance);

        var response = new Attendance();
        response.setStatus(result);
        response.setDate(OffsetDateTime.now());

        return ResponseEntity.ok(response);
    }
}
