package com.losnullpointer.elgranpostor.services;

import java.util.List;

import com.losnullpointer.elgranpostor.model.entities.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losnullpointer.elgranpostor.model.MSubasta;
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


    public void pausarSubasta(int id) throws Exception {sbp.pausarSubasta(id);
    }

    public void resumaSubasta(int id) throws Exception {
        sbp.resumaSubasta(id);
    }
    public void finalizarSubasta(int id) throws Exception {
        sbp.finalizarSubasta(id);
    }

    public List<Subasta> getSubastas() {return sbp.getSubastas();}

}
