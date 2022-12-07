package com.losnullpointer.elgranpostor.model.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity(name="ofertas")
public class Oferta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oferta_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="subasta_id",referencedColumnName = "subasta_id")
    private Subasta subasta;

    @Column(name = "oferta")
    private float ofertaUsuario;

    public Oferta(){
        //Este metodo debe estar vacio dado a que es necesario para el manejo de jpa
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
