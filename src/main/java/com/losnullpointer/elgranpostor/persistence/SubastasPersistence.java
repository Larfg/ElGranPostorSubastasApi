package com.losnullpointer.elgranpostor.persistence;

import java.util.List;

import com.losnullpointer.elgranpostor.model.entities.Subasta;

public interface SubastasPersistence {


    void saveSubasta(Subasta sb);

    Subasta getSubasta(int id);

    List<Subasta> getSubastasByUser(int id);

    List<Subasta> getSubastas();

    void deleteSubasta(int id);

    void pausarSubasta(int id) throws Exception;

    void resumaSubasta(int id) throws Exception;

    void finalizarSubasta(int id) throws Exception;

    void setMaxBidSubasta(int idSubasta, Float bid);
}
