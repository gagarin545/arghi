package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.CityEntity;

public interface CityEntityRepository extends JpaRepository <CityEntity, Long> {
    @Query("select b from CityEntity b where b.namecity = :namecity")
    CityEntity findByName(@Param("namecity") String namecity);
    @Query("select b from CityEntity b where b.idcity = :idcity")
    CityEntity findByIdtit(@Param("idcity") Integer idcity);
}
