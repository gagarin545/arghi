package ru.service;

import ru.entity.DivisionEntity;
import java.util.List;

public interface DivisionService {
    DivisionEntity addDivision(DivisionEntity divisionEntity);
    List<DivisionEntity> getAll();
    DivisionEntity getByName( String namedivision );
}
