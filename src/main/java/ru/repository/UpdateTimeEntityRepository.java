package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.UpdateTimeEntity;
import java.sql.Timestamp;

public interface UpdateTimeEntityRepository extends JpaRepository <UpdateTimeEntity, Long> {

    @Query("select b from UpdateTimeEntity b where b.id = :id")
    UpdateTimeEntity findByTime(@Param("id") int id);


}
