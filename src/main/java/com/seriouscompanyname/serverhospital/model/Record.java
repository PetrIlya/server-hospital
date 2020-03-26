package com.seriouscompanyname.serverhospital.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private RecordPack pack;
    @OneToOne
    private Student student;
    @OneToOne
    private Doctor doctor;
}
