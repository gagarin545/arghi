package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.DevisionEntity;
import ru.repository.DevisionEntityRepository;
import ru.service.DevisionService;

import java.util.List;

@Service("jpaDivision")
public class DevisonServiceImpl implements DevisionService {

    @Autowired
    private DevisionEntityRepository devisionEntityRepository;

    @Override
    public DevisionEntity addDivision(DevisionEntity divisionEntity) { return devisionEntityRepository.saveAndFlush(divisionEntity);    }
    @Override
    public List<DevisionEntity> getAll() {        return devisionEntityRepository.findAll();    }
    @Override
    public DevisionEntity getByName(String namedivision ) {        return devisionEntityRepository.findByName( namedivision);    }

}
