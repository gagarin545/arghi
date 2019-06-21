package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "public", catalog = "chel")
public class CityEntity {

    @Id
    @EmbeddedId
    private CityKeys keys;

    @Basic
    @Column(name = "namecity", length = 50)
    private String namecity;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
 //   @JoinColumn(name = "idtit", nullable = false)
 //   private TitEntity titEntity ;


    public String getNamecity() {        return namecity;    }
    public void setNamecity(String namecity) {        this.namecity = namecity;    }

    public CityKeys getKeys() {        return keys;    }
    public void setKeys(CityKeys keys) {        this.keys = keys;    }

    public CityEntity() {}
}
