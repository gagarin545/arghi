package ru.service;

import ru.entity.TitEntity;

import java.util.List;

public interface TitService {

    TitEntity addTit(TitEntity tit);
    List<TitEntity> getAll();
    TitEntity getByName( String nametit);
}
