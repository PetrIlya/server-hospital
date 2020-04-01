package com.seriouscompanyname.serverhospital.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class DoctorDTO extends PersonDTO {
    private String illnessAnalyse;
}
