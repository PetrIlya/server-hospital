package com.seriouscompanyname.serverhospital.service.implementation;

import com.seriouscompanyname.serverhospital.dto.ConditionObject;
import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
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

    private RecordRepository record;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public RecordServiceImpl(RecordRepository record) {
        this.record = record;
    }

    @Override
    public void deleteByCondition(ConditionObject condition) {
        //TODO: Implement method
    }

    @Override
    public List<RecordDTO> getRecordByPack(RecordPack pack, Pageable pageable) {
        return record.getRecordByPack(pack, pageable).
                stream().
                map(e -> mapper.map(e, RecordDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public <S extends Record> S save(S s) {
        return record.save(s);
    }
}
