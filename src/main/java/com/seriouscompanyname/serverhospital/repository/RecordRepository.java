package com.seriouscompanyname.serverhospital.repository;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Long> {
    List<Record> getRecordByPack(RecordPack pack, Pageable pageable);

    List<Record> getRecordByPack(RecordPack pack);
}
