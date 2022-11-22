package com.losnullpointer.elgranpostor.persistence.impl;


import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.persistence.SubastasPersistence;
import com.losnullpointer.elgranpostor.persistence.daos.JpaCategoriaRepository;
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


    @Override
    public void saveSubasta(Subasta sb) {
        subaRepo.save(sb);
    }

    @Override
    public Subasta getSubasta(int id) {
        return subaRepo.findById(id).get();
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
    public void pausarSubasta(int id) throws Exception {
        Subasta subasta = subaRepo.findById(id).get();
        if (subasta.isFinalizada()){
            throw new Exception("No se puede pausar una subasta finalizada");
        }
        subasta.setActiva(false);
        subaRepo.save(subasta);
    }

    @Override
    @Transactional
    public void resumaSubasta(int id) throws Exception {
        Subasta subasta = subaRepo.findById(id).get();
        if (subasta.isFinalizada()){
            throw new Exception("No se puede resumir una subasta finalizada");
        }
        subasta.setActiva(true);
        subaRepo.save(subasta);
    }

    @Override
    @Transactional
    public void finalizarSubasta(int id) throws Exception {
        Subasta subasta = subaRepo.findById(id).get();
        if (subasta.isFinalizada()){
            throw new Exception("No se puede finalizar una subasta ya finalizada");
        }
        subasta.setActiva(false);
        subasta.setFinalizada(true);
        subaRepo.save(subasta);
    }

    @Override
    public void setMaxBidSubasta(int idSubasta, Float bid) {
        Subasta subasta = subaRepo.findById(idSubasta).get();
        subasta.setOfertaMaxima(bid);
        subaRepo.save(subasta);
    }


}
