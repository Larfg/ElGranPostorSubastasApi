package com.losnullpointer.elgranpostor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losnullpointer.elgranpostor.model.MSubasta;
import com.losnullpointer.elgranpostor.persistence.SubastasPersistence;

@Service
public class SubastasServices {

    @Autowired
    SubastasPersistence sbp;

    public void addNewSubasta(MSubasta sb){
        sbp.saveSubasta(sb);
    }

    public MSubasta getSubasta(int id){
        return sbp.getSubasta(id);
    }

    public List<MSubasta> getSubastasByUser(int id){
        return sbp.getSubastasByUser(id);
    }


    public void pausarSubasta(int id) {sbp.pausarSubasta(id);
    }

    public void resumaSubasta(int id){
        sbp.resumaSubasta(id);
    }
    public void finalizarSubasta(int id){
        sbp.finalizarSubasta(id);
    }

    public List<MSubasta> getSubastas() {return sbp.getSubastas();}

}
