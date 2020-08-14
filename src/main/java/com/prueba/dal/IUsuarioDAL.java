package com.prueba.dal;

import com.prueba.model.dto.UsuarioDTO;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
public interface IUsuarioDAL {

	UsuarioDTO saveUsuario(UsuarioDTO usuario);
	
	UsuarioDTO findByIdentificacion(String identificacion);
	
}
