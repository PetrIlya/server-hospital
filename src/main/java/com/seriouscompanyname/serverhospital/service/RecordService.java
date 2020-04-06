package com.seriouscompanyname.serverhospital.service;

import com.seriouscompanyname.serverhospital.dto.ConditionObject;
import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.model.Record;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;

public interface RecordService {
    List<RecordDTO> deleteByCondition(String packName, ConditionObject condition);

    List<RecordDTO> findByCondition(String packName, ConditionObject condition);

    List<RecordDTO> getRecordByPack(String packName, Pageable pageable);

    List<RecordDTO> getRecordByPack(String packName, String page, String size);

    <S extends Record> S save(@NonNull S s);

    void save(String packName, RecordDTO recordDTO);
}
