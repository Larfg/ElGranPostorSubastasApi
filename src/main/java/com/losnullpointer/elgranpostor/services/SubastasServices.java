package com.losnullpointer.elgranpostor.services;

import java.util.List;

import com.losnullpointer.elgranpostor.exceptions.BuscarSubastaException;
import com.losnullpointer.elgranpostor.exceptions.ModificarSubastaException;
import com.losnullpointer.elgranpostor.model.entities.Oferta;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losnullpointer.elgranpostor.persistence.SubastasPersistence;

@Service
public class SubastasServices {

    @Autowired
    SubastasPersistence sbp;

    public void addNewSubasta(Subasta sb){
        sbp.saveSubasta(sb);
    }

    public Subasta getSubasta(int id){
        return sbp.getSubasta(id);
    }

    public List<Subasta> getSubastasByUser(int id){
        return sbp.getSubastasByUser(id);
    }


    public void pausarSubasta(int id) throws ModificarSubastaException, BuscarSubastaException {sbp.pausarSubasta(id);
    }

    public void resumaSubasta(int id) throws ModificarSubastaException, BuscarSubastaException {
        sbp.resumaSubasta(id);
    }
    public void finalizarSubasta(int id) throws ModificarSubastaException, BuscarSubastaException {
        sbp.finalizarSubasta(id);
    }

    public List<Subasta> getSubastas() {return sbp.getSubastas();}

    public void setMaxBidSubasta(int idSubasta, Float bid)  {
        try {
            sbp.setMaxBidSubasta(idSubasta,bid);
        } catch (BuscarSubastaException ignored) {
            return;
        }
    }

    public Subasta getLastSubasta(){
        return sbp.getLastSubasta();
    }

    public void deleteLastSubasta(){
        sbp.deleteLastSubasta();
    }

    public void addOfertaUsuario(Oferta oferta) {sbp.addOfertaUsuario(oferta);}

    public List<Oferta> getOfertasUsuario(int id) {return sbp.getOfertasUsuario(id);}

    public Oferta getLastOferta() {return sbp.getLastOferta();}

    public void deleteLastOferta() {sbp.deleteLAstOferta();}
}
