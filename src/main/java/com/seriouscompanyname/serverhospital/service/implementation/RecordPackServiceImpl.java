package com.seriouscompanyname.serverhospital.service.implementation;

import com.seriouscompanyname.serverhospital.dto.PackInformation;
import com.seriouscompanyname.serverhospital.exception.NoSuchPackException;
import com.seriouscompanyname.serverhospital.model.RecordPack;
import com.seriouscompanyname.serverhospital.repository.RecordPackRepository;
import com.seriouscompanyname.serverhospital.service.RecordPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecordPackServiceImpl implements RecordPackService {

    private EntityManager entityManager;

    @Qualifier("recordPackRepository")
    private RecordPackRepository recordPackRepository;

    @Autowired
    public RecordPackServiceImpl(RecordPackRepository recordPackRepository, EntityManager entityManager) {
        this.recordPackRepository = recordPackRepository;
        this.entityManager = entityManager;
    }

    @Override
    public RecordPack getRecordPackByName(String name) {
        RecordPack pack = recordPackRepository.getRecordPackByName(name);
        if (pack == null) {
            throw new NoSuchPackException(name);
        }
        return pack;
    }

    @Override
    public List<PackInformation> getAllPacksInformation() {
        return StreamSupport.
                stream(recordPackRepository.findAll().spliterator(), false).
                map(pack -> new PackInformation(
                        pack.getName(),
                        pack.getRecords().size())).
                collect(Collectors.toList());
    }


    @Override
    public boolean existsByName(String name) {
        return recordPackRepository.existsByName(name);
    }

    @Override
    public <S extends RecordPack> S save(@NonNull S s) {
        return recordPackRepository.save(s);
    }

    @Override
    public Iterable<RecordPack> findAll() {
        return recordPackRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        recordPackRepository.deleteByName(name);
    }
}
