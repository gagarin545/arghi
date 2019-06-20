package ru.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class DivisionEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "idDevision", length = 6, nullable = false)
    private long idDevision;

    @Column(name = "namedivision")
    private String namedivision ;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtit", nullable = true)
    private TitEntity titEntity ;

    public long getIdDevision() {        return idDevision;    }
    public void setIdDevision(long idDevision) {        this.idDevision = idDevision;    }

    public String getMameDivison() {        return namedivision;    }
    public void setMameDivison(String namedivision ) {        this.namedivision = namedivision;    }

    public DivisionEntity() {} // Конструктор
}
