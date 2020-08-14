package com.prueba.service;

import com.prueba.model.dto.UsuarioDTO;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
public interface IUsuarioService {

	UsuarioDTO saveUsuario(UsuarioDTO usuario) throws Exception;
	
}
