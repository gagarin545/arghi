package ru.service;

import ru.entity.TechnogyEntity;
import java.util.List;

public interface TechnologyService {

    TechnogyEntity addTechnology(TechnogyEntity technogyEntity);
    TechnogyEntity getById( String name);
    List<TechnogyEntity> getAll();

}
