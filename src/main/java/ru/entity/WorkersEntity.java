package ru.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.util.Arraytype.IntArrayType;

import javax.persistence.*;

@Entity
@Table(name = "workers", schema = "public", catalog = "chel")
@TypeDefs( @TypeDef(name="int-array", typeClass = IntArrayType.class))
public class WorkersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idworker", nullable = false, columnDefinition = "serial")
    private int idworker;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "imei", nullable = true, length = 30)
    private String imei;
    @Type( type = "int-array")
    @Column ( name = "iddivision" , columnDefinition = "integer[]")
    private int[] iddivision;
    public WorkersEntity() {}
    public int getIdworker() {        return idworker;    }
    public void setIdworker(int idworker) {        this.idworker = idworker;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public String getImei() {        return imei;    }
    public void setImei(String imei) {        this.imei = imei;    }
    public int[] getIddivision() {        return iddivision;    }
    public void setIddivision(int[] iddivision) {        this.iddivision = iddivision;    }
}
