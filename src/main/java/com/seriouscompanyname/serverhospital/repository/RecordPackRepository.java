package com.seriouscompanyname.serverhospital.repository;

import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordPackRepository extends CrudRepository<RecordPack, Long> {
    RecordPack getRecordPackByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
