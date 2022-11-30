package com.losnullpointer.elgranpostor.model.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String name;


    public Categoria() {
        //Este metodo debe estar vacio dado a que es necesario para el manejo de jpa
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
