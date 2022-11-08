package com.losnullpointer.elgranpostor.persistence.impl;

import com.losnullpointer.elgranpostor.exceptions.CrearSubastaException;
import com.losnullpointer.elgranpostor.model.MCategoria;
import com.losnullpointer.elgranpostor.model.MSubasta;
import com.losnullpointer.elgranpostor.model.MUsuario;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.persistence.SubastasPersistence;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


public class SubastasPersistenceImpl {
    List<MSubasta> subastas = new ArrayList<>();
    List<MUsuario> usuarios = new ArrayList<>();
    List<MCategoria> categorias = new ArrayList<>();

    public void perSistenceInit(){
        categorias.add(new MCategoria(1,"Autos"));
        categorias.add(new MCategoria(2,"Arte"));
        categorias.add(new MCategoria(3,"Coleccionables"));
        categorias.add(new MCategoria(4,"Lotes"));
        categorias.add(new MCategoria(5,"Vivienda"));
        categorias.add(new MCategoria(6,"Bodegas"));
        usuarios.add(new MUsuario(1));
        usuarios.add(new MUsuario(2));
        usuarios.add(new MUsuario(3));
        try {
            subastas.add(new MSubasta(1,usuarios.get(0),"Chevi blanco",categorias.get(0),"blanco,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(2,usuarios.get(1),"Chevi negro",categorias.get(0),"negro,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(3,usuarios.get(0),"Chevi azul",categorias.get(0),"azul,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(4,usuarios.get(1),"Chevi rojo",categorias.get(0),"rojo,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(5,usuarios.get(0),"Chevi verde",categorias.get(0),"verde,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(6,usuarios.get(1),"Chevi morado",categorias.get(0),"morado,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(7,usuarios.get(0),"Chevi amarillo",categorias.get(0),"amarillo,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
            subastas.add(new MSubasta(8,usuarios.get(1),"Chevi violeta",categorias.get(0),"violeta,nuevo,coleccion",
                    "Carro de coleccionismo en buenas condiciones",12,200000000));
        } catch (CrearSubastaException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveSubasta(MSubasta sb) {
        subastas.add(sb);
    }





    public List<MSubasta> getSubastasByUser(int id) {
        List<MSubasta> subastasUsuario = new ArrayList<>();
        for(MSubasta subasta:subastas){
            if (subasta.getUsuario().getIdUsuario() == id){
                subastasUsuario.add(subasta);
            }
        }
        return subastasUsuario;
    }


    public List<MSubasta> getSubastas() {
        return subastas;
    }


    public void deleteSubasta(int id) {
        for(int i = 0; i < subastas.size();i++){
            if (subastas.get(i).getId() == id){
                subastas.remove(i);
                return;
            }
        }
    }


    public void pausarSubasta(int id) {
        for(MSubasta subasta:subastas){
            if (subasta.getId() == id){
                subasta.setActiva(false);
            }
        }
    }


    public void resumaSubasta(int id) {
        for(MSubasta subasta:subastas){
            if (subasta.getId() == id){
                subasta.setActiva(true);
            }
        }
    }


    public void finalizarSubasta(int id) {
        for(MSubasta subasta:subastas){
            if (subasta.getId() == id){
                subasta.setFinalizada(true);
            }
        }
    }
}
