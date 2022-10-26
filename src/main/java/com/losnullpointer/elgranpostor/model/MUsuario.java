package com.losnullpointer.elgranpostor.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

public class MUsuario implements Serializable {

    private Integer idUsuario;
    private List<MSubasta> subastas;

    public MUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public MUsuario() {

    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String toString(){
        return idUsuario.toString();
    }
}
