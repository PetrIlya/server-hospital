package com.seriouscompanyname.serverhospital.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Doctor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String illnessAnalyse;
}
