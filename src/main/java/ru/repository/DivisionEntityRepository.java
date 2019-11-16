package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.DivisionEntity;

public interface DivisionEntityRepository extends JpaRepository<DivisionEntity, Long> {
       @Query("select b from DivisionEntity b where b.namedivision = :namedivision")
       DivisionEntity findByName(@Param("namedivision") String namedivision);
}
