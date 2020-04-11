package com.seriouscompanyname.serverhospital.service.implementation;

import com.seriouscompanyname.serverhospital.dto.ConditionObject;
import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.repository.RecordRepository;
import com.seriouscompanyname.serverhospital.service.RecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;
    private RecordPackRepository recordPackRepository;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public RecordServiceImpl(RecordRepository record) {
        this.recordRepository = record;
    }

    @Autowired
    public void setRecordPackRepository(RecordPackRepository recordPackRepository) {
        this.recordPackRepository = recordPackRepository;
    }

    @Override
    @Transactional
    public List<RecordDTO> deleteByCondition(String packName, ConditionObject condition) {
        RecordPack pack = recordPackRepository.
                getRecordPackByName(packName);
        List<Record> recordsToDelete = pack.
                getRecords().
                stream().
                filter(condition::meetsSearchRequirements).
                collect(Collectors.toList());

        recordsToDelete.forEach(pack::removeRecord);

        recordRepository.deleteAll(recordsToDelete);
        return recordsToDelete.
                stream().
                map(record -> mapper.map(record, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public List<RecordDTO> findByCondition(String packName, ConditionObject condition) {
        return recordPackRepository.
                getRecordPackByName(packName).
                getRecords().
                stream().
                filter(condition::meetsSearchRequirements).
                map(record -> mapper.map(record, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public List<RecordDTO> getRecordByPack(String packName, Pageable pageable) {
        return recordRepository.
                getRecordByPack(recordPackRepository.
                        getRecordPackByName(packName), pageable).
                stream().
                map(e -> mapper.map(e, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public List<RecordDTO> getRecordByPack(String packName, String page, String size) {
        return recordRepository.
                getRecordByPack(
                        recordPackRepository.getRecordPackByName(packName),
                        PageRequest.of(Integer.parseInt(page),
                                Integer.parseInt(size))).
                stream().
                map(e -> mapper.map(e, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    @Transactional
    public <S extends Record> S save(@NonNull S s) {
        return recordRepository.save(s);
    }

    @Transactional
    public void save(String packName, RecordDTO recordDTO) {
        Record record = mapper.map(recordDTO, Record.class);
        recordPackRepository.getRecordPackByName(packName).addRecord(record);
        recordRepository.save(record);
    }
}
