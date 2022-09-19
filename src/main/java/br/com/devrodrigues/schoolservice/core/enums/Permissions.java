package br.com.devrodrigues.schoolservice.core.enums;

public enum Permissions {
    ROLLS("rolls"),
    REASONS("reasons"),
    REPORTS("reports");

    private final String value;

    Permissions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
