package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.model.Doctor;
import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.Student;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/packs/{packName}")
public class RecordController {

    @Qualifier("recordServiceImpl")
    private RecordService recordService;
    private RecordPackRepository recordPackRepository;

    @Autowired
    public void setRecordService(RecordService recordService, RecordPackRepository recordPackRepository) {
        this.recordService = recordService;
        this.recordPackRepository = recordPackRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<RecordDTO> getRecordPackPage(@PathVariable String packName,
                                             @RequestParam(name = "page", defaultValue = "0") String page,
                                             @RequestParam(name = "size", defaultValue = "10") String size) {
        return recordService.
                getRecordByPack(
                        recordPackRepository.getRecordPackByName(packName),
                        PageRequest.of(Integer.parseInt(page),
                                Integer.parseInt(size)));
    }

    @PutMapping
    public String addMockRecord(@PathVariable String packName) {
        Record record = new Record();

        Student student = new Student();
        student.setSurname("A");
        student.setName("B");
        student.setMiddleName("C");
        student.setIllnessDate(LocalDate.now());
        student.setBirthDate(LocalDate.now());

        Doctor doctor = new Doctor();
        doctor.setSurname("A");
        doctor.setName("B");
        doctor.setMiddleName("C");
        doctor.setIllnessAnalyse("AAA");

        record.setStudent(student);
        record.setDoctor(doctor);
        recordPackRepository.getRecordPackByName(packName).addRecord(record);
        recordService.save(record);
        return "redirect:/packs/" + packName;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addRecord(@PathVariable String packName, RecordDTO recordDTO) {
        return "redirect:/packs/" + packName;
    }
}
