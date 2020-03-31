package com.seriouscompanyname.serverhospital.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Student extends Person {

    private String address;
    private LocalDate birthDate;
    private LocalDate illnessDate;
}
