package com.losnullpointer.elgranpostor.persistence;

import java.util.List;

import com.losnullpointer.elgranpostor.exceptions.BuscarSubastaException;
import com.losnullpointer.elgranpostor.exceptions.ModificarSubastaException;
import com.losnullpointer.elgranpostor.model.entities.Oferta;
import com.losnullpointer.elgranpostor.model.entities.Subasta;

public interface SubastasPersistence {


    void saveSubasta(Subasta sb);

    Subasta getSubasta(int id);

    List<Subasta> getSubastasByUser(int id);

    List<Subasta> getSubastas();

    void deleteSubasta(int id);

    void pausarSubasta(int id) throws ModificarSubastaException, BuscarSubastaException;

    void resumaSubasta(int id) throws ModificarSubastaException, BuscarSubastaException;

    void finalizarSubasta(int id) throws ModificarSubastaException, BuscarSubastaException;

    void setMaxBidSubasta(int idSubasta, Float bid) throws BuscarSubastaException;

    Subasta getLastSubasta();

    void deleteLastSubasta();

    void addOfertaUsuario(Oferta oferta);

    List<Oferta> getOfertasUsuario(int id);
}
