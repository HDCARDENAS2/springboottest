package com.prueba.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.entity.Usuario;


/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByIdentificacion(String identificacion);
	
}
