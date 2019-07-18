package ru.service;

import ru.entity.CityEntity;

import java.util.List;

public interface CityService {
    List<CityEntity> getAll();
    CityEntity getByIdTit( Integer idcity);
}
