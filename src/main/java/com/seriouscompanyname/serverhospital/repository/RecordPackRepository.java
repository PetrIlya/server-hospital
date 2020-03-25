package com.seriouscompanyname.serverhospital.repository;

import com.google.common.collect.Lists;
import com.seriouscompanyname.serverhospital.model.Record;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordPackRepository extends CrudRepository<RecordPack, Long> {
    RecordPack getRecordPackByName(String name);

    default List<Record> getRecordPackPage(String name,
                                           int recordPerPageValue,
                                           int pageNumber) {
        List<Record> page = null;
        try {
            page = Lists.partition(getRecordPackByName(name).getRecords(),
                    recordPerPageValue).get(pageNumber);
            return page;
        } catch (Exception e) {
            return page;
        }
    }

}
