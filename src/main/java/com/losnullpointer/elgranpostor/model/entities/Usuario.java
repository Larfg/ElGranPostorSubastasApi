package com.losnullpointer.elgranpostor.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "IdUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @OneToMany(mappedBy = "usuario")
    private List<Subasta> subastas;

    public Usuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

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
