package ru.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "technology")
public class TechnogyEntity {

    @Id
    @GeneratedValue(generator = "increment")    // код технологии
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "idtechnology", length = 6, nullable = false)
    private long idTechnology;

    @Column(name = "nametechnology")    // Название технологий
    private String nametechnology;

    public long getIdTechnology() {        return idTechnology;    }
    public void setIdTechnology(long idTechnology) {        this.idTechnology = idTechnology;    }

    public String getMameTechnology() {        return nametechnology;    }
    public void setMameTechnology(String nametechnology) {        this.nametechnology = nametechnology;    }

    public TechnogyEntity() {} // Конструктор
}
