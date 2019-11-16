package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class DivisionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddivision", length = 6, nullable = false, columnDefinition = "serial")
    private long idDivision;
    @Column(name = "namedivision")
    private String namedivision;
    @Column(name = "idcity", length = 8)
    private Integer idcity;

    public DivisionEntity() {} // Конструктор
    public long getIdDivision() {        return idDivision;    }
    public void setIdDivision(long idDevision) {        this.idDivision = idDevision;    }
    public String getNameDivision() {        return namedivision;    }
    public void setNameDivision(String namedivision) {        this.namedivision = namedivision;    }
    public Integer getIdcity() {        return idcity;    }
    public void setIdcity(Integer idcity) {        this.idcity = idcity;    }
}

