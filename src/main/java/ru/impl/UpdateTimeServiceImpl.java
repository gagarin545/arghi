package ru.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.UpdateTimeEntity;
import ru.repository.UpdateTimeEntityRepository;
import ru.service.UpdateTimeService;
import java.sql.Timestamp;
import java.util.List;

@Service("jpaTime")
public class UpdateTimeServiceImpl implements UpdateTimeService {

    @Autowired
    private UpdateTimeEntityRepository updateTimeEntityRepository;

    @Override
    public void updateTime(UpdateTimeEntity updateTimeEntity) {        updateTimeEntityRepository.saveAndFlush(updateTimeEntity);    }
    @Override
    public UpdateTimeEntity getTime(int id) {        return updateTimeEntityRepository.findByTime( id);    }
    @Override
    public List<UpdateTimeEntity> getrecord() {        return updateTimeEntityRepository.findAll();    }

}
