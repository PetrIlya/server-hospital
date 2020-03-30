package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ApplicationController {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_RECORDS_PER_PAGE_VALUE = "10";

    @Autowired
    private RecordPackRepository recordPackRepository;
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    public ApplicationController(RecordPackRepository recordPackRepository) {
        this.recordPackRepository = recordPackRepository;
    }

    @GetMapping("/packs")
    public String getRecordPack(@RequestParam(name = "name") String name) {
        if (recordPackRepository.getRecordPackByName(name) != null) {
            return "redirect:/packs/" + name;
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping(value = "/packs/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Record> getPage(@PathVariable String name,
                                @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER, name = "page")
                                  String page,
                                @RequestParam(defaultValue = DEFAULT_RECORDS_PER_PAGE_VALUE, name = "size")
                                      String size) {
        return recordRepository.getRecordByPack(
                recordPackRepository.getRecordPackByName(name),
                PageRequest.of(
                        Integer.parseInt(page),
                        Integer.parseInt(size))
        );
    }
}
