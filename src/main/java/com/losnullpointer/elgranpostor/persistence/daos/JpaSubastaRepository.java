package com.losnullpointer.elgranpostor.persistence.daos;

import com.losnullpointer.elgranpostor.model.entities.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface JpaSubastaRepository extends JpaRepository<Subasta, Serializable> {

    List<Subasta> findByUsuarioIdUsuario(int id);

}
