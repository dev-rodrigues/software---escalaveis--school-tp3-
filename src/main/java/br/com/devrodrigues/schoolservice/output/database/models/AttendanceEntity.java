package br.com.devrodrigues.schoolservice.output.database.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "attendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar date;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "justify_id", referencedColumnName = "id")
    private JustifyEntity justify;

    @PrePersist
    private void onCreate() {
        date = Calendar.getInstance();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JustifyEntity getJustify() {
        return justify;
    }

    public void setJustify(JustifyEntity justify) {
        this.justify = justify;
    }
}