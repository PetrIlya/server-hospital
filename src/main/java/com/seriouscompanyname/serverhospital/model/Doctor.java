package com.seriouscompanyname.serverhospital.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Doctor extends Person {
    @NonNull private String illnessAnalyse;

    public Doctor(@NonNull String illnessAnalyse, Person person) {
        super(person);
        this.illnessAnalyse = illnessAnalyse;
    }
}
