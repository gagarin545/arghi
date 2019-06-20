package ru.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "updatetime", schema = "public", catalog = "chel")
public class UpdateTimeEntity {

    @Id
    @Basic
    @Column(name = "id")
    private int id;

    @Column(name = "timeupdate")
    private Timestamp timeupdate;

    public int getId() {        return id;    }
    public void setId(int id) {        this.id = id;    }

    public Timestamp getTimeUpdate() {        return timeupdate;    }
    public void setTimeUpdate(Timestamp timeupdate) {        this.timeupdate = timeupdate;    }

    public UpdateTimeEntity() {}


}
