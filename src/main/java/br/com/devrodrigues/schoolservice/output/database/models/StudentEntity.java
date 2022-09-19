package br.com.devrodrigues.schoolservice.output.database.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AttendanceEntity> attendanceEntities;
    public StudentEntity() {
        //no-sonar
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttendanceEntity> getAttendanceEntities() {
        return attendanceEntities;
    }

    public void setAttendanceEntities(List<AttendanceEntity> attendanceEntities) {
        this.attendanceEntities = attendanceEntities;
    }
}