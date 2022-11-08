package com.losnullpointer.elgranpostor.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.GsonBuilder;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.google.gson.Gson;

import com.losnullpointer.elgranpostor.services.SubastasServices;

import static java.lang.reflect.Modifier.TRANSIENT;

@RestController
@RequestMapping(value = "version1/subastas")
public class SubastasController {
    @Autowired
    SubastasServices sbs;

    @GetMapping("/subasta/")
    public ResponseEntity<?> controllerGetSubastas(){
        try {
            List<Subasta> data = sbs.getSubastas();
            final Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(data),HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo consultar", HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Metodo que devuelve una subasta buscada por id
     * @param id identificador de la subasta
     * @return subasta que pertenece al identificador ingresado
     */
    @GetMapping("/subasta/{id}")
    public ResponseEntity<?> controllerGetSubastaById(@PathVariable("id") int id){
        try{
            Subasta data = sbs.getSubasta(id);
            Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(data), HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo consultar", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que devuelve las subastas relacionadas a una persona
     * @param id identificador de la persona la cual queremos consultar sus subastas
     * @return Subastas de la persona que queremos buscar o mensaje de error
     */
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> controllerGetSubastaByUser(@PathVariable("id") int id){
        try{
            List<Subasta> data = sbs.getSubastasByUser(id);
            Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(data), HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo consultar", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo para agregar una nueva subasta
     * Formato {"id":2,"usuario":{"idUsuario":1},"nombre":"Chevi 1079","categoria":{"id":1,"name":"Automoviles"},"tags":"XD,:v","descripcion":"Carro en perfectas condiciones","duracion":12,"precio":200000.0,"activa":true,"finalizada":false}
     * @param sb subasta que se va a añadir
     * @return mensaje informando si se añadio o no la subasta
     */
     @RequestMapping(value="/add", method= RequestMethod.POST)
     public ResponseEntity<?> controllerPostSubasta(@RequestBody Subasta sb){
         try{
             sbs.addNewSubasta(sb);
             return new ResponseEntity<>("Subasta añadida con exito", HttpStatus.CREATED);
         }catch (Exception ex){
           Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo agregar", HttpStatus.FORBIDDEN);
        }
     }
     @GetMapping("/subasta/{id}/end")
     public ResponseEntity<?> controllerEndSubasta(@PathVariable("id") int id){
         try {
             sbs.finalizarSubasta(id);
             return new ResponseEntity<>("Subasta finalizada con exito",HttpStatus.ACCEPTED);
         }catch (Exception ex){
             Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE,null,ex);
             return new ResponseEntity<>("No se pudo finalizar",HttpStatus.FORBIDDEN);
         }
     }
    @GetMapping("/subasta/{id}/resume")
    public ResponseEntity<?> controllerResumeSubasta(@PathVariable("id") int id){
        try {
            sbs.resumaSubasta(id);
            return new ResponseEntity<>("Subasta resumida con exito",HttpStatus.ACCEPTED);
        }catch (Exception ex){
            Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>("No se pudo resumir: " + ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/subasta/{id}/pause")
    public ResponseEntity<?> controllerPauseSubasta(@PathVariable("id") int id){
        try {
            sbs.pausarSubasta(id);
            return new ResponseEntity<>("Subasta pausada con exito",HttpStatus.ACCEPTED);
        }catch (Exception ex){
            Logger.getLogger(SubastasController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>("No se pudo finalizar",HttpStatus.FORBIDDEN);
        }
    }

}
