package com.seriouscompanyname.serverhospital.service.implementation;

import com.seriouscompanyname.serverhospital.exception.NoSuchPackException;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.service.RecordPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecordPackServiceImpl implements RecordPackService {
    @Qualifier("recordPackRepository")
    private RecordPackRepository repository;

    @Autowired
    public RecordPackServiceImpl(RecordPackRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecordPack getRecordPackByName(String name) {
        RecordPack pack = repository.getRecordPackByName(name);
        if (pack == null) {
            throw new NoSuchPackException(name);
        }
        return pack;
    }

    @Override
    public List<String> getAllRecordPackNames() {
        Iterable<RecordPack> packs = repository.findAll();
        if (packs.spliterator().getExactSizeIfKnown() == 0) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(
                packs.spliterator(),
                false).
                map(RecordPack::getName).
                collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public <S extends RecordPack> S save(@NonNull S s) {
        return repository.save(s);
    }

    @Override
    public Iterable<RecordPack> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}
