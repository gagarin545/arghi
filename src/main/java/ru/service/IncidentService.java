package ru.service;

import ru.entity.IncidentEntity;

import java.util.List;

public interface IncidentService {

    void addIncident(IncidentEntity incident);
    IncidentEntity getByNumer( long n_incident);
    List<IncidentEntity> getAll();
}
