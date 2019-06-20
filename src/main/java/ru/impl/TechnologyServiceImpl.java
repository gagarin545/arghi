package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.TechnogyEntity;
import ru.repository.TechnologyEntityRepository;

import java.util.List;

@Service
public class TechnologyServiceImpl implements ru.service.TechnologyService {

    @Autowired
    private TechnologyEntityRepository technologyEntityRepository;

    @Override
    public TechnogyEntity addTechnology(TechnogyEntity technogyEntity) {        return technologyEntityRepository.saveAndFlush(technogyEntity);    }

    @Override
    public List<TechnogyEntity> getAll() {        return technologyEntityRepository.findAll();    }

    @Override
    public TechnogyEntity getById(String name) {        return technologyEntityRepository.findById(name);    }
}
