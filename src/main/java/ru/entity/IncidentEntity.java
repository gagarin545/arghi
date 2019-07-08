package ru.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.util.CidrType.PgInet;
import ru.util.CidrType.PgInetType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "incident", schema = "public", catalog = "chel")
@TypeDefs(value={@TypeDef(name="convertInet",typeClass= PgInetType.class)})
public class IncidentEntity {
    @Basic
    @Column(name = "typeincident", nullable = false) //Тип инцидента
    private int typeincident;
    public int getTypeIncident() {        return typeincident;    }
    public void setTypeIncident(int typeincident) {        this.typeincident = typeincident;    }
    @Id
    @Basic
    @Column(name = "n_incident", nullable = false)    //№ инцидента
    private long n_incident;
    public long getnIncident() {        return n_incident;    }
    public void setnIncident(long n_incident) {        this.n_incident = n_incident;    }
    @Basic
    @Column(name = "idcity")   // Код города
    private int idcity;
    public int getIdCity() {        return idcity;    }
    public void setIdCity(int idcity) {        this.idcity = idcity;    }
    @Basic
    @Column(name = "service", nullable = false)   // Услуга
    private long service;
    public long getService() {        return service;    }
    public void setService(long service) {        this.service = service;    }

    @Basic
    @Column(name = "declared", columnDefinition = "text")  // Заявлено
    private String declared;
    public String getDeclared() { return declared;    }
    public void setDeclared(String declared) {        this.declared = declared;    }

    @Basic
    @Column(name = "controlterm", length = 40)  // Контрольное время
    private String controlterm;
    public String getControlTerm() {        return controlterm;    }
    public void setControlTerm(String controlterm) {        this.controlterm = controlterm;    }

    @Basic
    @Column(name = "controltermsla", length = 40)  // Контрольное время Sla
    private String controltermsla;
    public String getControlTermSla() {        return controltermsla;    }
    public void setControlTermSla(String controltermsla) {        this.controltermsla = controltermsla;    }

    @Basic
    @Column(name = "controltermtask", length = 40)  // Контрольное время Задачи
    private String controltermtask;
    public String getControlTermTask() {        return controltermtask;    }
    public void setControlTermTask(String controltermtask) {        this.controltermtask = controltermtask;    }

    @Basic
    @Column(name = "createtime")    // Время создания наряда
    private Timestamp createtime;
    public Timestamp getCreateTime() {        return createtime;    }
    public void setCreateTime(Timestamp createtime) {        this.createtime = createtime;    }

    @Basic
    @Column(name = "clazz", nullable = false, length = 20) // Кл.
    private String clazz;
    public String getClazz() {        return clazz; }
    public void setClazz(String clazz) {        this.clazz = clazz;    }

    @Basic
    @Column(name = "repet") // Повторность.
    private int repet;
    public int getRepet() {        return repet;    }
    public void setRepet(int repet) {        this.repet = repet;    }

    @Basic
    @Column(name = "yield") // Доходность
    private int yield;
    public int getYield() {        return yield;    }
    public void setYield(int yield) {        this.yield = yield;    }

    @Basic
    @Column(name = "decisiontime") // Время Визита
    private Timestamp decisiontime;
    public Timestamp getDecisionTime() {        return decisiontime; }
    public void setDecisionTime(Timestamp decisiontime) {        this.decisiontime = decisiontime; }

    @Basic
    @Column(name = "nameclient", length = 80) // Клиент
    private String nameclient;
    public String getNameClient() {        return nameclient;    }
    public void setNameClient(String nameclient) {        this.nameclient = nameclient;    }

    @Basic
    @Column(name = "labelofservice") // Уровень обслуживания
    private int labelofservice;
    public int getLabelOfService() {        return labelofservice;    }
    public void setLabelOfService(int labelofservice) {        this.labelofservice = labelofservice;    }

    @Basic
    @Column(name = "address", length = 100)   //Адрес
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "room", length = 10) //Помещение
    private String room;
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "phone") // Телефон
    private long phone;
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "techdata", columnDefinition = "text") // Тех. данные
    private String techdata;
    public String getTechData() {
        return techdata;
    }
    public void setTechData(String techdata) {
        this.techdata = techdata;
    }

    @Basic
    @Column(name = "comment", columnDefinition = "text")   // Комментарии
    private String comment;
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "ipaddress", length = 15)    // Ip адрес
    private String ipaddress;
    public String getIpAddress() {        return ipaddress;    }
    public void setIpAddress(String ipaddress) {        this.ipaddress = ipaddress;   }

    @Basic
    @Column(name = "slot")  // Слот
    private Integer slot;
    public Integer getSlot() {
        return slot;
    }
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Basic
    @Column(name = "port")  // Порт
    private Integer port;
    public Integer getPort() {
        return port;
    }
    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @Column(name = "ont")   //Ont
    private Integer ont;
    public Integer getOnt() {        return ont;    }
    public void setOnt(Integer ont) {        this.ont = ont;    }

    @Basic
    @Column(name = "timeclose")    // Время закрытия
    private Timestamp timeclose;
    public Timestamp getTimeClose() {        return timeclose;    }
    public void setTimeClose(Timestamp timeclose) {        this.timeclose = timeclose;    }

    @Basic
    @Column(name = "worker")   //Работник
    private Integer worker;
    public Integer getWorker() {        return worker;    }
    public void setWorker(Integer worker) {        this.worker = worker;    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "iddevision", nullable = false)
    private DivisionEntity divisionEntity;
    public DivisionEntity getDivisionEntity() {        return divisionEntity;    }
    public void setDivisionEntity(DivisionEntity divisionEntity) {        this.divisionEntity = divisionEntity;    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtechnology", nullable = false)
    private TechnogyEntity technogyEntity ;
    public TechnogyEntity getTechnogyEntity() {        return technogyEntity;    }
    public void setTechnogyEntity(TechnogyEntity technogyEntity) {
        this.technogyEntity = technogyEntity;
    }

    public IncidentEntity() {}
}
