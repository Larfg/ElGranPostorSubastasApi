package com.losnullpointer.elgranpostor.model;

import javax.persistence.*;
import java.io.Serializable;

public class MCategoria {

    private int id;
    private String name;
    public MCategoria(int id, String name){
        this.id = id;
        this.name = name;
    }
    public MCategoria(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
