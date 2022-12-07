package com.losnullpointer.elgranpostor.persistence.impl;


import com.losnullpointer.elgranpostor.exceptions.BuscarSubastaException;
import com.losnullpointer.elgranpostor.exceptions.ModificarSubastaException;
import com.losnullpointer.elgranpostor.model.entities.Oferta;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.persistence.SubastasPersistence;
import com.losnullpointer.elgranpostor.persistence.daos.JpaCategoriaRepository;
import com.losnullpointer.elgranpostor.persistence.daos.JpaOfertaRepository;
import com.losnullpointer.elgranpostor.persistence.daos.JpaSubastaRepository;
import com.losnullpointer.elgranpostor.persistence.daos.JpaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubastasPersistenceRepository implements SubastasPersistence {

    @Autowired
    JpaCategoriaRepository cateRepo;
    @Autowired
    JpaUsuarioRepository usuRepo;
    @Autowired
    JpaSubastaRepository subaRepo;
    @Autowired
    JpaOfertaRepository ofeRepo;

    @Override
    public void saveSubasta(Subasta sb) {
        subaRepo.save(sb);
    }

    @Override
    public Subasta getSubasta(int id) {
        return subaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Subasta> getSubastasByUser(int id) {
        return subaRepo.findByUsuarioIdUsuario(id);
    }

    @Override
    public List<Subasta> getSubastas() {
        return subaRepo.findAll();
    }

    @Override
    public void deleteSubasta(int id) {
        subaRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void pausarSubasta(int id) throws ModificarSubastaException,BuscarSubastaException {
        Subasta subasta = subaRepo.findById(id).orElse(null);
        if (subasta == null){
            throw new BuscarSubastaException("No se puede pausar una subasta que no existe");
        }
        if (subasta.isFinalizada()){
            throw new ModificarSubastaException("No se puede pausar una subasta finalizada");
        }
        subasta.setActiva(false);
        subaRepo.save(subasta);
    }

    @Override
    @Transactional
    public void resumaSubasta(int id) throws ModificarSubastaException,BuscarSubastaException {
        Subasta subasta = subaRepo.findById(id).orElse(null);
        if (subasta == null){
            throw new BuscarSubastaException("No se puede resumir una subasta que no existe");
        }
        if (subasta.isFinalizada()){
            throw new ModificarSubastaException("No se puede resumir una subasta finalizada");
        }
        subasta.setActiva(true);
        subaRepo.save(subasta);
    }

    @Override
    @Transactional
    public void finalizarSubasta(int id) throws ModificarSubastaException, BuscarSubastaException {
        Subasta subasta = subaRepo.findById(id).orElse(null);
        if (subasta == null){
            throw new BuscarSubastaException("No se puede finalizar una subasta que no existe");
        }
        if (subasta.isFinalizada()){
            throw new ModificarSubastaException("No se puede finalizar una subasta ya finalizada");
        }
        subasta.setActiva(false);
        subasta.setFinalizada(true);
        subaRepo.save(subasta);
    }

    @Override
    public void setMaxBidSubasta(int idSubasta, Float bid) throws BuscarSubastaException {
        Subasta subasta = subaRepo.findById(idSubasta).orElse(null);
        if (subasta == null){
            throw new BuscarSubastaException("No se puede pausar una subasta que no existe");
        }
        subasta.setOfertaMaxima(bid);
        subaRepo.save(subasta);
    }

    @Override
    public Subasta getLastSubasta() {
        return subaRepo.findFirstByOrderByIdDesc();
    }

    @Override
    public void deleteLastSubasta() {
        subaRepo.deleteById(getLastSubasta().getId());
    }

    @Override
    public void addOfertaUsuario(Oferta oferta) {
        ofeRepo.save(oferta);
    }

    @Override
    public List<Oferta> getOfertasUsuario(int id) {
        return ofeRepo.findByUsuarioIdUsuario(id);
    }

    @Override
    public Oferta getLastOferta() {
        return ofeRepo.findFirstByOrderByIdDesc();
    }

    @Override
    public void deleteLAstOferta() {
        ofeRepo.deleteById(ofeRepo.findFirstByOrderByIdDesc().getId());
    }


}
