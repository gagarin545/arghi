package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.DivisionEntity;
import ru.repository.DivisionEntityRepository;
import ru.service.DivisionService;

import java.util.List;

@Service
public class DivisonServiceImpl implements DivisionService {

    @Autowired
    private DivisionEntityRepository divisionEntityRepository;

    @Override
    public DivisionEntity addDivision(DivisionEntity divisionEntity) { return divisionEntityRepository.saveAndFlush(divisionEntity);    }

    @Override
    public List<DivisionEntity> getAll() {        return divisionEntityRepository.findAll();    }

    @Override
    public DivisionEntity getByName(String namedivision ) {        return divisionEntityRepository.findByName( namedivision);    }

}
