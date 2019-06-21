package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.IncidentEntity;
import ru.repository.IncidentEntityRepository;
import ru.service.IncidentService;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentEntityRepository incidentEntityRepository;

    @Override
    public IncidentEntity addIncident (IncidentEntity incident) {        return incidentEntityRepository.saveAndFlush( incident);    }

    @Override
    public IncidentEntity getByName(String name) {
        return null;
    }

    @Override
    public List<IncidentEntity> getAll() {        return incidentEntityRepository.findAll();    }
}
