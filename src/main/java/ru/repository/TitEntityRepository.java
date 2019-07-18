package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.TitEntity;

public interface TitEntityRepository extends JpaRepository <TitEntity, Long> {
    @Query("select b from TitEntity b where b.nametit = :nametit")
    TitEntity findByName(@Param("nametit") String nametit);
}
