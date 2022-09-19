package br.com.devrodrigues.schoolservice.core.exceptions;

public class AttendanceNotJustifiableException extends RuntimeException {
    public AttendanceNotJustifiableException(String message) {
        super(message);
    }
}
