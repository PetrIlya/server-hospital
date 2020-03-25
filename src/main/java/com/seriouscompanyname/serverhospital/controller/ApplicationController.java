package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApplicationController {
    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_RECORDS_PER_PAGE_VALUE = 10;

    private RecordPackRepository recordPackRepository;

    @Autowired
    public ApplicationController(RecordPackRepository recordPackRepository) {
        this.recordPackRepository = recordPackRepository;
    }

    @GetMapping("/packs")
    public String getRecordPack(@RequestParam String packName) {
        return "redirect:/packs/" + packName;
    }

    @GetMapping("/packs/{packName}")
    public String getPage(@PathVariable String packName, @RequestParam String pageNumber) {
        return null;
    }
}
