package br.com.devrodrigues.schoolservice.input.api.exceptions;

import br.com.devrodrigues.schoolservice.core.exceptions.AttendanceNotJustifiableException;
import br.com.devrodrigues.schoolservice.core.exceptions.YouCantRunException;
import br.com.devrodrigues.schoolservice.openapi.model.Error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

@ControllerAdvice
public class ExceptionHandlerImpl {

    @ResponseBody
    @ExceptionHandler(YouCantRunException.class)
    @ResponseStatus(METHOD_NOT_ALLOWED)
    public Error userNotAllowedException(YouCantRunException e) {
        var response = new Error();
        response.setMessage(e.getMessage());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(AttendanceNotJustifiableException.class)
    @ResponseStatus(BAD_REQUEST)
    public Error userNotAllowedException(AttendanceNotJustifiableException e) {
        var response = new Error();
        response.setMessage(e.getMessage());
        return response;
    }
}
