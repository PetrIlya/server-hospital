package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.repository.RecordRepository;
import com.seriouscompanyname.serverhospital.service.RecordPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ApplicationController {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_RECORDS_PER_PAGE_VALUE = "10";

    @Qualifier("recordPackServiceImpl")
    private RecordPackService recordPackService;
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    public void setRecordPackService(RecordPackService recordPackService) {
        this.recordPackService = recordPackService;
    }

    @GetMapping("/packs")
    public String getRecordPack(@RequestParam(name = "name") String name) {
        return "redirect:/packs/" + name;
    }

    @GetMapping(value = "/packs/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Record> getPage(@PathVariable String name,
                                @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER, name = "page")
                                        String page,
                                @RequestParam(defaultValue = DEFAULT_RECORDS_PER_PAGE_VALUE, name = "size")
                                        String size) {
        return recordRepository.getRecordByPack(
                recordPackService.getRecordPackByName(name),
                PageRequest.of(
                        Integer.parseInt(page),
                        Integer.parseInt(size))
        );
    }
}
