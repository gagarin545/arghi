package ru.entity;


import javax.persistence.*;

@Entity
@Table(name = "technology")
public class TechnogyEntity {
    @Id  // код технологии
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtechnology", length = 6, nullable = false, columnDefinition = "serial")
    private long idTechnology;
    @Column(name = "nametechnology")    // Название технологий
    private String nametechnology;
    public TechnogyEntity() {} // Конструктор
    public long getIdTechnology() {        return idTechnology;    }
    public void setIdTechnology(long idTechnology) {        this.idTechnology = idTechnology;    }
    public String getMameTechnology() {        return nametechnology;    }
    public void setMameTechnology(String nametechnology) {        this.nametechnology = nametechnology;    }
}
