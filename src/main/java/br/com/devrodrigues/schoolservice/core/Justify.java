package br.com.devrodrigues.schoolservice.core;

public class Justify {

    private final Integer id;

    private final String message;

    public Justify(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
