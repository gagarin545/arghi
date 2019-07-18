package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.DevisionEntity;

public interface DevisionEntityRepository extends JpaRepository<DevisionEntity, Long> {
       @Query("select b from DevisionEntity b where b.namedevision = :namedevision")
       DevisionEntity findByName(@Param("namedevision") String namedevision);
}
