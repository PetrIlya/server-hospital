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
import javax.persistence.TypedQuery;
import java.util.List;

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
        List<String> packNames = recordPackRepository.getAllRecordPackNames();
        TypedQuery<PackInformation> informationTypedQuery = entityManager.
                createQuery("select " +
                        "pack.name, " +
                        "count (pack.records) from RecordPack pack", PackInformation.class);
        return informationTypedQuery.getResultList();
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
