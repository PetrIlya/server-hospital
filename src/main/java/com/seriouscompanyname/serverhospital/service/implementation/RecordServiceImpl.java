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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public List<RecordDTO> deleteByCondition(String packName, ConditionObject condition) {
        List<Record> recordsToDelete = recordPackRepository.
                getRecordPackByName(packName).
                getRecords().
                stream().
                filter(condition::meetsSearchRequirements).
                collect(Collectors.toList());
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
    public List<RecordDTO> getRecordByPack(RecordPack pack, Pageable pageable) {
        return recordRepository.getRecordByPack(pack, pageable).
                stream().
                map(e -> mapper.map(e, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public <S extends Record> S save(S s) {
        return recordRepository.save(s);
    }
}
