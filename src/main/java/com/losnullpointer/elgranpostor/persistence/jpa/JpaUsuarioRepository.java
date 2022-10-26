package com.losnullpointer.elgranpostor.persistence.jpa;

import com.losnullpointer.elgranpostor.model.MUsuario;
import com.losnullpointer.elgranpostor.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface JpaUsuarioRepository extends JpaRepository<Usuario, Serializable> {
}
