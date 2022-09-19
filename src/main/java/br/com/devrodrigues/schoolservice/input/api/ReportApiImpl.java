package br.com.devrodrigues.schoolservice.input.api;

import br.com.devrodrigues.schoolservice.openapi.api.ReportApi;
import br.com.devrodrigues.schoolservice.openapi.model.Attendance;
import br.com.devrodrigues.schoolservice.openapi.model.CreateAttendance;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReportApiImpl implements ReportApi {

    public ResponseEntity<Attendance> storeAttendance(String token, @ApiParam(value = "" ,required=true )  @Valid @RequestBody List<CreateAttendance> createAttendance) {
        return null;
    }
}
