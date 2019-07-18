package ru.service;

import ru.entity.DevisionEntity;
import java.util.List;

public interface DevisionService {
    DevisionEntity addDivision(DevisionEntity divisionEntity);
    List<DevisionEntity> getAll();
    DevisionEntity getByName( String namedivision );
}
