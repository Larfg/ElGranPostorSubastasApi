package com.losnullpointer.elgranpostor.persistence.daos;

import com.losnullpointer.elgranpostor.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface JpaCategoriaRepository extends JpaRepository<Categoria, Serializable> {
}