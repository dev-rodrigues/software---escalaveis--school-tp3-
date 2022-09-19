package br.com.devrodrigues.schoolservice.input.api;

import br.com.devrodrigues.schoolservice.openapi.api.ReportApi;
import br.com.devrodrigues.schoolservice.openapi.model.Attendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateStudenty;
import br.com.devrodrigues.schoolservice.openapi.model.Justify;
import br.com.devrodrigues.schoolservice.usecase.ShouldGetReportForStudentIdUseCase;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

@RestController
public class ReportApiImpl implements ReportApi {

    private final ShouldGetReportForStudentIdUseCase shouldGetReportForStudentIdUseCase;

    public ReportApiImpl(ShouldGetReportForStudentIdUseCase shouldGetReportForStudantIdUseCase) {
        this.shouldGetReportForStudentIdUseCase = shouldGetReportForStudantIdUseCase;
    }

    @Override
    public ResponseEntity<List<Attendance>> reportAttendanceGet(String token, String function, Integer student) {
        var result = shouldGetReportForStudentIdUseCase.execute(student);
        var response = result.stream().map(it -> {
            var attendance = new Attendance();
            attendance.setId(it.getId());
            attendance.setDate(it.getDate().toInstant().atOffset(UTC));
            attendance.setStatus(it.getStatus());
            return attendance;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }


}