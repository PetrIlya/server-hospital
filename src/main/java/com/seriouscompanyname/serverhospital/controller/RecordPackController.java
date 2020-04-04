package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.dto.PackInformation;
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
@RequestMapping("/packs")
public class RecordPackController {

    @Qualifier("recordPackServiceImpl")
    private RecordPackService recordPackService;

    @Autowired
    public void setRecordPackService(RecordPackService recordPackService) {
        this.recordPackService = recordPackService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PackInformation> getAllPacksInformation() {
        return recordPackService.getAllPacksInformation();
    }

    @PostMapping
    public String addRecordPack(@RequestParam(name = "name") String packName) {
        RecordPack pack = new RecordPack();
        pack.setRecords(Collections.emptyList());
        pack.setName(packName);
        recordPackService.save(pack);
        return "redirect:/packs/" + packName;
    }

    @DeleteMapping
    public String deleteRecordPack(@RequestParam(name = "name") String packName) {
        recordPackService.deleteByName(packName);
        return "redirect:/packs";
    }
}
