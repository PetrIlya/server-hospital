package com.seriouscompanyname.serverhospital.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Doctor extends Person {

    private String illnessAnalyse;
}
