package com.losnullpointer.elgranpostor.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    public Usuario() {

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
