package com.seriouscompanyname.serverhospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PackInformation {
    private String name;
    private int totalRecordsAmount;
}
