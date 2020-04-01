package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.service.RecordPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RecordPackController {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_RECORDS_PER_PAGE_VALUE = "10";

    @Qualifier("recordPackServiceImpl")
    private RecordPackService recordPackService;

    @Autowired
    public void setRecordPackService(RecordPackService recordPackService) {
        this.recordPackService = recordPackService;
    }

    @GetMapping(value = "/packs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getAllAviablePackNames() {
        return recordPackService.getAllRecordPackNames();
    }

    @Deprecated
    @PostMapping(value = "/add-pack",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addRecordPack(RecordPack pack) {
        recordPackService.save(pack);
    }
}
