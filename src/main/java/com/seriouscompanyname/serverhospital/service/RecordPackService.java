package com.seriouscompanyname.serverhospital.service;

import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.repository.CrudRepository;

public interface RecordPackService extends CrudRepository<RecordPack, Long> {
    RecordPack getRecordPackByName(String name);
}
