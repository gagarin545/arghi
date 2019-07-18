package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "public", catalog = "chel")
public class CityEntity {
    @Id
    @Basic
    @Column(name = "id", nullable = false, length = 2, columnDefinition = "serial")
    private Integer id;
    @Basic
    @Column(name = "namecity", length = 50)
    private String namecity;
    @Column(name = "idcity")
    private int idcity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtit", nullable = false)
    private TitEntity titEntity ;
    public CityEntity() {}

    public Integer getId() {        return id;    }
    public void setId(Integer id) {        this.id = id;    }
    public int getIdcity() {        return idcity;    }
    public void setIdcity(int idcity) {        this.idcity = idcity;    }
    public TitEntity getTitEntity() {        return titEntity;    }
    public void setTitEntity(TitEntity titEntity) {        this.titEntity = titEntity;    }
    public String getNamecity() {        return namecity;    }
    public void setNamecity(String namecity) {        this.namecity = namecity;    }

}
