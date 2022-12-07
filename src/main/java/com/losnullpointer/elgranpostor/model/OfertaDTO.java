package com.losnullpointer.elgranpostor.model;

import com.losnullpointer.elgranpostor.model.entities.Oferta;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.model.entities.Usuario;


public class OfertaDTO {
    private int id;
    private Usuario usuario;
    private Subasta subasta;
    private float ofertaUsuario;

    public OfertaDTO(Usuario usuario, Subasta subasta, float ofertaUsuario) {
        this.usuario = usuario;
        this.subasta = subasta;
        this.ofertaUsuario = ofertaUsuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Subasta getSubasta() {
        return subasta;
    }
    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
    public float getOfertaUsuario() {
        return ofertaUsuario;
    }
    public void setOfertaUsuario(float oferta) {
        this.ofertaUsuario = oferta;
    }

    public Oferta convertToOferta(){
        Oferta oferta = new Oferta();
        oferta.setUsuario(this.usuario);
        oferta.setSubasta(this.subasta);
        oferta.setOfertaUsuario(this.ofertaUsuario);
        return oferta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
