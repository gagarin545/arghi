package ru.util.CidrType;

import java.io.Serializable;

public class PgInet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String address;

    public PgInet(String address){
        this.address=address;
    }
    public PgInet(){
        this.address=null;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

