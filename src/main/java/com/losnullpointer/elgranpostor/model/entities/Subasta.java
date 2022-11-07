package com.losnullpointer.elgranpostor.model.entities;

import com.losnullpointer.elgranpostor.exceptions.CrearSubastaException;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subastas")
public class Subasta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subasta_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Usuario usuario;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria",referencedColumnName = "id")
    private Categoria categoria;
    @Column(name = "tags")
    private String tags;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "duracion")
    private int duracion;
    @Column(name = "precio")
    private float precio;

    public Subasta(int id, Usuario usuario, String nombre, Categoria categoria, String tags, String descripcion, int duracion, float precio) throws CrearSubastaException {
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

    public Subasta(Usuario usuario, String nombre, Categoria categoria, String tags, String descripcion, int duracion, float precio) throws CrearSubastaException {
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

    public Subasta() {

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
}
