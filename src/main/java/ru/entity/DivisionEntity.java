package ru.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "division")
public class DivisionEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "idDevision", length = 6, nullable = false, columnDefinition = "serial")
    private long idDevision;
    @Column(name = "namedivision", length = 150)
    private String namedivision ;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtit", nullable = true)
    private TitEntity titEntity ;

    public DivisionEntity() {} // Конструктор
    public long getIdDevision() {        return idDevision;    }
    public void setIdDevision(long idDevision) {        this.idDevision = idDevision;    }
    public String getNamedivision() {        return namedivision;    }
    public void setNamedivision(String namedivision) {        this.namedivision = namedivision;    }
    public TitEntity getTitEntity() {        return titEntity;    }
    public void setTitEntity(TitEntity titEntity) {        this.titEntity = titEntity;    }
}

