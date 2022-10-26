package com.losnullpointer.elgranpostor.persistence.jpa;

import com.losnullpointer.elgranpostor.model.MCategoria;
import com.losnullpointer.elgranpostor.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface JpaCategoriaRepository extends JpaRepository<Categoria, Serializable> {
}