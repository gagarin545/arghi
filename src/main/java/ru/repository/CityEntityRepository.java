package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.CityEntity;

public interface CityEntityRepository extends JpaRepository <CityEntity, Long> {
}
