package com.losnullpointer.elgranpostor.persistence.jpa;

import com.losnullpointer.elgranpostor.model.MSubasta;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface JpaSubastaRepository extends JpaRepository<Subasta, Serializable> {
}
