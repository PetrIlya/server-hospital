package com.seriouscompanyname.serverhospital.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Student extends Person {

    @OneToOne
    private Record record;

    private String address;
    private LocalDate birthDate;
    private LocalDate illnessDate;
}
