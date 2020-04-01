package com.seriouscompanyname.serverhospital.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class StudentDTO extends PersonDTO {
    private String address;
    private LocalDate birthDate;
    private LocalDate illnessDate;
}
