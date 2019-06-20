package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.WorkersEntity;

public interface WorkersEntityRepository extends JpaRepository <WorkersEntity, Long> {

    @Query("select b from WorkersEntity b where b.name = :name")
    WorkersEntity findByName(@Param("name") String name);
}
