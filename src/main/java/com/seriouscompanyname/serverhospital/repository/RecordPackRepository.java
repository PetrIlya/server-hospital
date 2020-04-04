package com.seriouscompanyname.serverhospital.repository;

import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordPackRepository extends CrudRepository<RecordPack, Long> {
    RecordPack getRecordPackByName(String name);

    boolean existsByName(String name);

    @Query("select r.name from RecordPack r")
    List<String> getAllRecordPackNames();

    void deleteByName(String name);
}
