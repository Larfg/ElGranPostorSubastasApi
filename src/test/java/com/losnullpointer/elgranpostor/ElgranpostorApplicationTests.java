package com.losnullpointer.elgranpostor;

import com.losnullpointer.elgranpostor.exceptions.BuscarSubastaException;
import com.losnullpointer.elgranpostor.model.SubastaDTO;
import com.losnullpointer.elgranpostor.model.entities.Categoria;
import com.losnullpointer.elgranpostor.model.entities.Subasta;
import com.losnullpointer.elgranpostor.model.entities.Usuario;
import com.losnullpointer.elgranpostor.services.SubastasServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ElgranpostorApplicationTests {
	@Autowired
	SubastasServices sbs;


	@Test
	void shouldAddGetAndDeleteNewSubasta(){
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		Subasta sbb = sbs.getLastSubasta();
		sbs.deleteLastSubasta();
		assertEquals("prueba",sbb.getDescripcion());
	}

	@Test
	void shouldGetSubastasByUser(){
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba 1",13000);
		SubastaDTO sb2= new SubastaDTO(1,usuario,"Mazda",categoria,"nuevo,importado","prueba 2",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		sbs.addNewSubasta(sb2.convertToSubasta());
		List<Subasta> subastas = sbs.getSubastasByUser(1);
		sbs.deleteLastSubasta();
		sbs.deleteLastSubasta();
		assertEquals("prueba 1",subastas.get(subastas.size()-2).getDescripcion());
		assertEquals("prueba 2",subastas.get(subastas.size()-1).getDescripcion());

	}

	@Test
	void shouldPausarSubasta() {
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		int lastId = sbs.getLastSubasta().getId();
		try {
			sbs.pausarSubasta(lastId);
		} catch (Exception e) {
			fail();
		}
		Subasta sbb = sbs.getLastSubasta();
		sbs.deleteLastSubasta();
		assertFalse(sbb.isActiva());
	}

	@Test
	void shouldResumaSubasta() {
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		int lastId = sbs.getLastSubasta().getId();
		try {
			sbs.pausarSubasta(lastId);
			sbs.resumaSubasta(lastId);
		} catch (Exception e) {
			fail();
		}
		Subasta sbb = sbs.getLastSubasta();
		sbs.deleteLastSubasta();
		assertTrue(sbb.isActiva());
	}
	@Test
	void shouldFinalizarSubasta()  {
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		int lastId = sbs.getLastSubasta().getId();
		try {
			sbs.finalizarSubasta(lastId);
		} catch (Exception e) {
			fail();
		}
		Subasta sbb = sbs.getLastSubasta();
		sbs.deleteLastSubasta();
		assertTrue(sbb.isFinalizada());
	}
	@Test
	void shouldGetSubastas() {
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba 1",13000);
		SubastaDTO sb2= new SubastaDTO(1,usuario,"Mazda",categoria,"nuevo,importado","prueba 2",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		sbs.addNewSubasta(sb2.convertToSubasta());
		List<Subasta> subastas = sbs.getSubastas();
		sbs.deleteLastSubasta();
		sbs.deleteLastSubasta();
		assertTrue(subastas.size()>=2);
	}
	@Test
	void shouldSetMaxBidSubasta()  {
		Usuario usuario = new Usuario();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setName("Automoviles");
		usuario.setIdUsuario(1);
		SubastaDTO sb= new SubastaDTO(1,usuario,"Chevy",categoria,"nuevo,importado","prueba",13000);
		sbs.addNewSubasta(sb.convertToSubasta());
		int lastId = sbs.getLastSubasta().getId();
		try {
			sbs.setMaxBidSubasta(lastId, 20000000F);
		} catch (Exception e) {
			fail();
		}
		Subasta sbb = sbs.getLastSubasta();
		sbs.deleteLastSubasta();
		assertEquals(20000000F,sbb.getOfertaMaxima());
	}

}
