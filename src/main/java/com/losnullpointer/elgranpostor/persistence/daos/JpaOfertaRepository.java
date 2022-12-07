package com.losnullpointer.elgranpostor.persistence.daos;

import com.losnullpointer.elgranpostor.model.entities.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface JpaOfertaRepository extends JpaRepository<Oferta, Serializable> {
    Oferta findFirstByOrderByIdDesc();
    List<Oferta> findByUsuarioIdUsuario(int id);
}
