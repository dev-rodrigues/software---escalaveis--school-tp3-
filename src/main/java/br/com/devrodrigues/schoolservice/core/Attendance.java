package br.com.devrodrigues.schoolservice.core;

import java.util.Date;

public class Attendance {

    private final Integer id;
    private final Student student;
    private final String status;
    private final Date date;
    private Justify justify;

    public Attendance(Integer id, Student student, String status, Date date, Justify justify) {
        this.id = id;
        this.student = student;
        this.status = status;
        this.date = date;
        this.justify = justify;
    }

    public Student getStudent() {
        return student;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public Justify getJustify() {
        return justify;
    }

    public void setJustify(Justify justify) {
        this.justify = justify;
    }
}
