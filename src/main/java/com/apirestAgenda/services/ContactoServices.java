package com.apirestAgenda.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestAgenda.models.ContactoModel;
import com.apirestAgenda.repository.ContactoRepository;

@Service
public class ContactoServices {
	@Autowired
	ContactoRepository contactoRepository;

	public ArrayList<ContactoModel> mostrarContactos() {
		return (ArrayList<ContactoModel>) contactoRepository.findAll();
	}

	public ContactoModel registrarContacto(ContactoModel contacto) {
		return contactoRepository.save(contacto);
	}

	public Optional<ContactoModel> obtenerContactoPorId(Long id) {
		return contactoRepository.findById(id);
	}

	public boolean eliminarContacto(Long id) {
		try {
			contactoRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}

	}
}
