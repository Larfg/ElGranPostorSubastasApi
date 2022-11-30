package com.losnullpointer.elgranpostor.model;

import com.losnullpointer.elgranpostor.model.entities.Categoria;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.model.entities.Usuario;

public class SubastaDTO {
    private int id;
    private Usuario usuario;
    private String nombre;
    private Categoria categoria;
    private String tags;
    private String descripcion;
    private int duracion;
    private float precio;
    private float ofertaMaxima;
    private boolean activa;
    private boolean finalizada;

    public SubastaDTO(int id,Usuario usuario, String nombre, Categoria categoria, String tags, String descripcion, float precio) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tags = tags;
        this.descripcion = descripcion;
        this.duracion = 0;
        this.precio = precio;
        this.ofertaMaxima = 0;
        this.activa = true;
        this.finalizada = false;
    }

    public Subasta convertToSubasta(){
        Subasta subasta = new Subasta();
        subasta.setUsuario(usuario);
        subasta.setNombre(nombre);
        subasta.setCategoria(categoria);
        subasta.setTags(tags);
        subasta.setDescripcion(descripcion);
        subasta.setDuracion(duracion);
        subasta.setPrecio(precio);
        subasta.setOfertaMaxima(ofertaMaxima);
        subasta.setActiva(activa);
        subasta.setFinalizada(finalizada);
        return subasta;
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

    public float getOfertaMaxima() {
        return ofertaMaxima;
    }

    public void setOfertaMaxima(float ofertaMaxima) {
        this.ofertaMaxima = ofertaMaxima;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}
