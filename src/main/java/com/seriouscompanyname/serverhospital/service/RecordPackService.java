package com.seriouscompanyname.serverhospital.service;

import com.seriouscompanyname.serverhospital.dto.PackInformation;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import org.springframework.lang.NonNull;

import java.util.List;

public interface RecordPackService {
    RecordPack getRecordPackByName(String name);

    boolean existsByName(String name);

    <S extends RecordPack> S save(@NonNull S s);

    Iterable<RecordPack> findAll();

    void deleteByName(String name);

    List<PackInformation> getAllPacksInformation();
}
