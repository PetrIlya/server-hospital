package com.seriouscompanyname.serverhospital.service.implementation;

import com.seriouscompanyname.serverhospital.exception.NoSuchPackException;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordPackServiceImpl implements RecordPackRepository {
    @Qualifier("recordPackRepository")
    @Autowired
    private RecordPackRepository repository;


    @Override
    public RecordPack getRecordPackByName(String name) {
        RecordPack pack = repository.getRecordPackByName(name);
        if (pack == null) {
            throw new NoSuchPackException(name);
        }
        return pack;
    }

    @Override
    @NonNull
    public <S extends RecordPack> S save(@NonNull S s) {
        return repository.save(s);
    }

    @Override
    @NonNull
    public <S extends RecordPack> Iterable<S> saveAll(@NonNull Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    @NonNull
    public Optional<RecordPack> findById(@NonNull Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public boolean existsById(@NonNull Long aLong) {
        return repository.existsById(aLong);
    }

    @Override
    @NonNull
    public Iterable<RecordPack> findAll() {
        return repository.findAll();
    }

    @Override
    @NonNull
    public Iterable<RecordPack> findAllById(@NonNull Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(@NonNull Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(@NonNull RecordPack pack) {
        repository.delete(pack);
    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends RecordPack> iterable) {
        repository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
