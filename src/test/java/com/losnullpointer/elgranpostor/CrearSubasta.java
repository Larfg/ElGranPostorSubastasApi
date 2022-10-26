package com.losnullpointer.elgranpostor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.losnullpointer.elgranpostor.persistence.jpa.JpaCategoriaRepository;
import com.losnullpointer.elgranpostor.persistence.jpa.JpaSubastaRepository;
import com.losnullpointer.elgranpostor.persistence.jpa.JpaUsuarioRepository;
import org.junit.jupiter.api.Test;

import com.losnullpointer.elgranpostor.exceptions.CrearSubastaException;
import com.losnullpointer.elgranpostor.model.MCategoria;
import com.losnullpointer.elgranpostor.model.MSubasta;
import com.losnullpointer.elgranpostor.model.MUsuario;
import org.springframework.beans.factory.annotation.Autowired;

public class CrearSubasta {
    @Autowired
    JpaCategoriaRepository cateRepo;
    @Autowired
    JpaUsuarioRepository usuRepo;
    @Autowired
    JpaSubastaRepository subaRepo;

    //Como crear una prueba para comprobar que una imagen se sube?
    @Test
    public void shouldCreateSubasta() {
        MUsuario usuario = new MUsuario(1);
        MCategoria categoria = new MCategoria("Automoviles");
        String tags = "";
        MSubasta subasta = null;
        try {
            subasta = new MSubasta(1,usuario,"Carro de payasos", categoria, tags,"Descripción",12,20000000);
        } catch (CrearSubastaException e) {
            fail();
        }
        assertEquals(subasta.toString(),"1,1,Carro de payasos,Automoviles,"+tags+",Descripción,12,2.0E7");
    }
    
    @Test
    public void shouldntCreateSubasta(){
        MUsuario usuario = new MUsuario(1);
        MCategoria categoria = new MCategoria("Automoviles");
        String tags = "";
        MSubasta subasta = null;
        String descripcionLarga = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aeneancommo do ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Na";
        try {
            subasta = new MSubasta(1,usuario,"Carro de payasos", categoria, tags,descripcionLarga,12,20000000);
        } catch (CrearSubastaException e) {
            return;
        }
        fail();
    }
    
}
