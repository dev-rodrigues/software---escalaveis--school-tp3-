package br.com.devrodrigues.schoolservice.core;

public class Attendance {

    private final Student student;
    private final String status;

    public Attendance(Student student, String status) {
        this.student = student;
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public String getStatus() {
        return status;
    }
}
