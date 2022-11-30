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
        //Este metodo debe estar vacio dado a que es necesario para el manejo de jpa
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
