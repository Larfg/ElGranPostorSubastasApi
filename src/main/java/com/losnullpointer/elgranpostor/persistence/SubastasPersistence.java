package com.losnullpointer.elgranpostor.persistence;

import java.util.List;

import com.losnullpointer.elgranpostor.model.MSubasta;

public interface SubastasPersistence {

    void saveSubasta(MSubasta sb);

    MSubasta getSubasta(int id);

    List<MSubasta> getSubastasByUser(int id);

    List<MSubasta> getSubastas();

    void deleteSubasta(int id);

    void pausarSubasta(int id);

    void resumaSubasta(int id);

    void finalizarSubasta(int id);
}
