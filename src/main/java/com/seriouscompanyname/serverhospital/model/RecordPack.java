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

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "pack")
    private List<Record> records;

    public void addRecord(Record record) {
        this.records.add(record);
        record.setPack(this);
    }
}
