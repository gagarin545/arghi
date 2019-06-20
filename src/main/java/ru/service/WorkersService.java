package ru.service;

import ru.entity.WorkersEntity;

import java.util.List;

public interface WorkersService {
    WorkersEntity addWorker(WorkersEntity tit);
    WorkersEntity getByName( String name);
    List<WorkersEntity> getAll();
}
