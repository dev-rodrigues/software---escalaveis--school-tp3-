package br.com.devrodrigues.schoolservice.core.exceptions;

public class YouCantRunException extends RuntimeException {
    public YouCantRunException(String message) {
        super(message);
    }
}