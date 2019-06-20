package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "public", catalog = "chel")
public class CityEntity {

    @Id
    @Column(name = "idcity", nullable = false)
    private int idcity;

    @Basic
    @Column(name = "namecity", nullable = true, length = 50)
    private String namecity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtit", nullable = false)
    private TitEntity titEntity ;

    public int getIdcity() {        return idcity;    }
    public void setIdcity(int idcity) {        this.idcity = idcity;    }

    public String getNamecity() {        return namecity;    }
    public void setNamecity(String namecity) {        this.namecity = namecity;    }

    public TitEntity getTitEntity() {        return titEntity;    }
    public void setTitEntity(TitEntity titEntity) {        this.titEntity = titEntity;    }

    public CityEntity() {}
}
