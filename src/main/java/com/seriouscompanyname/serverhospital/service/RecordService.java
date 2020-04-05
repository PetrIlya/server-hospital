package com.seriouscompanyname.serverhospital.service;

import com.seriouscompanyname.serverhospital.dto.ConditionObject;
import com.seriouscompanyname.serverhospital.dto.model.RecordDTO;
import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import java.util.List;

public interface RecordService {
    List<RecordDTO> deleteByCondition(String packName, ConditionObject condition);

    List<RecordDTO> findByCondition(String packName, ConditionObject condition);

    List<RecordDTO> getRecordByPack(RecordPack pack, Pageable pageable);

    <S extends Record> S save(@NonNull S s);
}
