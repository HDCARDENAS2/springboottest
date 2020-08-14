package com.prueba.dal.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prueba.dal.IUsuarioDAL;
import com.prueba.model.dto.UsuarioDTO;
import com.prueba.model.mapper.UsuarioMapper;
import com.prueba.repository.UsuarioRepository;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */
@Repository
public class UsuarioDAO implements IUsuarioDAL {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	public UsuarioDTO saveUsuario(UsuarioDTO dataTransferObject) {

		try {
			return usuarioMapper.entityToDataTransferObject(
					usuarioRepository.save(usuarioMapper.dataTransferObjectToEntity(dataTransferObject)));

		} catch (Exception e) {
			logger.error(e.getClass().getName());
			throw e;
		}

	}

	@Override
	public UsuarioDTO findByIdentificacion(String identificacion) {

		try {

			return usuarioMapper.entityToDataTransferObject(usuarioRepository.findByIdentificacion(identificacion));

		} catch (Exception e) {
			logger.error(e.getClass().getName());
			throw e;
		}
	}

}
