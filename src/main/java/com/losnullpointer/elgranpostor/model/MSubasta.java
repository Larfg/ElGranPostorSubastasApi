package com.losnullpointer.elgranpostor.model;

import java.io.Serializable;

import com.losnullpointer.elgranpostor.exceptions.CrearSubastaException;
import javax.persistence.*;

public class MSubasta {

    private String tags;
    private int id;
    private MUsuario usuario;
    private String nombre;
    private MCategoria categoria;
    private String descripcion;
    private int duracion;
    private float precio;

    private boolean activa = true;

    private boolean finalizada = false;



    public MSubasta(int id, MUsuario usuario, String nombre, MCategoria categoria, String tags, String descripcion, int duracion, float precio) throws CrearSubastaException {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tags = tags;
        if (descripcion.length() > 1000) {
            throw new CrearSubastaException("La descripcion solo puede ser de 1000 caracteres borre");
        }
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String toString(){
        return id+","+
            usuario.toString()+","+
            nombre+","+
            categoria.getName()+","+
            tags.toString()+","+
            descripcion+","+
            duracion+","+
            precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(MUsuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(MCategoria categoria) {
        this.categoria = categoria;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        if(finalizada){
            this.activa = false;
        }
        else {
            this.activa = activa;
        }
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        if (!finalizada){
            this.finalizada = finalizada;
        }
    }
}
