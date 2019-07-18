package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.CityEntity;
import ru.repository.CityEntityRepository;
import ru.service.CityService;

import java.util.List;

@Service("jpaCity")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityEntityRepository cityEntityRepository;

    @Override
    public List<CityEntity> getAll() {        return cityEntityRepository.findAll();    }
    @Override
    public CityEntity getByIdTit(Integer idcity) {        return cityEntityRepository.findByIdtit( idcity);    }
}
