package com.seriouscompanyname.serverhospital.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private RecordPack pack;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "record")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "record")
    private Doctor doctor;
}
