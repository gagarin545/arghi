package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "public", catalog = "chel")
public class CityEntity {
    @Id
    @EmbeddedId
    private CityKeys cityKeys;
    @Basic
    @Column(name = "namecity", length = 50)
    private String namecity;

    public CityEntity() {}

    public CityKeys getCityKeys() {        return cityKeys;    }
    public void setCityKeys(CityKeys cityKeys) {        this.cityKeys = cityKeys;    }
    public String getNamecity() {        return namecity;    }
    public void setNamecity(String namecity) {        this.namecity = namecity;    }

}
