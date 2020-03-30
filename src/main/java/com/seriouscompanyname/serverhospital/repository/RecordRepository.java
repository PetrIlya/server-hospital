package com.seriouscompanyname.serverhospital.repository;

import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Long>,
        PagingAndSortingRepository<Record, Long> {
    List<Record> getRecordByPack(RecordPack pack, Pageable pageable);
}
