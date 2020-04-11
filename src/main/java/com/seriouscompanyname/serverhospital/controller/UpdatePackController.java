package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.dto.ConditionObject;
import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdatePackController {
    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping(value = "packs/{packName}/search",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RecordDTO> searchByCondition(@PathVariable String packName,
                                             @RequestBody ConditionObject conditionObject) {
        return recordService.findByCondition(packName, conditionObject);
    }

    @PostMapping(value = "packs/{packName}/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecordDTO> deleteByCondition(@PathVariable String packName,
                                             @RequestBody ConditionObject conditionObject) {
        return recordService.deleteByCondition(packName, conditionObject);
    }
}
