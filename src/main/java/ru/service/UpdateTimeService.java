package ru.service;

import ru.entity.UpdateTimeEntity;

import java.sql.Timestamp;
import java.util.List;

public interface UpdateTimeService {
    void updateTime(UpdateTimeEntity updateTimeEntity);
    UpdateTimeEntity getTime( int id);
    List<UpdateTimeEntity> getrecord();
}
