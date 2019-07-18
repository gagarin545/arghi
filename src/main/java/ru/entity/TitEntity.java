package ru.entity;

import javax.persistence.*;

@Entity
@Table(name = "tit", schema = "public", catalog = "chel")
public class TitEntity {
    @Id
    @Column(name = "idtit", nullable = false, length = 2, columnDefinition = "serial")   // Код МЦТЭТ
    private long idtit;
    @Basic
    @Column(name = "nametit", length = 12) // Наименование МЦТЭТ
    private String nametit;
    public TitEntity() {} // Конструктор
    public long getIdTit() {        return idtit;    }
    public void setIdTit(long idtit) {        this.idtit = idtit;    }
    public String getNameTit() {        return nametit;    }
    public void setNameTit(String nametit) {        this.nametit = nametit;    }
}
