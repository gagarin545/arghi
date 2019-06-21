package ru.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CityKeys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "idcity")
    private int idcity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtit", nullable = false)
    private TitEntity titEntity ;

    public CityKeys() {}

    public static long getSerialVersionUID() {        return serialVersionUID;    }

    public int getIdcity() {        return idcity;    }
    public void setIdcity(int idcity) {        this.idcity = idcity;    }

    public TitEntity getTitEntity() {        return titEntity;    }
    public void setTitEntity(TitEntity titEntity) {        this.titEntity = titEntity;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityKeys cityKeys = (CityKeys) o;
        return idcity == cityKeys.idcity &&
                Objects.equals(titEntity, cityKeys.titEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcity, titEntity);
    }
}
