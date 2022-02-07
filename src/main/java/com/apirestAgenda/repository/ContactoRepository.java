package com.apirestAgenda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirestAgenda.models.ContactoModel;

@Repository
public interface ContactoRepository extends CrudRepository<ContactoModel, Long> {

}
