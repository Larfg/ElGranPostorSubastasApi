package com.losnullpointer.elgranpostor.model;


import java.util.ArrayList;
import java.util.List;

public class OfertasSubasta {
    final List<Float> ofertas = new ArrayList<>();

    public void aniadirOferta(float oferta){
        synchronized (ofertas){
            ofertas.add(oferta);
        }
    }

    public float ofertaMaxima(){
        float max = 0;
        for(Float oferta:ofertas){
            if (oferta > max){
                max = oferta;
            }
        }
        return max;
    }

}
