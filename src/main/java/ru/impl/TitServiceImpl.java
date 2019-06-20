package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.TitEntity;
import ru.repository.TitEntityRepository;
import ru.service.TitService;

import java.util.List;

@Service
public class TitServiceImpl implements TitService {

    @Autowired
    private TitEntityRepository titEntityRepository;

    @Override
    public TitEntity addTit(TitEntity tit) {        return titEntityRepository.saveAndFlush( tit);    }

    @Override
    public List<TitEntity> getAll() {        return titEntityRepository.findAll();    }

    @Override
    public TitEntity getByName(String nameTit) {        return titEntityRepository.findByName( nameTit);    }

}
