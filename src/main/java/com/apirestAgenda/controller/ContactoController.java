package com.apirestAgenda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestAgenda.models.ContactoModel;
import com.apirestAgenda.services.ContactoServices;

@RestController
@RequestMapping("/contacto")
public class ContactoController {
	@Autowired
	ContactoServices contactoServices;

	@GetMapping
	public ArrayList<ContactoModel> mostrarContactos() {
		return contactoServices.mostrarContactos();
	}

	@PostMapping
	public ContactoModel registrarContacto(@RequestBody ContactoModel contacto) {
		return this.contactoServices.registrarContacto(contacto);
	}

	@GetMapping(path = "/{id}")
	public Optional<ContactoModel> obtenerContactoPorId(@PathVariable("id") Long id) {
		return this.contactoServices.obtenerContactoPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	public String eliminarcontacto(@PathVariable("id") Long id) {
		//
		boolean ok = this.contactoServices.eliminarContacto(id);
		if (ok) {
			return "Contacto eliminado ::: ID:" + id;
		} else {
			return "No se pudo elimnar el contacto ::: ID: " + id;
		}

	}

}
