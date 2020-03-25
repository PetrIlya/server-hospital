package com.seriouscompanyname.serverhospital.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RecordPack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    private List<Record> records;
}
