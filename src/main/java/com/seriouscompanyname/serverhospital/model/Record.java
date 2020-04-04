package com.seriouscompanyname.serverhospital.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private RecordPack pack;
    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "record")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;
    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "record")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Doctor doctor;

    public void setStudent(Student student) {
        this.student = student;
        student.setRecord(this);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        doctor.setRecord(this);
    }
}
