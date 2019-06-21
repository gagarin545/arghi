package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.IncidentEntity;

public interface IncidentEntityRepository extends JpaRepository <IncidentEntity, Long> {

}
