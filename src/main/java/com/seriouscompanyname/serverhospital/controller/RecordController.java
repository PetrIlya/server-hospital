package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/packs/{packName}")
public class RecordController {

    @Qualifier("recordServiceImpl")
    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"page", "size"})
    @ResponseBody
    public List<RecordDTO> getRecordPackPage(@PathVariable String packName,
                                             @RequestParam(name = "page", defaultValue = "0") String page,
                                             @RequestParam(name = "size", defaultValue = "10") String size) {
        return recordService.
                getRecordByPack(packName, page, size);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addRecord(@PathVariable String packName,
                            @RequestBody RecordDTO recordDTO) {
        recordService.save(packName, recordDTO);
        return "redirect:/packs/" + packName;
    }
}
