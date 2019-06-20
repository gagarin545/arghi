package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.DivisionEntity;
import ru.entity.TechnogyEntity;

public interface TechnologyEntityRepository extends JpaRepository <TechnogyEntity, Long> {

    @Query("select b from TechnogyEntity b where b.nametechnology = :name")
    TechnogyEntity findById(@Param("name") String nametechnology);
}
