package com.seriouscompanyname.serverhospital.repository;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordPackRepository extends CrudRepository<RecordPack, Long> {
    RecordPack getRecordPackByName(String name);
}
