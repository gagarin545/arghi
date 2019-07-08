package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.IncidentEntity;
import ru.repository.IncidentEntityRepository;
import ru.service.IncidentService;
import java.util.List;

@Service("jpaIncident")
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentEntityRepository incidentEntityRepository;

    @Override
    public IncidentEntity addIncident (IncidentEntity incident) {        return incidentEntityRepository.saveAndFlush( incident);    }
    @Override
    public IncidentEntity getByNumer(long n_incident) {         return incidentEntityRepository.findByNumer(n_incident);    }
    @Override
    public List<IncidentEntity> getAll() {        return incidentEntityRepository.findAll();    }
}
