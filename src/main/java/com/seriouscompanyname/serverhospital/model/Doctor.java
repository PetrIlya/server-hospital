package com.seriouscompanyname.serverhospital.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Doctor extends Person {

    @OneToOne
    private Record record;
    private String illnessAnalyse;
}
