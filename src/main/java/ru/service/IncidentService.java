package ru.service;

import ru.entity.IncidentEntity;

import java.util.List;

public interface IncidentService {

    IncidentEntity addIncident(IncidentEntity incident);
    IncidentEntity getByName( String name);
    List<IncidentEntity> getAll();
}
