package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.WorkersEntity;
import ru.repository.WorkersEntityRepository;
import ru.service.WorkersService;

import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    @Autowired
    private WorkersEntityRepository workersEntityRepository;

    @Override
    public WorkersEntity addWorker(WorkersEntity workers) {        return workersEntityRepository.saveAndFlush( workers);    }

    @Override
    public WorkersEntity getByName(String name) {        return workersEntityRepository.findByName( name);    }

    @Override
    public List<WorkersEntity> getAll() {        return workersEntityRepository.findAll();    }

}
