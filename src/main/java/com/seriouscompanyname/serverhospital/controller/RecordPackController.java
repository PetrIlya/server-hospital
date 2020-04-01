package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.service.RecordPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public List<String> getAllPackNames() {
        return recordPackService.getAllRecordPackNames();
    }

    @PostMapping(value = "/add-pack")
    public String addRecordPack(@RequestParam(name = "name") String packName) {
        RecordPack pack = new RecordPack();
        pack.setRecords(Collections.emptyList());
        pack.setName(packName);
        recordPackService.save(pack);
        return "redirect:/packs" + "/" + packName;
    }

    @DeleteMapping(value = "/delete-pack")
    public String deleteRecordPack(@RequestParam(name = "name") String packName) {
        recordPackService.deleteByName(packName);
        return "redirect:/packs";
    }
}