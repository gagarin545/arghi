package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.IncidentEntity;

public interface IncidentEntityRepository extends JpaRepository <IncidentEntity, Long> {
    @Query("select b from IncidentEntity b where b.n_incident = :n_incident")
    IncidentEntity findByNumer(@Param("n_incident") long n_incident);
}
